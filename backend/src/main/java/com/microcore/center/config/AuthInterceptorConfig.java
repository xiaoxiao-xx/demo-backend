package com.microcore.center.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.microcore.center.interceptor.AuthenticationInterceptor;

//@Configuration("authMvcInterceptor")
//@Primary
public class AuthInterceptorConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthenticationInterceptor()).excludePathPatterns("/system/*").addPathPatterns("/**");
		super.addInterceptors(registry);
	}

}
