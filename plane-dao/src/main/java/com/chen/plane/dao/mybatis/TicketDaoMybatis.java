package com.chen.plane.dao.mybatis;

import com.chen.plane.dao.TicketDao;
import com.chen.plane.domain.pojo.Ticket;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单处理dao
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/4/24
 */
@Repository
public class TicketDaoMybatis extends BaseDaoMyBatis implements TicketDao {
	private static final Logger log = Logger.getLogger(TicketDaoMybatis.class);
	private final String NAMESPACE = "com.chen.plane.dao.mybatis.TicketMapper.";

	/**
	 * 增加订单
	 * @param ticket
	 */
	@Override public void addTicket(Ticket ticket) {
		log.debug("TicketDaoMybatis.addTicket>>>");
		getSqlSession().insert(NAMESPACE + "insert", ticket);
		log.debug("TicketDaoMybatis.addTicket<<<");
	}

	/**
	 * 根据用户ID获得该用户下所有的订单
	 * @param ticket
	 * @return
	 */
	@Override public List<Ticket> getTicketByUser(Ticket ticket) {
		log.debug("TicketDaoMybatis.getTicketByUser>>>");
		List<Ticket> ticketList = getSqlSession().selectList(NAMESPACE + "getTicketByUser", ticket);
		log.debug("TicketDaoMybatis.getTicketByUser<<<");
		return ticketList;
	}
}
