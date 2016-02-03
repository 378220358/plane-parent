package com.plane.dao;

import com.chen.plane.dao.CityDao;
import com.chen.plane.domain.pojo.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/2/3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class CityDaoTest {
	@Autowired
	private CityDao cityDao;
	@Test
	public void testCityDao(){
		City city = new City();
		List<City> cityList = new ArrayList<City>();
		city.setCityName("沈阳");
		cityList.add(city);
		cityDao.addBathCity(cityList);
	}
}
