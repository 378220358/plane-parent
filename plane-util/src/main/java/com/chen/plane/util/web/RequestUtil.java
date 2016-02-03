package com.chen.plane.util.web;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * request工具类，针对request进行解析的方法
 * 
 * @author majun
 *
 */
public class RequestUtil {

	// HTTP标准头
	public static final String HEADER_USER_AGENT = "user-agent";

	public static final String HEADER_REFER = "referer";

	/**
	 * 获取request的ip地址信息
	 * 
	 * @param request
	 * @return
	 */
	public static String getRealIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}

		int pos = ip.indexOf(",");
		int startPos = 0;

		while (pos > 0) {
			String ip1 = ip.substring(startPos, pos).trim();

			if (ip1.length() > 0 && !"unknown".equalsIgnoreCase(ip1)) {
				return ip1;
			}

			startPos = pos + 1;
			pos = ip.indexOf(",", startPos);
		}

		return ip;
	}

	/**
	 * 获取request信息
	 * 
	 * @param req
	 * @return
	 */
	public static String getRequestInfo(HttpServletRequest req) {
		StringBuffer sb = new StringBuffer(320);
		sb.append("[Req]");
		sb.append(req.getClass().getName());
		sb.append(": (").append(req.getScheme()).append(')').append(req.getServerName()).append(':').append(req.getServerPort());
		sb.append(", ").append(req.getMethod()).append(' ').append(req.getProtocol());
		sb.append(", uri=").append(req.getRequestURI());
		sb.append(", ctx=").append(req.getContextPath());
		sb.append(", servlet=").append(req.getServletPath());
		sb.append(", qryStr=").append(req.getQueryString());
		sb.append(", refer=").append(req.getHeader(HEADER_REFER));
		sb.append(", useragt=").append(req.getHeader(HEADER_USER_AGENT));
		sb.append(", ip=").append(req.getRemoteAddr());
		return sb.toString();
	}

	/**
	 * 获取给定的request中全部的Header信息.
	 * 
	 * @param req 给定的request
	 * @return 全部Header信息构成的字符串.
	 */
	public static String getAllHeadersStr(HttpServletRequest req) {
		StringBuffer sb = new StringBuffer(256);
		String header = null;
		for (Enumeration headers = req.getHeaderNames(); headers.hasMoreElements();) {
			header = (String) headers.nextElement();
			sb.append(header);
			sb.append("=");
			sb.append(req.getHeader(header));
			sb.append("\r\n");
		}
		return sb.toString();
	}

	/**
	 * 获取给定的Http请求的Referer URL, 即上一个页面.
	 * 
	 * @param req 给定的Http请求
	 * @return 给定Http请求的referer头的值. 如果不存在, 返回null.
	 */
	public static String getReferUrl(HttpServletRequest req) {
		return req.getHeader(HEADER_REFER);
	}

	/**
	 * 获取指定request的完整URL请求, 包括全部参数项和值(GET方式和POST方式都适用). 该方法会影响request中的编码.
	 * 
	 * @param rq 指定的request
	 * @return 表示URL请求的字符串, 包括完整URL和提交的全部参数项和值
	 * @see #getParamString(HttpServletRequest)
	 */
	public static String getFullRequestStr(HttpServletRequest rq) {
		return new StringBuffer(256).append(rq.getRequestURL()).append(getParamString(rq)).toString();
	}

	/**
	 * 获取指定request的全部参数项和值. 该方法会影响request中的编码.
	 * 
	 * @param rq 指定的request
	 * @return 全部参数项和值构成的字符串
	 */
	public static String getParamString(HttpServletRequest rq) {
		StringBuffer sb = new StringBuffer(256);
		int i = 0;
		for (Enumeration params = rq.getParameterNames(); params.hasMoreElements();) {
			String param = (String) params.nextElement();
			sb.append((++i) == 1 ? "?" : "&").append(param).append("=").append(rq.getParameter(param));
		}
		return sb.toString();
	}

	/**
	 * Return the webapp root path.<br> Example:<br> if request "http://localhost:8080/shop/test/test1.jsp", the method return "http://localhost:8080/shop".
	 */
	public static String getContextRoot(HttpServletRequest request) {
		final String sysUrl = request.getRequestURL().toString();
		final String servletPath = request.getServletPath();
		final int servletPathIndex = sysUrl.indexOf(servletPath);
		if (servletPathIndex == -1) {
			return sysUrl;
		}
		return sysUrl.substring(0, servletPathIndex);
	}

	/**
	 * for Dynamic Pages, this method as same as <code>req.getServletPath()</code>, but the method also valid for Static Content, such as html, gif, css etc.<br> Example:<br> if request "http://localhost:8080/shop/test/test1.jsp", the method return "/test/test1.jsp".
	 * 
	 * @param req the spec request
	 * @return the relative url
	 */
	public static String getRelativePath(HttpServletRequest req) {
		return req.getRequestURI().substring(req.getContextPath().length());
	}

	/**
	 * 检测请求是否来自搜索引擎
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isRobotRequest(HttpServletRequest request) {
		String userAgent = request.getHeader("User-Agent");
		if (userAgent == null)
			return false;

		userAgent = userAgent.toLowerCase();

		if (userAgent.indexOf("spider") != -1) {
			return true;
		} else if (userAgent.indexOf("bot") != -1) {
			return true;
		} else if (userAgent.indexOf("nutch") != -1) {
			return true;
		} else if (userAgent.indexOf("yahoo") != -1) {
			return true;
		} else if (userAgent.indexOf("gougou") != -1) {
			return true;
		} else if (userAgent.indexOf("scooter") != -1) {
			return true;
		} else if (userAgent.indexOf("lilina") != -1) {
			return true;
		}

		return false;
	}
}
