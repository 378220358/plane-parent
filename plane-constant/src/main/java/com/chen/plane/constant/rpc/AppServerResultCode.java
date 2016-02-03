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
    FAILURE("99999", "操作失败"),
    //短信
    ERROR_SMS_CAPTCHA_EXPIRED("10001", "验证码已过期，请重新获取"),
    ERROR_SMS_CAPTCHA_VERIFY_FAILED("10002","验证码有误，请仔细核对短信"),
    ERROR_SMS_CAPTCHA_SEND_FAIL("10003","短信发送失败"),
	//注册
	ERROR_REGISTER_MOBILE_DUPLICATE("11001", "手机号已经注册，请直接登录"),
	ERROR_REGISTER_FAIL("11002","注册失败"),
    //登录
    ERROR_LOGIN_NOT_REGISTER("12001","手机号码尚未注册"),
    ERROR_LOGIN_PASSWORD_WRONG("12002","密码输入有误"),
	ERROR_LOGOUT_NOT_LOGIN("12101","未检测到来自客户端的用户登录信息"),
	ERROR_LOGOUT_INVALID_ACCESS_TOKEN("12102","无效的accessToken，需要重新登录"),
	ERROR_LOGOUT_FAILURE("12109","退出失败，无法从服务端移除用户登录信息"),

    //用户
	ERROR_USER_TOKEN_EXPIRE("13001","密码重置令牌已失效，重新操作"),
    ERROR_USER_OLD_PASSWORD_WRONG("13002","原始密码输入有误"),
	ERROR_UPLOAD_PICTURE_FAIL("13003","图片上传失败"),
    ERROR_USER_MOBILE_UPDATE_DUPLICATE("13004", "手机号已经注册，请直接登录"),
	ERROR_USER_MOBILE_UPDATE_EXISTING("13005","手机号已注册，请更换其他手机号绑定"),

	//投票活动
	ERROR_TOPIC_POLL_EXIST("14001","每期只能投一票哦"),

	//自住房查询
	ERROR_SELF_OCCUPIED_HOUSING_LOTTERY_RESULT_NOT_PUBLISH("15001","亲，您来早了，数据还没有公布~"),

	//支付错误
	ERROR_PAY_WX("16001","微信支付异常");
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
