package com.chen.plane.service.impl;

import com.chen.plane.dao.CityDao;
import com.chen.plane.domain.pojo.City;
import com.chen.plane.service.CityService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/3/17
 */
@Service
public class CityServiceImpl implements CityService {
	private static final Logger log = Logger.getLogger(CityServiceImpl.class);
	@Autowired
	private CityDao cityDao;

	/**
	 * 获得所有城市列表
	 * @return
	 */
	@Override public List<City> getAllCity() {
		log.debug("CityServiceImpl.getAllCity>>>");
		List<City> cityList = cityDao.getAllCity();
		log.debug("CityServiceImpl.getAllCity<<<");
		return cityList;
	}
}
