package com.chen.plane.dao.mybatis;

import com.chen.plane.dao.PlaneInfoDao;
import com.chen.plane.domain.pojo.PlaneInfo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 *
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/4/26
 */
@Repository
public class PlaneInfoDaoMybatis extends BaseDaoMyBatis implements PlaneInfoDao{
	private static final Logger log = Logger.getLogger(PlaneInfoDaoMybatis.class);
	private final String NAMESPACE = "com.chen.plane.dao.mybatis.PlaneInfoMapper.";

	@Override public void addPlaneInfo(PlaneInfo planeInfo) {
		log.debug("PlaneInfoDaoMybatis.addPlaneInfo>>>");
		getSqlSession().insert(NAMESPACE + "insert", planeInfo);
		log.debug("PlaneInfoDaoMybatis.addPlaneInfo<<<");
	}
}
