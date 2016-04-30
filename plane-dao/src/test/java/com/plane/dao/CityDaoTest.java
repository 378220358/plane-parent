package com.plane.dao;

import com.chen.plane.dao.*;
import com.chen.plane.domain.pojo.*;
import com.chen.plane.domain.query.PlanePoolQueryObj;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.security.krb5.internal.PAData;

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
	@Autowired
	private PlaneFirstDao planeFirstDao;
	@Autowired
	private TicketDao ticketDao;
	@Autowired
	private PAYDao payDao;
	@Test
	public void testAddPAYDao(){
		PAY pay = new PAY();
		pay.setPayIp("127.0.0.1");
		pay.setPayMoney(23.3);
		pay.setPayStatue(0);
		payDao.addPAYDao(pay);
		System.out.println(pay.getPayId());
	}
	@Test
	public void testAddTicket(){
		Ticket ticket = new Ticket();
		ticket.setTicketIp("127.0.0.1");
		ticket.setTicketName("≈∑—Ù");
		ticket.setTicketCard("3622011994015555");
		ticket.setTicketNumber("123456789oy");
		ticket.setUserId(1);
		ticket.setTicketMoney(23.3);
		ticketDao.addTicket(ticket);
	}
	@Test
	public void testGetPlaneFirst(){
		System.out.println(planeFirstDao.getPlaneFirstById(1));
	}
	@Test
	public void testUpdatePlaneFirst(){
		PlaneFirst planeFirst = new PlaneFirst();
		planeFirst.setCabinId(1);
		planeFirst.setCabinAleardySeat("1_1,2_2,7_1,7_3,4_2,2_1");
		planeFirstDao.updatePlaneFirstById(planeFirst);
	}
	@Test
	public void testCityDao(){
		City city = new City();
		List<City> cityList = new ArrayList<City>();
		city.setCityName("…Ú—Ù");
		cityList.add(city);
		cityDao.addBathCity(cityList);
	}
	@Test
	public void testPlaneDao(){
		PlanePoolQueryObj planePoolQueryObj = new PlanePoolQueryObj();
		planePoolQueryObj.setPlaneEndPlace(2);
		planePoolQueryObj.setPlaneStartPlace(1);
		String dd = "2016-03-11 08:10:00";
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
