package com.chen.plane.service;

import com.chen.plane.domain.pojo.BGUser;

import java.util.List;

/**
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/4/30
 */
public interface BGUserService {
	/**
	 * 增加后台用户
	 * @param bgUser
	 */
	void addBGUser(BGUser bgUser);

	/**
	 * 根据条件查找后台用户
	 * @param bgUser
	 * @return
	 */
	BGUser getBGUser(BGUser bgUser);
	/**
	 * 获得所有非管理员用户
	 * @return
	 */
	List<BGUser> getAllBGUser();

	/**
	 * 更新后台管理员用户
	 * @param bgUser
	 */
	void updateBGUser(BGUser bgUser);
	/**
	 * 根据ID删除管理员
	 * @param BGId
	 */
	void deleteBGUser(Integer BGId);
}
