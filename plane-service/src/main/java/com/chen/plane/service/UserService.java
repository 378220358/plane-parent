package com.chen.plane.service;

import com.chen.plane.domain.pojo.User;

/**
 * 用户service
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/1/28
 */
public interface UserService {
	/**
	 * 根据用户ID获得用户
	 * @param user
	 */
	public User getUserById(User user);

	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	void registerUser(User user);

	/**
	 * 更新用户信息
	 * @param user
	 */
	void updateUser(User user);
}
