package com.chen.plane.controller;

import com.chen.plane.dao.CityDao;
import com.chen.plane.dao.PlaneTicketDao;
import com.chen.plane.domain.pojo.Admin;
import com.chen.plane.domain.pojo.City;
import com.chen.plane.domain.pojo.PlaneTicket;
import com.chen.plane.service.CityService;
import com.chen.plane.service.TicketService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
	@Autowired
	private TicketService ticketService;

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
	 * 后台首页跳转
	 * @return
	 */
	@RequestMapping(value = "/adminMainIndex.do",method = RequestMethod.GET)
	public String adminMainIndex(){
		log.debug("AdminController.adminMainIndex<<<");
		log.debug("AdminController.adminMainIndex<<<");
		return  "/admin/adminMain";
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

	/**
	 * 跳转增加航班信息首页
	 * @return
	 */
	@RequestMapping(value = "/addPlaneTicketIndex.do",method = RequestMethod.GET)
	public String addPlaneTicketIndex(){
		log.debug("AdminController.addPlaneTicketIndex>>>");
		log.debug("AdminController.addPlaneTicketIndex<<<");
		return  "/admin/addPlaneTicket";
	}

	/**
	 * 保存增加的航班信息
	 * @param planeTicket
	 * @return
	 */
	@RequestMapping(value = "/addPlaneTicket.do",method = RequestMethod.POST)
	public String addPlaneTicket(PlaneTicket planeTicket) throws ParseException {
		log.debug("AdminController.addPlaneTicket>>>");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		planeTicket.setPlaneStartTime(dateFormat.parse(planeTicket.getPlaneStartTimeString()));
		planeTicket.setPlaneEndTime(dateFormat.parse(planeTicket.getPlaneEndTimeString()));
		ticketService.addPlaneTicket(planeTicket);
		log.debug("AdminController.addPlaneTicket<<<");
		return "/admin/adminMain";
	}
}
