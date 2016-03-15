package com.chen.plane.domain.exception;


/**
 * 自定义异常
 * @author 谢继永  (xiejy@asiainfo.com) <p>	EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
 * @version 1.0 2014-10-17 下午6:05:01
 */
public class MsgTipException extends RuntimeException {

	private String code;
	private String result;
	private String message;

	public MsgTipException(String message){
		super(message);
		this.message = message;
	}

	public MsgTipException(String code,String message){
		super(message);
		this.code = code;
		this.message = message;
	}

	public MsgTipException(String code,String result,String message){
		super(message);
		this.code = code;
		this.result = result;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MsgTipException [code=" + code + ", result=" + result + ", message=" + message + "]";
	}


}
