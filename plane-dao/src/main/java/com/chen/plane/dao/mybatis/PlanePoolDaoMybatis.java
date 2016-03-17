package com.chen.plane.dao.mybatis;

import com.chen.plane.dao.PlanePoolDao;
import com.chen.plane.domain.pojo.PlanePool;
import com.chen.plane.domain.query.PlanePoolQueryObj;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/3/17
 */
@Repository
public class PlanePoolDaoMybatis extends BaseDaoMyBatis implements PlanePoolDao {
	private static final Logger log = Logger.getLogger(PlanePoolDaoMybatis.class);
	private final String NAMESPACE = "com.chen.plane.dao.mybatis.PlanePoolMapper.";

	/**
	 * 获得机票池里面的机票信息
	 * @param planePoolQueryObj
	 * @return
	 */
	@Override public List<PlanePool> getPlanePollByCondition(PlanePoolQueryObj planePoolQueryObj) {
		log.debug("PlanePoolDaoMybatis.getPlanePollByCondition>>>");
		List<PlanePool> planePoolList = getSqlSession().selectList(NAMESPACE + "getPlanePollByCondition", planePoolQueryObj);
		log.debug("PlanePoolDaoMybatis.getPlanePollByCondition<<<");
		return planePoolList;
	}
}
