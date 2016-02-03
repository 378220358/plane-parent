package com.chen.plane.domain.rpc;


import com.chen.plane.constant.rpc.AppServerResultCode;

import java.io.Serializable;

/**
 * AppServer远程调用返回结果
 * 
 * @author 李威 (liwei17@asiainfo.com) <p> EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
 * @version 1.0 2014年10月13日 下午5:36:23
 */
public class AppServerResult extends BaseResult implements Serializable {

	private static final long serialVersionUID = 7989950247445485117L;

	/**
	 * 业务数据
	 */
	private Object data;
	
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public AppServerResult() {
		super();
	}

	public AppServerResult(String data) {
		this.data = data;
	}

	/**
	 * 生成成功结果
	 * 
	 * @author 李威 (liwei17@asiainfo.com) <p> EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
	 * @version 1.0 2014年10月14日 上午11:50:07
	 * @return AppServerResult
	 */
	public static AppServerResult generateSuccessResult() {
		AppServerResult appServerResult = new AppServerResult();
		appServerResult.setCode(AppServerResultCode.SUCCESS.getCode());
		appServerResult.setInfo(AppServerResultCode.SUCCESS.getInfo());
		return appServerResult;
	}

	/**
	 * 生成失败结果结果
	 * 
	 * @author 李威 (liwei17@asiainfo.com) <p> EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
	 * @version 1.0 2014年10月14日 上午11:50:07
	 * @return AppServerResult
	 */
	public static AppServerResult generateFailureResult() {
		AppServerResult appServerResult = new AppServerResult();
		appServerResult.setCode(AppServerResultCode.FAILURE.getCode());
		appServerResult.setInfo(AppServerResultCode.FAILURE.getInfo());
		return appServerResult;
	}
}
