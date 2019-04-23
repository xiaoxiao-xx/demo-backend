package com.microcore.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class SlsServerApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SlsServerApplication.class).web(true).run(args);
	}

}
