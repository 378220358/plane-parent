package com.chen.plane.domain.pojo;

/**
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/4/20
 */
public class Admin {
	private String adminName;
	private String adminPwd;

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	@Override public String toString() {
		return "Admin{" +
				"adminName='" + adminName + '\'' +
				", adminPwd='" + adminPwd + '\'' +
				'}';
	}
}
