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
	private Integer planeStartPlace;
	private Integer planeEndPlace;
	private Date startPlaneTime;
	private String viewStartPlaneTime;

	public Integer getPlaneStartPlace() {
		return planeStartPlace;
	}

	public void setPlaneStartPlace(Integer planeStartPlace) {
		this.planeStartPlace = planeStartPlace;
	}

	public Integer getPlaneEndPlace() {
		return planeEndPlace;
	}

	public void setPlaneEndPlace(Integer planeEndPlace) {
		this.planeEndPlace = planeEndPlace;
	}

	public Date getStartPlaneTime() {
		return startPlaneTime;
	}

	public void setStartPlaneTime(Date startPlaneTime) {
		this.startPlaneTime = startPlaneTime;
	}

	public String getViewStartPlaneTime() {
		return viewStartPlaneTime;
	}

	public void setViewStartPlaneTime(String viewStartPlaneTime) {
		this.viewStartPlaneTime = viewStartPlaneTime;
	}

	@Override public String toString() {
		return "PlanePoolQueryObj{" +
				"planeStartPlace='" + planeStartPlace + '\'' +
				", planeEndPlace='" + planeEndPlace + '\'' +
				", startPlaneTime=" + startPlaneTime +
				", viewStartPlaneTime='" + viewStartPlaneTime + '\'' +
				'}';
	}
}
