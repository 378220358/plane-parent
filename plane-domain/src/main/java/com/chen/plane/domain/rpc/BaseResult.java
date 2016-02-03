package com.chen.plane.domain.rpc;

import java.io.Serializable;

/**
 * 远程调用基础返回结果
 * 
 * @author 李威 (liwei17@asiainfo.com) <p> EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
 * @version 1.0 2014年10月11日 下午2:37:29
 */
public class BaseResult implements Serializable {

	private static final long serialVersionUID = 8214534873520210847L;

	/**
	 * 结果代码
	 */
	private String code;

	/**
	 * 结果信息
	 */
	private String info;

	public BaseResult() {
		super();
	}

	public BaseResult(String code, String info) {
		super();
		this.code = code;
		this.info = info;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
