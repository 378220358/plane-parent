package com.chen.plane.service.impl;

import com.chen.plane.dao.PlanePoolDao;
import com.chen.plane.domain.pojo.PlanePool;
import com.chen.plane.domain.query.PlanePoolQueryObj;
import com.chen.plane.service.TicketService;
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
	@Override public List<PlanePool> getPlanePollByCondition(PlanePoolQueryObj planePoolQueryObj) {
		log.debug("TicketServiceImpl.getPlanePollByCondition>>>");
		List<PlanePool> planePoolList = planePoolDao.getPlanePollByCondition(planePoolQueryObj);
		log.debug("TicketServiceImpl.getPlanePollByCondition<<<");
		return planePoolList;
	}
}
