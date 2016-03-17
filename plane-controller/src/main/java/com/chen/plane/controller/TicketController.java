package com.chen.plane.controller;

import com.chen.plane.domain.pojo.City;
import com.chen.plane.service.CityService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 票信息Controller
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/2/2
 */
@Controller
@RequestMapping(value = "/plane/ticket")
public class TicketController {
	private static final Logger log = Logger.getLogger(TicketController.class);
	@Autowired
	private CityService cityService;

	/**
	 * 订票首页
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/ticketMain.do",method = RequestMethod.GET)
	public String ticketMain(ModelMap modelMap){
		log.debug("TicketController.ticketMain>>>");
		List<City> cityList = cityService.getAllCity();
		modelMap.addAttribute("allCity",cityList);
		log.debug("TicketController.ticketMain<<<");
		return "/ticket/ticketMain";
	}

	/**
	 * 选座
	 * @return
	 */
	@RequestMapping(value = "/selectSeat.do",method = RequestMethod.GET)
	public String selectSeat(){
		log.debug("TicketController.selectSeat>>>");
		log.debug("TicketController.selectSeat<<<");
		return  "/ticket/selectSeat";
	}
}
