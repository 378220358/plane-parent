package com.chen.plane.domain.query;

import java.util.Date;

/**
 *
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/3/17
 */
public class PlanePoolQueryObj {
	private String planeStartPlace;
	private String planeEndPlace;
	private Date startPlaneTime;

	public String getPlaneStartPlace() {
		return planeStartPlace;
	}

	public void setPlaneStartPlace(String planeStartPlace) {
		this.planeStartPlace = planeStartPlace;
	}

	public String getPlaneEndPlace() {
		return planeEndPlace;
	}

	public void setPlaneEndPlace(String planeEndPlace) {
		this.planeEndPlace = planeEndPlace;
	}

	public Date getStartPlaneTime() {
		return startPlaneTime;
	}

	public void setStartPlaneTime(Date startPlaneTime) {
		this.startPlaneTime = startPlaneTime;
	}

	@Override public String toString() {
		return "PlanePoolQueryObj{" +
				"planeStartPlace='" + planeStartPlace + '\'' +
				", planeEndPlace='" + planeEndPlace + '\'' +
				", startPlaneTime=" + startPlaneTime +
				'}';
	}
}
