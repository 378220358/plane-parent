package com.chen.plane.service;

import com.chen.plane.domain.pojo.PlaneTicket;

import java.util.List;

/**
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/4/28
 */
public interface PlaneTicketService {
	/**
	 * 获得所有的航班信息
	 * @return
	 */
	List<PlaneTicket> getAllPlaneTicket();
	/**
	 * 删除航班信息
	 * @param planeId
	 */
	void deletePlaneTicket(Integer planeId);

	/**
	 * 修改航班信息
	 * @param planeTicket
	 */
	void updatePlaneTicket(PlaneTicket planeTicket);

	/**
	 * 根据ID获得航班信息
	 * @param planeId
	 * @return
	 */
	PlaneTicket getPlaneTicket(Integer planeId);
	/**
	 * 获得所有的航班信息包含售卖信息
	 * @return
	 */
	List<PlaneTicket> getPlaneTicketInfo();
}
