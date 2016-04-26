package com.chen.plane.dao;

import com.chen.plane.domain.pojo.PlaneTicket;

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
}
