package com.chen.plane.controller;

import com.chen.plane.domain.pojo.*;
import com.chen.plane.domain.query.PlanePoolQueryObj;
import com.chen.plane.service.CityService;
import com.chen.plane.service.TicketService;
import com.chen.plane.util.web.RequestUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 票信息Controller
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/2/2
 */
@Controller
@RequestMapping(value = "/plane/ticket")
public class TicketController extends BaseController{
	private static final Logger log = Logger.getLogger(TicketController.class);
	@Autowired
	private CityService cityService;
	@Autowired
	private TicketService ticketService;
	/**
	 * 订票首页
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/ticketMain.do",method = RequestMethod.GET)
	public String ticketMain(ModelMap modelMap,HttpServletRequest request){
		log.debug("TicketController.ticketMain>>>");
		List<City> cityList = cityService.getAllCity();
		User user = getUserWithNotLoginException(request);
		modelMap.addAttribute("userInfo",user);
		modelMap.addAttribute("allCity",cityList);
		log.debug("TicketController.ticketMain<<<");
		return "/ticket/ticketMain";
	}

	/**
	 * 根据条件查询获得机票列表
	 * @param planePoolQueryObj
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/queryTicket.do",method = RequestMethod.POST)
	public String queryTicket(PlanePoolQueryObj planePoolQueryObj,ModelMap modelMap,HttpServletRequest request) throws ParseException {
		log.debug("TicketController.queryTicket>>>");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(planePoolQueryObj.getViewStartPlaneTime() != null && !planePoolQueryObj.getViewStartPlaneTime().equals("")){
			planePoolQueryObj.setStartPlaneTime(dateFormat.parse(planePoolQueryObj.getViewStartPlaneTime()));
		}
		System.out.println("ticketList:" + planePoolQueryObj);
		List<PlanePool> planePoolList = ticketService.getPlanePollByCondition(planePoolQueryObj);
		if (planePoolList != null){
			modelMap.addAttribute("ticketList",planePoolList);
		}
		User user = getUserWithNotLoginException(request);
		modelMap.addAttribute("userInfo",user);
		modelMap.addAttribute("queryObj",planePoolQueryObj);
		List<City> cityList = cityService.getAllCity();
		log.debug("TicketController.queryTicket<<<");
		return "/ticket/ticketMain";
	}

	/**
	 * 选座
	 * @return
	 */
	@RequestMapping(value = "/selectSeat.do",method = RequestMethod.GET)
	public String selectSeat(@RequestParam("cabinId") Integer cabinId,ModelMap modelMap){
		log.debug("TicketController.selectSeat(ticketPoolId : "+ cabinId +")>>>");
		PlaneFirst planeFirst = ticketService.getPlaneFirst(cabinId);
		log.debug("planeFirst:" + planeFirst);
		modelMap.addAttribute("cabinInfo",planeFirst);
		log.debug("TicketController.selectSeat<<<");
		return  "/ticket/selectSeat";
	}

	/**
	 * 选中座位结算
	 * @return
	 */
	@RequestMapping(value = "/seatAccount.do", method = RequestMethod.POST)
	public String seatAccount(PlaneFirst planeFirst,HttpServletRequest request,ModelMap modelMap){
		log.debug("TicketController.seatAccount(planeFirst:" + planeFirst + ">>>");
		try{
			planeFirst.setUserId(getUserWithNotLoginException(request).getUserId());
			ticketService.addTicket(planeFirst, RequestUtil.getRealIP(request));
			Ticket ticket = new Ticket();
			ticket.setUserId(getUserWithNotLoginException(request).getUserId());
			List<Ticket> ticketList = ticketService.getTicketByUser(ticket);
			modelMap.addAttribute("ticketList", ticketList);
		}catch (Exception e){
			e.printStackTrace();
		}
		log.debug("TicketController.seatAccount<<<");
		return "/user/userTicketCenter";
	}

	/**
	 * 用户订单中心
	 * @return
	 */
	@RequestMapping(value = "/userTicketCenter.do",method = RequestMethod.GET)
	public String userTicketCenter(HttpServletRequest request,ModelMap modelMap){
		log.debug("TicketController.userTicketCenter>>>");
		Ticket ticket = new Ticket();
		ticket.setUserId(getUserWithNotLoginException(request).getUserId());
		List<Ticket> ticketList = ticketService.getTicketByUser(ticket);
		modelMap.addAttribute("ticketList",ticketList);
		log.debug("TicketController.userTicketCenter<<<");
		return "";
	}
}
