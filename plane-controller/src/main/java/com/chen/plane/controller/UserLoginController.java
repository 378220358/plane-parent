package com.chen.plane.controller;

import com.chen.plane.domain.pojo.User;
import com.chen.plane.service.UserService;
import com.chen.plane.service.impl.UserServiceImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
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
	@RequestMapping(value = "/index.do",method = RequestMethod.GET)
	public String index(){
		log.debug("UserLoginController.index>>>");
		log.debug("UserLoginController.index<<<");
		return "/user/login";
	}
	@RequestMapping(value = "/login.do",method = RequestMethod.POST)
	public String login(User user,ModelMap modelMap){
		log.debug("UserLoginController.login>>>");
		if (user == null){
			return "/user/register";
		}
		if (userService.getUserById(user) != null){
			return "/main/main";
		}else{
			modelMap.addAttribute("loginInfo","用户名或密码错误");
			return "/user/login";
		}
	}
	@RequestMapping(value = "/registerIndex.do",method = RequestMethod.GET)
	public String registerIndex(User user){
		log.debug("UserLoginController.registerIndex>>>");
		log.debug("UserLoginController.registerIndex<<<");
		return "/user/register";
	}

}
