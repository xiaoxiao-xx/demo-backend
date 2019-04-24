package com.rainyhon.auth.server;

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

@EnableZuulProxy
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringCloudApplication
@EnableFeignClients(basePackages = { "com.microcore.api"})
@MapperScan(basePackages = { "com.microcore.common.mapper" })
@ComponentScan(basePackages = { "com.microcore.auth.server", "com.microcore.api", "com.microcore.auth","com.microcore.common"})
public class SlsAuthServerApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SlsAuthServerApplication.class).web(true).run(args);
	}
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}

