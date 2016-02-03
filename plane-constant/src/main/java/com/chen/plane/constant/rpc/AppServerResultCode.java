package com.chen.plane.constant.rpc;

/**
 * AppServer远程调用结果码
 * 
 * @author 李威 (liwei17@asiainfo.com) <p> EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
 * @version 1.0 2014年10月13日 下午5:20:32
 */
public enum AppServerResultCode {

    //公共
	SUCCESS("00000", "操作成功"),
    ERROR_NOT_LOGIN("00001","未登陆，请先登陆"),
    ERROR_INVALID_PARAMETER("00002","参数有误，请检查"),
    FAILURE("99999", "操作失败");
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 信息
	 */
	private String info;

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

	private AppServerResultCode(String code, String info) {
		this.code = code;
		this.info = info;
	}
}
