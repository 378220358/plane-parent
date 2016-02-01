package com.chen.plane.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.chen.plane.dao.UserDao;
import com.chen.plane.domain.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chen.plane.dao.TestDao;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class TestS {

	@Test
	public void testDao(){
//		User user = new User();
//		user.setUserName("admin");
//		user.setUserPwd("admin");
//		System.out.println(userService.getUserById(user));;
	}
}
