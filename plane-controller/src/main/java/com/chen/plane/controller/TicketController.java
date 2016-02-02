package com.chen.plane.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	@RequestMapping(value = "/ticketMain.do",method = RequestMethod.GET)
	public String ticketMain(){
		log.debug("TicketController.ticketMain>>>");
		log.debug("TicketController.ticketMain<<<");
		return "/ticket/ticketMain";
	}
}
