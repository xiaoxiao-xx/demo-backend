package com.rainyhon.backend.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CorConfig {

	@Bean
	public FilterRegistrationBean registFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new CORSFilter());
		registration.addUrlPatterns("/*");
		registration.setName("LogCostFilter");
		registration.setOrder(1);
		return registration;
	}

}
