package com.chen.plane.service.impl;

import com.chen.plane.dao.PAYDao;
import com.chen.plane.dao.PlaneFirstDao;
import com.chen.plane.dao.PlanePoolDao;
import com.chen.plane.dao.TicketDao;
import com.chen.plane.domain.pojo.PAY;
import com.chen.plane.domain.pojo.PlaneFirst;
import com.chen.plane.domain.pojo.PlanePool;
import com.chen.plane.domain.pojo.Ticket;
import com.chen.plane.domain.query.PlanePoolQueryObj;
import com.chen.plane.service.TicketService;
import com.chen.plane.util.Random.RandomUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/3/19
 */
@Service
public class TicketServiceImpl implements TicketService {
	private static final Logger log = Logger.getLogger(TicketServiceImpl.class);
	@Autowired
	private PlanePoolDao planePoolDao;
	@Autowired
	private PlaneFirstDao planeFirstDao;
	@Autowired
	private TicketDao ticketDao;
	@Autowired
	private PAYDao payDao;
	/**
	 * 根据条件获得机票池列表
	 * @param planePoolQueryObj
	 * @return
	 */
	@Override public List<PlanePool> getPlanePollByCondition(PlanePoolQueryObj planePoolQueryObj) {
		log.debug("TicketServiceImpl.getPlanePollByCondition>>>");
		List<PlanePool> planePoolList = planePoolDao.getPlanePollByCondition(planePoolQueryObj);
		log.debug("TicketServiceImpl.getPlanePollByCondition<<<");
		return planePoolList;
	}
	/**
	 * 获得飞机舱室售卖信息
	 * @param id
	 * @return
	 */
	@Override public PlaneFirst getPlaneFirst(Integer id) {
		log.debug("TicketServiceImpl.getPlaneFirst>>>");
		PlaneFirst planeFirst = planeFirstDao.getPlaneFirstById(id);
		log.debug("TicketServiceImpl.getPlaneFirst<<<");
		return planeFirst;
	}
	/**
	 * 更新飞机售卖信息
	 * @param planeFirst
	 */
	@Override public void updatePlaneFirst(PlaneFirst planeFirst) {
		log.debug("TicketServiceImpl.updatePlaneFirst>>>");
		planeFirstDao.updatePlaneFirstById(planeFirst);
		log.debug("TicketServiceImpl.updatePlaneFirst<<<");
	}

	/**
	 * 增加订单信息
	 * @param planeFirst
	 */
	@Override public void addTicket(PlaneFirst planeFirst,String ip) {
		log.debug("TicketServiceImpl.addTicket>>>");
		Ticket ticket = new Ticket();
		ticket.setTicketMoney(planeFirst.getTicketMoney());
		ticket.setTicketName(planeFirst.getTicketName());
		ticket.setTicketCard(planeFirst.getTicketCard());
		ticket.setTicketNumber(RandomUtils.generateNumString(32));
		ticket.setTicketStatue(0);
		ticket.setTicketIp(ip);
		ticket.setUserId(planeFirst.getUserId());
		PAY pay = new PAY();
		pay.setPayIp(ip);
		pay.setPayNumber(RandomUtils.generateNumString(32));
		pay.setPayStatue(0);
		pay.setPayMoney(planeFirst.getTicketMoney());
		pay.setPayType(0);
		payDao.addPAYDao(pay);
		ticket.setPayId(pay.getPayId());
		ticketDao.addTicket(ticket);
		planeFirstDao.updatePlaneFirstById(planeFirst);
		log.debug("TicketServiceImpl.addTicket<<<");
	}

	/**
	 * 根据用户信息获得订单列表
	 * @param ticket
	 * @return
	 */
	@Override public List<Ticket> getTicketByUser(Ticket ticket) {
		log.debug("TicketServiceImpl.getTicketByUser>>>");
		List<Ticket> ticketList = ticketDao.getTicketByUser(ticket);
		log.debug("TicketServiceImpl.getTicketByUser<<<");
		return ticketList;
	}

}
