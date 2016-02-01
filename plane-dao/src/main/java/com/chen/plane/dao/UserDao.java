package com.chen.plane.dao;

import com.chen.plane.domain.pojo.User;

/**
 * 用户dao
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/1/28
 */
public interface UserDao {
	/**
	 * 根据用户ID获得用户
	 * @param user
	 * @return
	 */
	public User getUserById(User user);
}
