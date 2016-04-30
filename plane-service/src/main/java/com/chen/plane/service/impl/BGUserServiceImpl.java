package com.chen.plane.service.impl;

import com.chen.plane.dao.BGUserDao;
import com.chen.plane.domain.pojo.BGUser;
import com.chen.plane.service.BGUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/4/30
 */
@Service
public class BGUserServiceImpl implements BGUserService {
	private static final Logger log = Logger.getLogger(BGUserServiceImpl.class);
	@Autowired
	private BGUserDao bgUserDao;
	@Override public void addBGUser(BGUser bgUser) {
		log.debug("BGUserServiceImpl.addBGUser>>>");
		bgUserDao.addBGUser(bgUser);
		log.debug("BGUserServiceImpl.addBGUser<<<");
	}

	@Override public BGUser getBGUser(BGUser bgUser) {
		log.debug("BGUserServiceImpl.getBGUser>>>");
		BGUser bgUser1 = bgUserDao.getBGUser(bgUser);
		log.debug("BGUserServiceImpl.getBGUser<<<");
		return bgUser1;
	}

	@Override public List<BGUser> getAllBGUser() {
		log.debug("BGUserServiceImpl.getAllBGUser>>>");
		List<BGUser> bgUserList = bgUserDao.getAllBGUser();
		log.debug("BGUserServiceImpl.getAllBGUser<<<");
		return bgUserList;
	}

	@Override public void updateBGUser(BGUser bgUser) {
		log.debug("BGUserServiceImpl.updateBGUser>>>");
		bgUserDao.updateBGUser(bgUser);
		log.debug("BGUserServiceImpl.updateBGUser<<<");

	}

	@Override public void deleteBGUser(Integer BGId) {
		log.debug("BGUserServiceImpl.deleteBGUser>>>");
		bgUserDao.deleteBGUser(BGId);
		log.debug("BGUserServiceImpl.deleteBGUser<<<");

	}
}
