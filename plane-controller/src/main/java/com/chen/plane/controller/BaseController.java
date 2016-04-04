package com.chen.plane.controller;

import com.alibaba.fastjson.JSON;
import com.chen.plane.cache.redis.RedisClient;
import com.chen.plane.constant.user.UserLoginConstant;
import com.chen.plane.domain.exception.MsgTipException;
import com.chen.plane.domain.pojo.User;
import com.chen.plane.util.date.DateFormatUtil;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 登录基础 Controller
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/3/14
 */
public class BaseController {
	private static final Logger log = Logger.getLogger(BaseController.class);
	@Autowired
	private RedisClient redisClient;
	/**
	 * 缓存用户登录状态
	 *
	 * @param response HTTP回应
	 * @param user     用户
	 */
	protected void cacheUserLoginState(User user, HttpServletResponse response) {
		log.debug(">>>BaseController.cacheUserLoginState()");
		if (user == null) {
			return;
		}
		try {
			// 得到数据参数
			String loginName = user.getUserName();
			String accessToken = generateAccessToken();
			Date accessTokenExpiryTime = DateUtils.addSeconds(new Date(), UserLoginConstant.COOKIE_AVAILABLE_TIME_LONG);
			String accessTokenExpiryTimeStr = DateFormatUtils.format(accessTokenExpiryTime, DateFormatUtil.ISO_DATE_TIME_FORMAT);
			user.setAccessToken(accessToken);
			user.setAccessTokenExpiryTime(accessTokenExpiryTime);
			log.debug("loginName is:" + loginName + ",accessToken is:" + accessToken + ",accessTokenExpiryTime is:" + accessTokenExpiryTimeStr);
			// 设置Cookie
			String cookieValue = "{'"+ "userId" + "':'" + user.getUserId() + "','" + UserLoginConstant.USER_LOGIN_FLAG + "':'" + loginName + "','" + UserLoginConstant.USER_LOGIN_FLAG + "':'" + loginName + "','" + UserLoginConstant.ACCESS_TOKEN_FLAG + "':'" + accessToken + "','accessTokenExpiryTime':'" + accessTokenExpiryTimeStr + "'}";
			Cookie cookie = new Cookie(UserLoginConstant.COOKIE_KEY, URLEncoder.encode(cookieValue));
			cookie.setMaxAge(UserLoginConstant.COOKIE_AVAILABLE_TIME_LONG);
			cookie.setPath(UserLoginConstant.COOKIE_PATH);
			response.addCookie(cookie);
			log.debug("set user login state to cookie finish");
			// 缓存到redis
			redisClient.setMapValue(UserLoginConstant.REDIS_LOGIN_MAP_KEY, loginName, user);
			log.debug("set user login state to redis finish");
		} catch (Exception e) {
			log.error("BaseController.cacheUserLoginState() has an error:" + e.getMessage());
			e.printStackTrace();
		}
		log.debug("<<<BaseController.cacheUserLoginState()");
	}

	/**
	 * 移除用户登录状态
	 *
	 * @param request HTTP请求
	 */
	protected void removeUserLoginState(HttpServletRequest request) {
		log.debug(">>>BaseController.removeUserLoginState()");
		Cookie[] cookies = request.getCookies();
		if (ArrayUtils.isEmpty(cookies)) {
			throw new MsgTipException("未登陆！");
		}
		for (Cookie cookie : cookies) {
			if (StringUtils.equalsIgnoreCase(StringUtils.trim(cookie.getName()), UserLoginConstant.COOKIE_KEY)) {
				String cookieValue = URLDecoder.decode(cookie.getValue());
				log.debug("get cookieValue from cookie:" + cookieValue);
				if (StringUtils.isNotEmpty(cookieValue)) {
					HashMap<String, Object> hashMap = JSON.parseObject(cookieValue, HashMap.class);
					String loginName = (String) hashMap.get(UserLoginConstant.USER_LOGIN_FLAG);
					String accessToken = (String) hashMap.get(UserLoginConstant.ACCESS_TOKEN_FLAG);
					log.debug("get loginName from cookieValue:" + loginName);
					Map<Object, Object> loginUserMap = redisClient.getHashMap(UserLoginConstant.REDIS_LOGIN_MAP_KEY);
					if (MapUtils.isNotEmpty(loginUserMap)) {
						User user = (User) MapUtils.getObject(loginUserMap, loginName);
						if (user == null) {
							return;
						}
						if (StringUtils.equalsIgnoreCase(user.getAccessToken(), accessToken)) {
							//							if (loginUserMap.remove(loginName) != null) {
							//								log.debug("remove login user form redis." + loginName);
							//								break;
							//							} else {
							//								throw new MsgTipException("管理员移除失败！");
							//							}
							//移除redis中的信息需用下面这种方式
							redisClient.removeMapValue(UserLoginConstant.REDIS_LOGIN_MAP_KEY, loginName);
						} else {
							throw new MsgTipException("令牌失效！");
						}
					}
				}
			} else {
				continue;
			}
		}
		log.debug("BaseController removeLoginMark <<<");
	}

	/**
	 * 获取用户信息
	 *
	 * @param request HTTP请求
	 * @return 用户
	 */
	protected User getUser(HttpServletRequest request) {
		User user = null;
		log.debug(">>>BaseController.getUser()");
		Cookie[] cookies = request.getCookies();
		if (ArrayUtils.isEmpty(cookies)) {
			return user;
		}
		for (Cookie cookie : cookies) {
			if (StringUtils.equalsIgnoreCase(StringUtils.trim(cookie.getName()), UserLoginConstant.COOKIE_KEY)) {
				String cookieValue = URLDecoder.decode(cookie.getValue());
				log.debug("get cookieValue from cookie:" + cookieValue);
				if (StringUtils.isNotEmpty(cookieValue)) {
					HashMap<String, Object> hashMap = JSON.parseObject(cookieValue, HashMap.class);
					String loginName = (String) hashMap.get(UserLoginConstant.USER_LOGIN_FLAG);
					log.debug("userId : " + hashMap.get("userId"));
					Integer userId = Integer.valueOf((String)hashMap.get("userId"));
					log.debug("get loginName from cookieValue:" + loginName);
					Map<Object, Object> loginUserMap = redisClient.getHashMap(UserLoginConstant.REDIS_LOGIN_MAP_KEY);
					if (loginUserMap != null) {
						user = (User) MapUtils.getObject(loginUserMap, loginName);
					}
					user = new User();
					user.setUserName(loginName);
					user.setUserId(userId);
				}
				break;
			} else {
				continue;
			}
		}
		log.debug("<<<BaseController.getUser(" + user + ")");
		return user;
	}

	/**
	 * 获取用户信息
	 *
	 * @param request HTTP请求
	 * @return 用户
	 */
	protected User getUserWithNotLoginException(HttpServletRequest request) {
		User user = this.getUser(request);
		if (user == null) {
			throw new MsgTipException("未登陆！");
		}
		return user;
	}

	private String generateAccessToken() {
		return UUID.randomUUID().toString();
	}
}
