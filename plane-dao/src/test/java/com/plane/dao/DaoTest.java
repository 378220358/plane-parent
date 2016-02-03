package com.plane.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.chen.plane.dao.CityDao;
import com.chen.plane.dao.UserDao;
import com.chen.plane.domain.pojo.City;
import com.chen.plane.domain.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chen.plane.dao.TestDao;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class DaoTest {
	@Autowired
	private UserDao userDao;
	@Autowired
	private CityDao cityDao;
	@Test
	public void testDao(){
		User user = new User();
		user.setUserName("admin");
		user.setUserPwd("admin");
		City city = new City();

		city.setCityName("郑州");
		City city1 = new City();

		city1.setCityName("杭州");
		List<City> cityList = new ArrayList<City>();
		cityList.add(city);
		cityList.add(city1);
		cityDao.addBathCity(cityList);
//		for (City city2 : cityDao.getAllCity()){
//			System.out.println(city2);
//		}
	}
}
