package com.chen.plane.util.oauth;

/**
 * 鉴权配置类
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/3/12
 */
public class OAuthConfig {
	private String[] excludeUrls;
	private String[] includeUrls;
	private String redirectUri;

	public boolean exclude(String uri) {
		if (excludeUrls != null) {
			for (String exc : excludeUrls) {
				if (exc.equals(uri) || uri.matches(exc)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean include(String uri) {
		if (includeUrls != null) {
			for (String include : includeUrls) {
				if (include.equals(uri) || uri.matches(include)) {
					return true;
				}
			}
		}
		return false;
	}

	public String[] getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(String[] excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public String[] getIncludeUrls() {
		return includeUrls;
	}

	public void setIncludeUrls(String[] includeUrls) {
		this.includeUrls = includeUrls;
	}
}
