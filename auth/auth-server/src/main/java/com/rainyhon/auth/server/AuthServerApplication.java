package com.rainyhon.auth.server;

// import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

@EnableZuulProxy
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@SpringCloudApplication
@EnableFeignClients(basePackages = { "com.rainyhon.api" })
// @MapperScan(basePackages = { "com.microcore.center.mapper" })
@ComponentScan(
		basePackages = { "com.rainyhon.auth", "com.rainyhon.api", "com.rainyhon.common" },
		excludeFilters = {
				@ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.rainyhon.common.service.*"),
				@ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.rainyhon.common.mq.*")
		})
public class AuthServerApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(AuthServerApplication.class).web(true).run(args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}

