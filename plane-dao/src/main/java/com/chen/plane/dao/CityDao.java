package com.chen.plane.dao;

import com.chen.plane.domain.pojo.City;

import java.util.List;

/**
 * 城市接口dao
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/2/2
 */
public interface CityDao {
	/**
	 * 获得所有的城市列表
	 * @return
	 */
	public List<City> getAllCity();

	/**
	 * 批量增加城市
	 */
	public void addBathCity(List<City> cityList);

	/**
	 * 根据城市名称获得城市ID
	 * @param cityName
	 * @return
	 */
	Integer getCityIdByCityName(String cityName);
}
