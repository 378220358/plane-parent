package com.chen.plane.dao.mybatis;

import com.chen.plane.dao.UserDao;
import com.chen.plane.domain.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/1/28
 */
@Repository
public class UserDaoMybatis extends BaseDaoMyBatis implements UserDao {
	private static final Logger log = Logger.getLogger(UserDaoMybatis.class);
	private final String NAMESPACE = "com.chen.plane.dao.mybatis.UserMapper.";
	@Override public User getUserById(User user) {
		log.debug("UserDaoMybatis.getUserById>>>");
		User userR = getSqlSession().selectOne(NAMESPACE + "selectByExample", user);
		log.debug("UserDaoMybatis.getUserById<<<");
		return userR;
	}

	@Override public void registerUser(User user) {
		log.debug("UserDaoMybatis.registerUser>>>");
		getSqlSession().insert(NAMESPACE + "insertSelective" ,user);
		log.debug("UserDaoMybatis.registerUser<<<");
	}

	@Override public void updateUser(User user) {
		log.debug("UserDaoMybatis.updateUser>>>");
		getSqlSession().update(NAMESPACE + "updateByPrimaryKeySelective", user);
		log.debug("UserDaoMybatis.updateUser<<<");
	}

	@Override public User getUserInfoById(User user) {
		log.debug("UserDaoMybatis.getUserInfoById>>>");
		User user1 = getSqlSession().selectOne(NAMESPACE + "getUserInfoById", user);
		log.debug("UserDaoMybatis.getUserInfoById<<<");
		return user1;
	}
}
