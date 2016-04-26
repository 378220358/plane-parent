package com.chen.plane.service;

import com.chen.plane.domain.pojo.PlaneFirst;
import com.chen.plane.domain.pojo.PlanePool;
import com.chen.plane.domain.pojo.PlaneTicket;
import com.chen.plane.domain.pojo.Ticket;
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

	/**
	 * 获得飞机舱室售卖信息
	 * @param id
	 * @return
	 */
	PlaneFirst getPlaneFirst(Integer id);

	/**
	 * 更新飞机售卖信息
	 * @param planeFirst
	 */
	void updatePlaneFirst(PlaneFirst planeFirst);

	/**
	 * 增加订单信息
	 * @param ticket
	 */
	void  addTicket(PlaneFirst ticket,String ip);

	/**
	 * 根据用户信息获得订单列表
	 * @param ticket
	 * @return
	 */
 	List<Ticket> getTicketByUser(Ticket ticket);
	/**
	 * 增加机票信息
	 * @param planeTicket
	 */
	void  addPlaneTicket(PlaneTicket planeTicket);
}
