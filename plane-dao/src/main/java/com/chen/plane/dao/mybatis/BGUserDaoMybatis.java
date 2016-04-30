package com.chen.plane.dao.mybatis;

import com.chen.plane.dao.BGUserDao;
import com.chen.plane.domain.pojo.BGUser;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/4/30
 */
@Repository
public class BGUserDaoMybatis extends BaseDaoMyBatis implements BGUserDao {
	private final String NAMESPACE = "com.chen.plane.dao.mybatis.BGUserMapper.";
	private static final Logger log = Logger.getLogger(BGUserDaoMybatis.class);
	@Override public void addBGUser(BGUser bgUser) {
		log.debug("BGUserDaoMybatis.addBGUser>>>");
		getSqlSession().insert(NAMESPACE + "insert", bgUser);
		log.debug("BGUserDaoMybatis.addBGUser<<<");
	}

	@Override public BGUser getBGUser(BGUser bgUser) {
		log.debug("BGUserDaoMybatis.getBGUser>>>");
		BGUser bgUser1 = getSqlSession().selectOne(NAMESPACE + "getUserInfoById",bgUser);
		log.debug("BGUserDaoMybatis.getBGUser<<<");
		return bgUser1;
	}

	@Override public List<BGUser> getAllBGUser() {
		log.debug("BGUserDaoMybatis.getAllBGUser>>>");
		List<BGUser> bgUserList = getSqlSession().selectList(NAMESPACE + "getAllBGUser");
		log.debug("BGUserDaoMybatis.getAllBGUser<<<");
		return bgUserList;
	}

	@Override public void updateBGUser(BGUser bgUser) {
		log.debug("BGUserDaoMybatis.updateBGUser>>>");
		getSqlSession().update(NAMESPACE + "updateBGUser", bgUser);
		log.debug("BGUserDaoMybatis.updateBGUser<<<");
	}

	@Override public void deleteBGUser(Integer BGId) {
		log.debug("BGUserDaoMybatis.deleteBGUser>>>");
		getSqlSession().delete(NAMESPACE + "deleteByPrimaryKey",BGId);
		log.debug("BGUserDaoMybatis.deleteBGUser<<<");
	}
}
