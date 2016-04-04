package com.chen.plane.service.impl;

import com.chen.plane.dao.UserDao;
import com.chen.plane.domain.pojo.User;
import com.chen.plane.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/1/28
 */
@Service
public class UserServiceImpl implements UserService {
	private static final Logger log = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao userDao;
	@Override public User getUserById(User user) {
		log.debug("UserServiceImpl.getUserById>>>");
		User userR= userDao.getUserById(user);
		log.debug("UserServiceImpl.getUserById<<<");
		return userR;
	}

	@Override public void registerUser(User user) {
		log.debug("UserServiceImpl.registerUser>>>");
		userDao.registerUser(user);
		log.debug("UserServiceImpl.registerUser<<<");
	}

	@Override public void updateUser(User user) {
		log.debug("UserServiceImpl.updateUser>>>");
		userDao.updateUser(user);
		log.debug("UserServiceImpl.updateUser<<<");
	}

	@Override public User getUserInfoById(User user) {
		log.debug("UserServiceImpl.getUserInfoById>>>");
		User user1 = userDao.getUserInfoById(user);
		log.debug("UserServiceImpl.getUserInfoById<<<");
		return user1;
	}
}
