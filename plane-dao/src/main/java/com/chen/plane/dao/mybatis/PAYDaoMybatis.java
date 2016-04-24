package com.chen.plane.dao.mybatis;

import com.chen.plane.dao.PAYDao;
import com.chen.plane.domain.pojo.PAY;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * 支付信息dao实现
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/4/24
 */
@Repository
public class PAYDaoMybatis extends BaseDaoMyBatis implements PAYDao {
	private static final Logger log = Logger.getLogger(PAYDaoMybatis.class);
	private final String NAMESPACE = "com.chen.plane.dao.mybatis.PAYMapper.";

	/**
	 * 增加支付信息
	 * @param pay
	 */
	@Override public void addPAYDao(PAY pay) {
		log.debug("PAYDaoMybatis.addPAYDao>>>");
		getSqlSession().insert(NAMESPACE + "insert", pay);
		log.debug("PAYDaoMybatis.addPAYDao<<<");
	}
}
