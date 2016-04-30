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

	@Override public Integer getCityIdByCityName(String cityName) {
		log.debug("CityDaoMybatis.getCityIdByCityName>>>");
		Integer cityId = getSqlSession().selectOne(NAMESPACE + "getCityIdByCityName", cityName);
		log.debug("CityDaoMybatis.getCityIdByCityName<<<");
		return cityId;
	}

	@Override public City getCityById(Integer cityId) {
		log.debug("CityDaoMybatis.getCityById>>>");
		City city = getSqlSession().selectOne(NAMESPACE + "selectByPrimaryKey",cityId);
		log.debug("CityDaoMybatis.getCityById<<<");
		return city;
	}

	@Override public void updateCity(City city) {
		log.debug("CityDaoMybatis.updateCity>>>");
		getSqlSession().update(NAMESPACE + "updateByPrimaryKeySelective",city);
		log.debug("CityDaoMybatis.updateCity<<<");
	}

	@Override public void deleteCity(Integer cityId) {
		log.debug("CityDaoMybatis.deleteCity>>>");
		getSqlSession().delete(NAMESPACE + "deleteByPrimaryKey", cityId);
		log.debug("CityDaoMybatis.deleteCity<<<");
	}

}
