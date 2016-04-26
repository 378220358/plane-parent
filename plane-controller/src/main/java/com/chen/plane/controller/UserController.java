package com.chen.plane.controller;

import com.chen.plane.domain.pojo.User;
import com.chen.plane.domain.rpc.AppServerResult;
import com.chen.plane.service.UserService;
import com.chen.plane.service.impl.UserServiceImpl;

import com.chen.plane.util.json.JSONConvertUtil;
import com.chen.plane.util.web.RequestUtil;
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
public class UserController extends BaseController{
	private static final Logger log = Logger.getLogger(UserController.class);
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
		String returnUrl = "/user/login";
		if (user == null) {
			return returnUrl;
		}
		User user1 = userService.getUserById(user);
		if (user1 != null) {
			cacheUserLoginState(user1,response);
			modelMap.addAttribute("userInfo", user1);
			returnUrl =  "/ticket/ticketMain";
		} else {
			modelMap.addAttribute("error", "用户名或密码错误");
		}
		return returnUrl;
	}

	/**
	 * 注册首页
	 * @return
	 */
	@RequestMapping(value = "/registerIndex.do",method = RequestMethod.GET)
	public String registerIndex(){
		log.debug("UserLoginController.registerIndex>>>");
		log.debug("UserLoginController.registerIndex<<<");
		return "/user/register";
	}

	/**
	 * 用户注册
	 * @param user
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/register.do",method = RequestMethod.POST)
	public String register(User user,HttpServletResponse response,ModelMap modelMap,HttpServletRequest request){
		log.debug("UserLoginController.register>>>");
		String registerUrl = "/user/login";
		try {
			if (user.getUserName() != null && !user.getUserName().equals("") && user.getUserPwd() != null && !user.getUserPwd().equals("")){
				user.setUserIp(RequestUtil.getRealIP(request));
				userService.registerUser(user);
			}else {
				modelMap.put("error","您输入用户名和密码为空，请重新输入");
				registerUrl = "/user/register";
			}
		}catch (Exception e){
			registerUrl = "/user/register";
			modelMap.addAttribute("error","系统发生异常，请稍后重试");
			e.printStackTrace();
		}
		log.debug("UserLoginController.register<<<");
		return registerUrl;
	}
	/**
	 * 用户中心
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/userCenter.do",method = RequestMethod.GET)
	public String userCenter(ModelMap modelMap,HttpServletRequest request,User user){
		log.debug("UserController.userCenter>>>");
		User user1 = getUserWithNotLoginException(request);
		log.debug("user:" + user1);
		user = userService.getUserInfoById(user1);
		log.debug("userAfter:" + user);
		modelMap.addAttribute("userInfo",user);
		log.debug("UserController.userCenter<<<");
		return "/user/userCenter";
	}

	/**
	 * 更新用户信息
	 * @param modelMap
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/updateUser.do",method = RequestMethod.POST)
	public String updateUser(ModelMap modelMap,User user){
		log.debug("UserController.updateUser<<<");
		log.debug("user : "+ user);
		try {
			userService.updateUser(user);
			modelMap.addAttribute("userInfo",user);
		}catch (Exception e){
			e.printStackTrace();
			log.debug("更新用户信息处异常啦！ error：" + e.getMessage());
		}
		return "/user/userCenter";
	}


}
