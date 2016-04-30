package com.chen.plane.dao;

import com.chen.plane.domain.pojo.PlaneTicket;

import java.util.List;

/**
 * 飞机信息dao接口
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/4/25
 */
public interface PlaneTicketDao {
	/**
	 * 增加飞机信息
	 * @param planeTicket
	 */
	void addPlaneTicket(PlaneTicket planeTicket);

	/**
	 * 获得所有的航班信息
	 * @param planeTicket
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

	/**
	 * 获得舱室ID
	 * @param planeInfoId
	 * @return
	 */
	Integer getCabinId(Integer planeInfoId);

}
