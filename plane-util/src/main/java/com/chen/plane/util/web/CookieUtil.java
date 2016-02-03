package com.chen.plane.util.web;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Cookie操作工具类
 *
 * @author 谢继永 (xiejy@asiainfo.com) <p> EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
 * @version 1.0 2014-12-4 上午11:06:20
 */
public class CookieUtil {

	public static final Logger log = Logger.getLogger(CookieUtil.class);
	// 设置Cookie Key
	public static final String TINYHOUSE_COOKIE_KEY = "tinyhouse";
	// 设置Cookie有效期
	public static final int MAX_AGE = Integer.MAX_VALUE;
	// 设置Cookie 路径
	public static final String PATH = "/";

	/**
	 * 设置Cookie
	 * @param response http相应
	 * @param key key
	 * @param value 值
	 */
	public static void setCookie(HttpServletResponse response, String key ,String value,int maxAge) {
		log.debug(">>>CookieUtil.setCookie(key," + key + ",value=" + value + ")");
		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
		log.debug("<<<CookieUtil.setCookie()");
	}

	/**
	 * 获取Cookie
	 * 
	 * @author 谢继永 (xiejy@asiainfo.com) <p> EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
	 * @version 1.0 2014-12-4 下午1:51:49
	 * @param request
	 * @return Map<String,String>
	 */
	public static Map<String, String> getCookie(HttpServletRequest request) {
		log.debug(">>>CookieUtil.getCookie(request,response)");
		Map<String, String> mapCookie = new HashMap<String, String>();
		Cookie[] cookies = request.getCookies();
		String keyValue = "";
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (StringUtils.equalsIgnoreCase(cookies[i].getName().trim(), TINYHOUSE_COOKIE_KEY)) {
					keyValue = URLDecoder.decode(cookies[i].getValue());
				} else {
					continue;
				}
			}
		}
		if (StringUtils.isNotBlank(keyValue)) {
			JSONObject json = JSONObject.fromObject(keyValue);
			Iterator<String> it = json.keys();
			String mapKey = "";
			while (it.hasNext()) {
				mapKey = it.next();
				mapCookie.put(mapKey, json.get(mapKey).toString());
			}
		}
		log.debug("<<<CookieUtil.getCookie(request,response)");
		return mapCookie;
	}
}
