package com.chen.plane.controller;

import com.chen.plane.domain.pojo.User;
import com.chen.plane.domain.rpc.AppServerResult;
import com.chen.plane.service.UserService;
import com.chen.plane.service.impl.UserServiceImpl;

import com.chen.plane.util.json.JSONConvertUtil;
import com.chen.plane.util.web.ResponseUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录Controller
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/1/28
 */
@Controller
@RequestMapping(value = "/plane/user")
public class UserLoginController {
	private static final Logger log = Logger.getLogger(UserLoginController.class);
	@Autowired
	private UserService userService;

	/**
	 * 登录首页
	 * @return
	 */
	@RequestMapping(value = "/index.do",method = RequestMethod.GET)
	public String index(){
		log.debug("UserLoginController.index>>>");
		log.debug("UserLoginController.index<<<");
		return "/user/login";
	}

	/**
	 * 进行登录验证
	 * @param user
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/login.do",method = RequestMethod.POST)
	public String login(User user,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response) throws JsonProcessingException {
		log.debug("UserLoginController.login>>>");
		AppServerResult appServerResult = AppServerResult.generateSuccessResult();
		if (user == null) {
			appServerResult = AppServerResult.generateFailureResult();
			appServerResult.setData("用户名或密码为空!");
		}
		if (userService.getUserById(user) != null) {
			appServerResult.setData("登录成功！");
		} else {
			appServerResult = AppServerResult.generateFailureResult();
			appServerResult.setData("用户名或密码错误！");
		}
		ResponseUtils.printJsonData(response, JSONConvertUtil.convertObjectToJSONString(appServerResult));
		return null;
	}

	/**
	 * 注册首页
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/registerIndex.do",method = RequestMethod.GET)
	public String registerIndex(User user){
		log.debug("UserLoginController.registerIndex>>>");
		log.debug("UserLoginController.registerIndex<<<");
		return "/user/register";
	}

}
