package com.rainyhon.backend.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.rainyhon.backend.interceptor.AuthenticationInterceptor;

//@Configuration("authMvcInterceptor")
//@Primary
public class AuthInterceptorConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthenticationInterceptor()).excludePathPatterns("/system/*").addPathPatterns("/**");
		super.addInterceptors(registry);
	}

}
