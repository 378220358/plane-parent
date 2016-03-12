package com.chen.plane.filter;

import com.alibaba.fastjson.JSON;
import com.chen.plane.constant.user.UserLoginConstant;
import com.chen.plane.domain.pojo.User;
import com.chen.plane.util.oauth.OAuthConfig;
import com.chen.plane.util.redis.RedisClient;
import com.chen.plane.util.web.RequestUtil;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 判断是否登录拦截器
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/2/3
 */
public class LoginValidateFilter implements Filter {
	private static final Logger log = Logger.getLogger(LoginValidateFilter.class);
	String encoding = "utf-8";
	private static OAuthConfig oAuthConfig;
	@Autowired
	private RedisClient redisClient;
	@Override public void init(FilterConfig filterConfig) throws ServletException {
		log.debug("LoginValidateFilter.init>>>");
		encoding = filterConfig.getInitParameter("encoding");
		try {
			oAuthConfig = (OAuthConfig) new FileSystemXmlApplicationContext("classpath:user/oauth-config.xml").getBean("oAuthConfig");
		}catch (Exception e){
			e.printStackTrace();
			log.debug("LoginValidateFilter.init error" + e.getMessage());
		}
	}

	@Override public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		log.debug("LoginValidateFilter.doFilter>>>");
		request.setCharacterEncoding(encoding);
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		String referUrl = RequestUtil.getReferUrl(httpServletRequest);
		String realIP = RequestUtil.getRealIP(httpServletRequest);
		String url = RequestUtil.getFullRequestStr(httpServletRequest);
		String uri = StringUtils.replace(new UrlPathHelper().getLookupPathForRequest(httpServletRequest), "//", "/");
		log.debug("---------------------------------------------");
		log.debug("Request-[referUrl: " + referUrl + "]");
		log.debug("Request-[realIP: " + realIP + "]");
		log.debug("Request-[url: " + url + "]");
		log.debug("Request-[uri: " + uri + "]");
		log.debug("---------------------------------------------");
		if (oAuthConfig.exclude(referUrl)){
			chain.doFilter(httpServletRequest,httpServletResponse);
		}else {
			Cookie[] cookies = httpServletRequest.getCookies();
			if (ArrayUtils.isEmpty(cookies)){
				httpServletRequest.getRequestDispatcher("/plane/user/login.do").forward(httpServletRequest,httpServletResponse);
				return;
			}
			Boolean isLoginFlag = false;
			for (Cookie cookie :cookies){
				if (StringUtils.equalsIgnoreCase(StringUtils.trim(cookie.getName()), UserLoginConstant.COOKIE_KEY)){
					String cookieValue = URLDecoder.decode(cookie.getValue());
					if (StringUtils.isEmpty(cookieValue)) {
						HashMap<String,Object> hashMap = JSON.parseObject(cookieValue , HashMap.class);
						String userName = (String) hashMap.get(UserLoginConstant.USER_LOGIN_NAME);
						String accessToken = (String) hashMap.get(UserLoginConstant.USER_ACCESS_TOKEN);
						log.debug("get userName from cookie : " + userName);
						Map<Object,Object> loginUserMap = redisClient.getHashMap(UserLoginConstant.REDIS_LOGIN_MAP_KEY);
						log.debug("get loginUserMap from redis : " + loginUserMap);
						if (MapUtils.isEmpty(loginUserMap)){
							User user = (User) MapUtils.getObject(loginUserMap,userName);
							log.debug("get from redis store user: " + user);
							if (StringUtils.equalsIgnoreCase(user.getAccessToken(),accessToken)){
								isLoginFlag = true;
							}
						}
					}
				}
			}
			if (isLoginFlag){
				chain.doFilter(httpServletRequest,httpServletResponse);
			}else {
				httpServletRequest.getRequestDispatcher("/plane/user/login.do").forward(httpServletRequest,httpServletResponse);
			}
		}

	}

	@Override public void destroy() {

	}
}
