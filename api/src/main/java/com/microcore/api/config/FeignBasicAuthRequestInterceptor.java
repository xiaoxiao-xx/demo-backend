package com.microcore.api.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * Feign请求拦截器
 * 
 **/
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {

//	private static String orgId;

//	public void setOrgId(String orgId) {
//		this.orgId = orgId;
//	}

	@Override
	public void apply(RequestTemplate template) {
//		template.header("orgId", orgId);
	}

}
