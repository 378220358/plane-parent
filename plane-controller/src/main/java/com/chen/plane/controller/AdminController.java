package com.chen.plane.controller;

import com.chen.plane.dao.CityDao;
import com.chen.plane.domain.pojo.Admin;
import com.chen.plane.domain.pojo.City;
import com.chen.plane.service.CityService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/4/20
 */
@Controller
@RequestMapping(value = "/plane/admin")
public class AdminController {
	private static final Logger log = Logger.getLogger(AdminController.class);
	@Autowired
	private CityService cityService;

	/**
	 * 管理员登录首页
	 * @return
	 */
	@RequestMapping(value = "/loginIndex.do",method = RequestMethod.GET)
	public String adminIndex(){
		log.debug("AdminController.adminIndex>>>");
		log.debug("AdminController.adminIndex<<<");
		return "/admin/adminLogin";
	}

	/**
	 * 管理员登录表单提交
	 * @param admin
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login.do",method = RequestMethod.POST)
	public String adminLogin(Admin admin,HttpSession session){
		log.debug("AdminController.adminLogin>>>");
		log.debug("admin:" + admin);
		if (admin.getAdminName().trim().equals("admin") && admin.getAdminPwd().trim().equals("admin")){
			session.setAttribute("admin",admin);
			return  "/admin/adminMain";
		}
		log.debug("AdminController.adminLogin<<<");
		return "/admin/adminLogin";
	}

	/**
	 * 开通城市首页
	 * @return
	 */
	@RequestMapping(value = "/addCityIndex.do",method = RequestMethod.GET)
	public String addCityIndex(){
		log.debug("AdminController.addCityIndex>>>");
		log.debug("AdminController.addCityIndex<<<");
		return "/admin/addCity";
	}

	/**
	 * 开通城市
	 * @param city
	 * @return
	 */
	@RequestMapping(value = "/addCity.do",method = RequestMethod.POST)
	public String addCity(City city,HttpSession session){
		if (session.getAttribute("admin") != null){
			cityService.addCity(city);
			return "/admin/addCity";
		}
		return null;
	}
}
