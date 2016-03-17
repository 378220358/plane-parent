package com.chen.plane.controller;

import com.chen.plane.domain.pojo.City;
import com.chen.plane.domain.rpc.AppServerResult;
import com.chen.plane.service.CityService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 城市相关Controller
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/3/17
 */
@Controller
@RequestMapping(value = "/plane/city")
public class CityController {
	private static final Logger log = Logger.getLogger(CityController.class);
	@Autowired
	private CityService cityService;
	/**
	 * 获得所有的城市
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/getAllCity.do",method = RequestMethod.GET)
	public String getAllCity(HttpServletRequest request,HttpServletResponse response){
		log.debug("CityController.getAllCity>>>");
		AppServerResult appServerResult = AppServerResult.generateSuccessResult();
		try {
			List<City> cityList = cityService.getAllCity();
			appServerResult.setData(cityList);
		}catch (Exception e){
			e.printStackTrace();
			appServerResult = AppServerResult.generateFailureResult();
		}
		log.debug("CityController.getAllCity<<<");
		return null;
	}
}
