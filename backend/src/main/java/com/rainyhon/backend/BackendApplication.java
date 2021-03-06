package com.rainyhon.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableScheduling
@EnableDiscoveryClient
@SpringBootApplication
@EnableAsync
@MapperScan(basePackages = { "com.rainyhon.common.mapper" })
@ComponentScan(basePackages = { "com.rainyhon.backend", "com.rainyhon.auth", "com.rainyhon.common" })
public class BackendApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(BackendApplication.class).web(true).run(args);
	}

}






































