package com.chen.plane.dao;

import com.chen.plane.domain.pojo.PlaneFirst;

/**
 * 舱室信息dao
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/4/24
 */
public interface PlaneFirstDao {
	/**
	 * 获得飞机舱室售卖信息
	 * @param planeFirstId
	 * @return
	 */
	PlaneFirst getPlaneFirstById(Integer planeFirstId);

	/**
	 * 更新飞机舱室售卖信息
	 * @param planeFirst
	 */
	void updatePlaneFirstById(PlaneFirst planeFirst);
}
