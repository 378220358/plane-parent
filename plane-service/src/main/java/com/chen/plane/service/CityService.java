package com.chen.plane.service;

import com.chen.plane.domain.pojo.City;

import java.util.List;

/**
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/3/17
 */
public interface CityService {
	/**
	 * 获得所有的城市
	 * @return
	 */
	List<City> getAllCity();

	/**
	 * 增加城市
	 * @param city
	 */
	void addCity(City city);
	/**
	 * 根据城市ID获得城市信息
	 * @param cityId
	 * @return
	 */
	City getCityById(Integer cityId);

	/**
	 * 更新城市信息
	 * @param city
	 */
	void updateCity(City city);

	/**
	 * 根据城市ID删除城市
	 * @param cityId
	 */
	void deleteCity(Integer cityId);
}
