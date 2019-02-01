package com.microcore.center;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@EnableTransactionManagement
//@EnableAspectJAutoProxy
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = { "com.microcore.center.mapper" })
@ComponentScan(basePackages = { "com.microcore.center" })
public class SlsCenterApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SlsCenterApplication.class).web(true).run(args);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
