package com.chen.plane.dao.mybatis;

import com.chen.plane.dao.CityDao;
import com.chen.plane.domain.pojo.City;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 获得所有的城市列表dao实现
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/2/2
 */
@Repository
public class CityDaoMybatis extends BaseDaoMyBatis implements CityDao{
	private final String NAMESPACE = "com.chen.plane.dao.mybatis.CityMapper.";
	private static final Logger log = Logger.getLogger(CityDaoMybatis.class);
	@Override public List<City> getAllCity() {
		log.debug("CityDaoMybatis.getAllCity>>>");
		List<City> cityList = getSqlSession().selectList(NAMESPACE + "getAllCity");
		log.debug("CityDaoMybatis.getAllCity<<<");
		return cityList;
	}

	@Override public void addBathCity(List<City> cityList) {
		log.debug("CityDaoMybatis.addBathCity>>>");
		getSqlSession().insert(NAMESPACE + "addBathCity", cityList);
		log.debug("CityDaoMybatis.addBathCity<<<");
	}
}
