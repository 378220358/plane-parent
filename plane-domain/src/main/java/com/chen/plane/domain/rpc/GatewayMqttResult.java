package com.chen.plane.domain.rpc;

import java.io.Serializable;
import java.util.Arrays;


/**
 * Gateway端推送mqtt结果
 * @author 梁聃(liangdan@asiainfo.com) <p>	EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
 * @version 1.0 2014-12-10 下午4:41:31
 */
public class GatewayMqttResult implements Serializable {

	private static final long serialVersionUID = 5973114316245205192L;

	/**
	 * 用于标志请求的编号，主动推送的消息id为null
	 */
	private String id;
	/**
	 * 请求的方法名称
	 */
	private String method;
	/**
	 * 用于标志访问类型，分PG,GateWay，Zwave
	 */
	private String type;
	/**
	 * 用于存放请求数据
	 */
	private Object[] params;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Object[] getParams() {
		return params;
	}
	public void setParams(Object[] params) {
		this.params = params;
	}
	@Override
	public String toString() {
		return "GatewayMqttResult [id=" + id + ", method=" + method + ", type=" + type + ", params=" + Arrays.toString(params) + "]";
	}
	
}
