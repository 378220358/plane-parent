package com.chen.plane.service.impl;

import com.chen.plane.dao.CityDao;
import com.chen.plane.domain.pojo.City;
import com.chen.plane.service.CityService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

	/**
	 * 增加城市
	 * @param city
	 */
	@Override public void addCity(City city) {
		log.debug("CityServiceImpl.addCity>>>");
		List<City> cityList = new ArrayList<City>();
		cityList.add(city);
		cityDao.addBathCity(cityList);
		log.debug("CityServiceImpl.addCity<<<");
	}

	@Override public City getCityById(Integer cityId) {
		log.debug("CityServiceImpl.getCityById>>>");
		City city = cityDao.getCityById(cityId);
		log.debug("CityServiceImpl.getCityById<<<");
		return city;
	}

	@Override public void updateCity(City city) {
		log.debug("CityServiceImpl.updateCity>>>");
		cityDao.updateCity(city);
		log.debug("CityServiceImpl.updateCity<<<");

	}

	@Override public void deleteCity(Integer cityId) {
		log.debug("CityServiceImpl.deleteCity>>>");
		cityDao.deleteCity(cityId);
		log.debug("CityServiceImpl.deleteCity<<<");

	}

}
