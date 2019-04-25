package com.rainyhon.api.interceptor;

import com.rainyhon.common.context.AuthContextHandler;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * Feign客户端调用的时候，需要将token放到header里，否则拦截器会认为请求非法 注意，该类是全局有效，无需特殊配置。
 */
@Configuration
public class ServiceFeignInterceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate requestTemplate) {
//		requestTemplate.header("request-type", "server");

		String userInfo = (String) AuthContextHandler.get("user_info_string");
		requestTemplate.header("user_info", userInfo);
	}

}

