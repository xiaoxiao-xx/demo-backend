package com.rainyhon.common.mq.rabbit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class RabbitMQConfig {

	@Value("${rabbit.server.ip}")
	private String MQ_SERVER_IP;

	@Value("${rabbit.server.port}")
	private Integer MQ_SERVER_PORT;

	@Value("${rabbit.username}")
	private String MQ_USERNAME;

	@Value("${rabbit.password}")
	private String MQ_PASSWORD;


	@PostConstruct
	private void initRabbitMQUtil() {



	}

}
