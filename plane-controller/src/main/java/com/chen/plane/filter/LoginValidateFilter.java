package com.chen.plane.filter;

import com.chen.plane.domain.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 判断是否登录拦截器
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/2/3
 */
public class LoginValidateFilter implements Filter {
	@Override public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		User user = (User) ((HttpServletRequest) request).getSession().getAttribute("user");
		
		//将请求下传
		chain.doFilter(httpServletRequest,httpServletResponse);
	}

	@Override public void destroy() {

	}
}
