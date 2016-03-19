package com.chen.plane.service;

import com.chen.plane.domain.pojo.PlanePool;
import com.chen.plane.domain.query.PlanePoolQueryObj;

import java.util.List;

/**
 * 订票的服务层
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/3/19
 */
public interface TicketService {
	/**
	 * 根据条件获得机票池列表
	 * @param planePoolQueryObj
	 * @return
	 */
	List<PlanePool> getPlanePollByCondition(PlanePoolQueryObj planePoolQueryObj);
}
