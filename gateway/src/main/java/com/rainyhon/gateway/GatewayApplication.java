package com.rainyhon.gateway;

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

import com.rainyhon.gateway.filter.AccessFilter;

@EnableZuulProxy
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@SpringCloudApplication
@EnableFeignClients(basePackages = { "com.rainyhon.api" })
//@MapperScan(basePackages = {"com.rainyhon.center.mapper"})
@ComponentScan(
		basePackages = { "com.rainyhon.api", "com.rainyhon.gateway", "com.rainyhon.common" },
		excludeFilters = {
				@ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.rainyhon.common.service.*"),
				@ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.rainyhon.common.mq.*")
		})
public class GatewayApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(GatewayApplication.class).web(true).run(args);
	}

	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
