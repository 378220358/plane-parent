package com.chen.plane.controller;

import com.chen.plane.dao.BGUserDao;
import com.chen.plane.dao.CityDao;
import com.chen.plane.dao.PlaneTicketDao;
import com.chen.plane.domain.pojo.Admin;
import com.chen.plane.domain.pojo.BGUser;
import com.chen.plane.domain.pojo.City;
import com.chen.plane.domain.pojo.PlaneTicket;
import com.chen.plane.domain.rpc.AppServerResult;
import com.chen.plane.service.BGUserService;
import com.chen.plane.service.CityService;
import com.chen.plane.service.PlaneTicketService;
import com.chen.plane.service.TicketService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

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
	@Autowired
	private PlaneTicketService planeTicketService;
	@Autowired
	private BGUserService bgUserService;

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
	 * @param
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login.do",method = RequestMethod.POST)
	public String adminLogin(BGUser bgUser,HttpSession session){
		log.debug("AdminController.adminLogin>>>");
		log.debug("admin:" + bgUser);
		BGUser bgUser1 = bgUserService.getBGUser(bgUser);
		if (bgUser1 != null){
			session.setAttribute("admin",bgUser1);
			log.debug("BGUser:" + bgUser1);
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
	public String adminMainIndex(ModelMap modelMap,HttpSession session){
		log.debug("AdminController.adminMainIndex<<<");
		if (session.getAttribute("admin") != null){
			modelMap.addAttribute("admin", session.getAttribute("admin"));
			return  "/admin/adminMain";
		}
		log.debug("AdminController.adminMainIndex<<<");
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
	public String addCity(City city,HttpSession session,ModelMap modelMap){
		BGUser bgUser = (BGUser) session.getAttribute("admin");
		if (bgUser != null && (bgUser.getBGRole().equals("ADMIN") || bgUser.getBGRole().equals("COMMON"))){
			cityService.addCity(city);
			List<City> cityList = cityService.getAllCity();
			modelMap.addAttribute("cityList",cityList);
			return "/admin/CityList";
		}else {
			return "/admin/noRole";
		}
	}

	/**
	 * 跳转增加航班信息首页
	 * @return
	 */
	@RequestMapping(value = "/addPlaneTicketIndex.do",method = RequestMethod.GET)
	public String addPlaneTicketIndex(ModelMap modelMap){
		log.debug("AdminController.addPlaneTicketIndex>>>");
		modelMap.addAttribute("cityList",cityService.getAllCity());
		log.debug("AdminController.addPlaneTicketIndex<<<");
		return  "/admin/addPlaneTicket";
	}

	/**
	 * 保存增加的航班信息
	 * @param planeTicket
	 * @return
	 */
	@RequestMapping(value = "/addPlaneTicket.do",method = RequestMethod.POST)
	public String addPlaneTicket(PlaneTicket planeTicket,ModelMap modelMap,HttpSession session) throws ParseException {
		log.debug("AdminController.addPlaneTicket>>>");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		planeTicket.setPlaneStartTime(dateFormat.parse(planeTicket.getPlaneStartTimeString()));
		BGUser bgUser = (BGUser) session.getAttribute("admin");
		if (bgUser != null && (bgUser.getBGRole().equals("ADMIN") || bgUser.getBGRole().equals("COMMON"))){
			ticketService.addPlaneTicket(planeTicket);
			modelMap.addAttribute("planeList", planeTicketService.getAllPlaneTicket());
			return "/admin/planeTicketList";
		}else {
			return "/admin/noRole";
		}

	}
	/**
	 * 获得所有的城市
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/getAllCity.do",method = RequestMethod.GET)
	public String getAllCity(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		log.debug("CityController.getAllCity>>>");
		AppServerResult appServerResult = AppServerResult.generateSuccessResult();
		try {
			List<City> cityList = cityService.getAllCity();
			modelMap.addAttribute("cityList",cityList);
		}catch (Exception e){
			e.printStackTrace();
			appServerResult = AppServerResult.generateFailureResult();
		}
		log.debug("CityController.getAllCity<<<");
		return "/admin/CityList";
	}

	/**
	 * 获得所有的航班信息
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/getAllPlaneTicket.do",method = RequestMethod.GET)
	public String getAllPlaneTicket(ModelMap modelMap){
		log.debug("AdminController.getAllPlaneTicket>>>");
		List<PlaneTicket> planeTicketList = planeTicketService.getAllPlaneTicket();
		modelMap.addAttribute("planeList", planeTicketList);
		log.debug("AdminController.getAllPlaneTicket<<<");
		return "/admin/planeTicketList";
	}

	/**
	 * 更新城市信息首页
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/updateCityIndex.do" ,method = RequestMethod.GET)
	public String updateCityIndex(Integer cityId,ModelMap modelMap,HttpSession session){
		log.debug("AdminController.updateCity>>>");
		City city = cityService.getCityById(cityId);
		modelMap.addAttribute("city",city);
		log.debug("AdminController.updateCityIndex<<<");
		return "/admin/updateCity";
	}

	/**
	 * 更新城市
	 * @param city
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/updateCity.do",method = RequestMethod.POST)
	public String updateCity(City city,ModelMap modelMap,HttpSession session){
		log.debug("AdminController.updateCity(City:"+city+")>>>");
		BGUser bgUser = (BGUser) session.getAttribute("admin");
		if (bgUser != null && (bgUser.getBGRole().equals("ADMIN") || bgUser.getBGRole().equals("COMMON"))){
			cityService.updateCity(city);
			List<City> cityList = cityService.getAllCity();
			modelMap.addAttribute("cityList",cityList);
			log.debug("AdminController.updateCity<<<");
			return "/admin/CityList";
		}else {
			return "/admin/noRole";
		}

	}

	/**
	 * 根据城市ID删除城市
	 * @param cityId
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/deleteCity.do",method = RequestMethod.GET)
	public String deleteCity(Integer cityId,ModelMap modelMap,HttpSession session){
		log.debug("AdminController.deleteCity>>>");
		BGUser bgUser = (BGUser) session.getAttribute("admin");
		if (bgUser != null && (bgUser.getBGRole().equals("ADMIN") || bgUser.getBGRole().equals("COMMON"))){
			cityService.deleteCity(cityId);
			List<City> cityList = cityService.getAllCity();
			modelMap.addAttribute("cityList", cityList);
			log.debug("AdminController.deleteCity<<<");
			return "/admin/CityList";
		}
		return "/admin/noRole";
	}

	/**
	 * 删除航班信息
	 * @param planeId
	 * @return
	 */
	@RequestMapping(value = "/updatePlaneTicketIndex.do",method = RequestMethod.GET)
	public String updatePlaneTicket(Integer planeId,ModelMap modelMap,HttpSession session){
		log.debug("AdminController.updatePlaneTicket>>>");
		BGUser bgUser = (BGUser) session.getAttribute("admin");
		if (bgUser != null && (bgUser.getBGRole().equals("ADMIN") || bgUser.getBGRole().equals("COMMON"))){
			PlaneTicket planeTicket = planeTicketService.getPlaneTicket(planeId);
			modelMap.addAttribute("plane",planeTicket);
			modelMap.addAttribute("cityList",cityService.getAllCity());
			log.debug("AdminController.updatePlaneTicket<<<");
			return "/admin/updatePlaneTicket";
		}else {
			return "/admin/noRole";
		}
	}

	/**
	 * 删除航班信息
	 * @param planeId
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/deletePlaneTicket.do",method = RequestMethod.GET)
	public String deletePlaneTicket(Integer planeId,ModelMap modelMap,HttpSession session){
		log.debug("AdminController.deletePlaneTicket>>>");
		BGUser bgUser = (BGUser) session.getAttribute("admin");
		if (bgUser != null && (bgUser.getBGRole().equals("ADMIN") || bgUser.getBGRole().equals("COMMON"))){
			planeTicketService.deletePlaneTicket(planeId);
			List<PlaneTicket> planeTicketList = planeTicketService.getAllPlaneTicket();
			modelMap.addAttribute("planeList", planeTicketList);
			log.debug("AdminController.deletePlaneTicket<<<");
			return "/admin/planeTicketList";
		}else {
			return "/admin/noRole";
		}

	}

	/**
	 * 更新航班信息
	 * @param planeTicket
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/updatePlaneTicket.do",method = RequestMethod.POST)
	public String updatePlaneTicket(PlaneTicket planeTicket,ModelMap modelMap,HttpSession session) throws ParseException {
		log.debug("AdminController.updatePlaneTicket>>>");
		log.debug("planeTicket:" + planeTicket);
		BGUser bgUser = (BGUser) session.getAttribute("admin");
		if (bgUser != null && (bgUser.getBGRole().equals("ADMIN") || bgUser.getBGRole().equals("COMMON"))){
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			planeTicket.setPlaneStartTime(dateFormat.parse(planeTicket.getPlaneStartTimeString()));
			planeTicket.setPlaneEndTime(dateFormat.parse(planeTicket.getPlaneEndTimeString()));
			planeTicketService.updatePlaneTicket(planeTicket);
			List<PlaneTicket> planeTicketList = planeTicketService.getAllPlaneTicket();
			modelMap.addAttribute("planeList", planeTicketList);
			log.debug("AdminController.updatePlaneTicket<<<");
			return "/admin/planeTicketList";
		}else {
			return "/admin/noRole";
		}
	}

	/**
	 * 获得所有的飞机售卖信息
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/planeInfoList.do",method = RequestMethod.GET)
	public String getPlaneInfoList(ModelMap modelMap){
		log.debug("AdminController.getPlaneInfoList>>>");
		List<PlaneTicket> planeTicketList = planeTicketService.getPlaneTicketInfo();
		modelMap.addAttribute("planeList",planeTicketList);
		log.debug("AdminController.getPlaneInfoList<<<");
		return "/admin/planeInfoList";
	}
}
