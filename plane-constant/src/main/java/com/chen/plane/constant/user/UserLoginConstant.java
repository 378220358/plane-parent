package com.chen.plane.constant.user;

/**
 * 用户登录相关常量
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/3/13
 */
public class UserLoginConstant {
	/**
	 * Cookie中的key
	 */
	public static final String COOKIE_KEY = "plane";

	/**
	 * Cookie的有效期(秒) - 1天
	 */
	public static final int COOKIE_AVAILABLE_TIME_LONG = 24 * 60 * 60;

	/**
	 * Cookie Path
	 */
	public static final String COOKIE_PATH = "/";

	/**
	 * Redis中后台登录相关信息key
	 */
	public static final String REDIS_LOGIN_MAP_KEY = "LoginMap";

	/**
	 * 用户登录标记
	 */
	public static final String USER_LOGIN_FLAG = "userName";

	/**
	 * 用户登录标记
	 */
	public static final String ACCESS_TOKEN_FLAG = "accessToken";

	/**
	 * 用户权限相关信息key
	 */
	public static final String USER_PERMISSION_KEY = "userPermission";
	/**
	 * 用户登录名称
	 */
	public static final String USER_LOGIN_NAME = "userName";
	/**
	 * 用户登录口令
	 */
	public static final String USER_ACCESS_TOKEN = "accessToken";
}
