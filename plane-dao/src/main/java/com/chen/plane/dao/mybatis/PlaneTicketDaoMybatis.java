package com.chen.plane.dao.mybatis;

import com.chen.plane.dao.PlaneTicketDao;
import com.chen.plane.domain.pojo.PlaneTicket;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/4/25
 */
@Repository
public class PlaneTicketDaoMybatis extends  BaseDaoMyBatis implements PlaneTicketDao {
	private static final Logger log = Logger.getLogger(PlaneTicketDaoMybatis.class);
	private final String NAMESPACE = "com.chen.plane.dao.mybatis.PlaneTicketMapper.";
	@Override public void addPlaneTicket(PlaneTicket planeTicket) {
		log.debug("PlaneTicketDaoMybatis.addPlaneTicket>>>");
		getSqlSession().insert(NAMESPACE + "insert", planeTicket);
		log.debug("PlaneTicketDaoMybatis.addPlaneTicket<<<");
	}
}
