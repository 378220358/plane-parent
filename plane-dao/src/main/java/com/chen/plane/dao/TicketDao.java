package com.chen.plane.dao;

import com.chen.plane.domain.pojo.Ticket;

import java.util.List;

/**
 * 订单dao
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/4/24
 */
public interface TicketDao {
	/**
	 * 增加商品订单
	 * @param ticket
	 */
	void addTicket(Ticket ticket);

	/**
	 * 根据用户ID获得该用户下所有的订单
	 * @param ticket
	 * @return
	 */
	List<Ticket> getTicketByUser(Ticket ticket);
}
