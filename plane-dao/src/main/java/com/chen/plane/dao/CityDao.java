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
