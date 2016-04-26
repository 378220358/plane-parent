package com.chen.plane.dao.mybatis;

import com.chen.plane.dao.PlaneFirstDao;
import com.chen.plane.domain.pojo.PlaneFirst;
import com.chen.plane.domain.pojo.PlaneInfo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * 舱室信息dao实现
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/4/24
 */
@Repository
public class PlaneFirstDaoMybatis extends BaseDaoMyBatis implements PlaneFirstDao{
	private static final Logger log = Logger.getLogger(PlaneFirstDaoMybatis.class);
	private final String NAMESPACE = "com.chen.plane.dao.mybatis.PlaneFirstMapper.";

	/**
	 * 获得飞机舱室售卖信息
	 * @param planeFirstId
	 * @return
	 */
	@Override public PlaneFirst getPlaneFirstById(Integer planeFirstId) {
		log.debug("PlaneFirstDaoMybatis.getPlaneFirst>>>");
		PlaneFirst planeFirst = getSqlSession().selectOne(NAMESPACE + "getPlaneFirstById" ,planeFirstId);
		log.debug("PlaneFirstDaoMybatis.getPlaneFirstById<<<");
		return planeFirst;
	}

	/**
	 * 更新飞机舱室售卖信息
	 * @param planeFirst
	 */
	@Override public void updatePlaneFirstById(PlaneFirst planeFirst) {
		log.debug("PlaneFirstDaoMybatis.updatePlaneFirstById>>>");
		getSqlSession().selectList(NAMESPACE + "updateByPrimaryKeySelective", planeFirst);
		log.debug("PlaneFirstDaoMybatis.updatePlaneFirstById<<<");
	}

	/**
	 * 增加飞机舱室信息
	 * @param first
	 */
	@Override public void addPlaneFirst(PlaneFirst first) {
		log.debug("PlaneFirstDaoMybatis.addPlaneFirst>>>");
		getSqlSession().insert(NAMESPACE + "insert", first);
		log.debug("PlaneFirstDaoMybatis.addPlaneFirst<<<");
	}


}
