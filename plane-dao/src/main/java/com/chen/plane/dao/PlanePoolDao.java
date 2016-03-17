package com.chen.plane.dao;

import com.chen.plane.domain.pojo.PlanePool;
import com.chen.plane.domain.query.PlanePoolQueryObj;

import java.util.List;

/**
 * 票池dao接口
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/3/17
 */
public interface PlanePoolDao {
	/**
	 * 根据条件查询所有的票务信息
	 * @param planePoolQueryObj
	 * @return
	 */
	List<PlanePool> getPlanePollByCondition(PlanePoolQueryObj planePoolQueryObj);
}
