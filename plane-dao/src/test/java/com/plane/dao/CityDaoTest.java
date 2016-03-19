package com.plane.dao;

import com.chen.plane.dao.CityDao;
import com.chen.plane.dao.PlanePoolDao;
import com.chen.plane.domain.pojo.City;
import com.chen.plane.domain.pojo.PlanePool;
import com.chen.plane.domain.query.PlanePoolQueryObj;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	@Autowired
	private PlanePoolDao planePoolDao;
	@Test
	public void testCityDao(){
		City city = new City();
		List<City> cityList = new ArrayList<City>();
		city.setCityName("ÉòÑô");
		cityList.add(city);
		cityDao.addBathCity(cityList);
	}
	@Test
	public void testPlaneDao(){
		PlanePoolQueryObj planePoolQueryObj = new PlanePoolQueryObj();
		planePoolQueryObj.setPlaneEndPlace("±±¾©");
		planePoolQueryObj.setPlaneStartPlace("ÄÏ²ý");
		String dd = "2016-03-18 08:10:00";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = null;
		try {
			 date = simpleDateFormat.parse(dd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		planePoolQueryObj.setStartPlaneTime(date);
		System.out.println(planePoolQueryObj);

		System.out.println(planePoolDao.getPlanePollByCondition(planePoolQueryObj).get(0));
	}
}
