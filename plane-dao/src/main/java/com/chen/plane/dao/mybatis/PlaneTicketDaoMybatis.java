package com.chen.plane.dao.mybatis;

import com.chen.plane.dao.PlaneTicketDao;
import com.chen.plane.domain.pojo.PlaneTicket;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

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

	@Override public List<PlaneTicket> getAllPlaneTicket() {
		log.debug("PlaneTicketDaoMybatis.getAllPlaneTicket>>>");
		List<PlaneTicket> planeTicketList = getSqlSession().selectList(NAMESPACE + "getAllPlaneTicket");
		log.debug("PlaneTicketDaoMybatis.getAllPlaneTicket<<<");
		return planeTicketList;
	}

	@Override public void deletePlaneTicket(Integer planeId) {
		log.debug("PlaneTicketDaoMybatis.deletePlaneTicket>>>");
		getSqlSession().delete(NAMESPACE + "deleteByPrimaryKey", planeId);
		log.debug("PlaneTicketDaoMybatis.deletePlaneTicket<<<");
	}

	@Override public void updatePlaneTicket(PlaneTicket planeTicket) {
		log.debug("PlaneTicketDaoMybatis.updatePlaneTicket>>>");
		getSqlSession().update(NAMESPACE + "updateByPrimaryKey", planeTicket);
		log.debug("PlaneTicketDaoMybatis.updatePlaneTicket<<<");
	}

	@Override public PlaneTicket getPlaneTicket(Integer planeId) {
		log.debug("PlaneTicketDaoMybatis.getPlaneTicket>>>");
		PlaneTicket planeTicket = getSqlSession().selectOne(NAMESPACE + "selectByPrimaryKey", planeId);
		log.debug("PlaneTicketDaoMybatis.getPlaneTicket<<<");
		return planeTicket;
	}

	@Override public List<PlaneTicket> getPlaneTicketInfo() {
		log.debug("PlaneTicketDaoMybatis.getPlaneTicketInfo>>>");
		List<PlaneTicket> planeTicketList = getSqlSession().selectList(NAMESPACE + "getPlaneTicketInfo");
		log.debug("PlaneTicketDaoMybatis.getPlaneTicketInfo<<<");
		return planeTicketList;
	}

	@Override public Integer getCabinId(Integer planeInfoId) {
		log.debug("PlaneTicketDaoMybatis.getCabinId>>>");
		Integer cabinId = getSqlSession().selectOne(NAMESPACE + "getCabinId",planeInfoId);
		log.debug("PlaneTicketDaoMybatis.getCabinId<<<");
		return  cabinId;
	}
}
