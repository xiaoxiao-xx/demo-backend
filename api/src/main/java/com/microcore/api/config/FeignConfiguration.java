package com.microcore.api.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.Request;

@Configuration
public class FeignConfiguration {

	public static List<FeignBasicAuthRequestInterceptor> list = new ArrayList<>();

	/**
	 * 日志级别
	 *
	 * @return
	 */
	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

	/**
	 * 创建Feign请求拦截器，在发送请求前设置认证的token,各个微服务将token设置到环境变量中来达到通用
	 */
	@Bean
	public FeignBasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		FeignBasicAuthRequestInterceptor requestInterceptor = new FeignBasicAuthRequestInterceptor();
		list.add(requestInterceptor);
		return requestInterceptor;
	}

	@Bean
	public Request.Options options() {
		return new Request.Options(5000, 10000);
	}

}