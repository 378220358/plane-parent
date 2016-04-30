package com.chen.plane.domain.pojo;

import java.io.Serializable;

/**
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/4/30
 */
public class BGUser implements Serializable{
	private Integer BGId;
	private String BGName;
	private String BGPwd;
	private String BGRole;

	public Integer getBGId() {
		return BGId;
	}

	public void setBGId(Integer BGId) {
		this.BGId = BGId;
	}

	public String getBGName() {
		return BGName;
	}

	public void setBGName(String BGName) {
		this.BGName = BGName;
	}

	public String getBGPwd() {
		return BGPwd;
	}

	public void setBGPwd(String BGPwd) {
		this.BGPwd = BGPwd;
	}

	public String getBGRole() {
		return BGRole;
	}

	public void setBGRole(String BGRole) {
		this.BGRole = BGRole;
	}

	@Override public String toString() {
		return "BGUser{" +
				"BGId=" + BGId +
				", BGName='" + BGName + '\'' +
				", BGPwd='" + BGPwd + '\'' +
				", BGRole='" + BGRole + '\'' +
				'}';
	}

	public enum RoleEnum{
		ADMIN("ADMIN"),
		COMMON("COMMON");
		private  final String key;
		RoleEnum(String key){
			this.key = key;
		}

		public String getKey() {
			return key;
		}
	}
}
