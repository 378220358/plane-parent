package com.chen.plane.service.impl;

import com.chen.plane.dao.CityDao;
import com.chen.plane.dao.PlaneTicketDao;
import com.chen.plane.domain.pojo.PlaneTicket;
import com.chen.plane.service.PlaneTicketService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/4/28
 */
@Service
public class PlaneTicketServiceImpl implements PlaneTicketService {
	private static final Logger log = Logger.getLogger(PlaneTicketServiceImpl.class);
	@Autowired
	private PlaneTicketDao planeTicketDao;
	@Autowired
	private CityDao cityDao;
	@Override public List<PlaneTicket> getAllPlaneTicket() {
		log.debug("PlaneTicketServiceImpl.getAllPlaneTicket>>>");
		List<PlaneTicket> planeTicketList = planeTicketDao.getAllPlaneTicket();
		for (PlaneTicket planeTicket : planeTicketList){
			planeTicket.setPlaneEndPlaceName(cityDao.getCityById(planeTicket.getPlaneEndPlace()).getCityName());
			planeTicket.setPlaneStartPlaceName(cityDao.getCityById(planeTicket.getPlaneStartPlace()).getCityName());
		}
		log.debug("PlaneTicketServiceImpl.getAllPlaneTicket<<<");
		return planeTicketList;
	}

	@Override public void deletePlaneTicket(Integer planeId) {
		log.debug("PlaneTicketServiceImpl.deletePlaneTicket>>>");
		planeTicketDao.deletePlaneTicket(planeId);
		log.debug("PlaneTicketServiceImpl.deletePlaneTicket<<<");
	}

	@Override public void updatePlaneTicket(PlaneTicket planeTicket) {
		log.debug("PlaneTicketServiceImpl.updatePlaneTicket>>>");
		planeTicketDao.updatePlaneTicket(planeTicket);
		log.debug("PlaneTicketServiceImpl.updatePlaneTicket<<<");
	}

	@Override public PlaneTicket getPlaneTicket(Integer planeId) {
		log.debug("PlaneTicketServiceImpl.getPlaneTicket>>>");
		PlaneTicket planeTicket = planeTicketDao.getPlaneTicket(planeId);
		log.debug("PlaneTicketServiceImpl.getPlaneTicket<<<");
		return planeTicket;
	}

	@Override public List<PlaneTicket> getPlaneTicketInfo() {
		log.debug("PlaneTicketServiceImpl.getPlaneTicketInfo>>>");
		List<PlaneTicket> planeTicketList = planeTicketDao.getPlaneTicketInfo();
		for (PlaneTicket  planeTicket : planeTicketList){
			planeTicket.setPlaneStartPlaceName(cityDao.getCityById(planeTicket.getPlaneStartPlace()).getCityName());
			planeTicket.setPlaneEndPlaceName(cityDao.getCityById(planeTicket.getPlaneEndPlace()).getCityName());
			if (planeTicket.getCabinAledrdySeat() != null){
				planeTicket.setAlerdySale(planeTicket.getCabinAledrdySeat().split(",").length);
				planeTicket.setRemainSale(30-planeTicket.getCabinAledrdySeat().split(",").length);
			}else {
				planeTicket.setAlerdySale(0);
				planeTicket.setRemainSale(30);
			}
		}
		log.debug("PlaneTicketServiceImpl.getPlaneTicketInfo<<<");
		return planeTicketList;
	}
}
