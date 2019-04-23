package com.microcore.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.microcore.gateway.filter.AccessFilter;

@EnableZuulProxy
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringCloudApplication
@EnableFeignClients(basePackages = {"com.microcore.api"})
//@MapperScan(basePackages = {"com.microcore.center.mapper"})
@ComponentScan(basePackages = {"com.microcore.api", "com.microcore.gateway"})
public class SlsGatewayApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SlsGatewayApplication.class).web(true).run(args);
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
