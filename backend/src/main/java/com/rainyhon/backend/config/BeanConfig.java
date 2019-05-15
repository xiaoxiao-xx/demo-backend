package com.rainyhon.backend.config;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.TimeZone;

@Configuration
public class BeanConfig {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

//	@Bean
//	public Jackson2ObjectMapperBuilderCustomizer jacksonObjectMapperCustomization() {
//		return jacksonObjectMapperBuilder ->
//				jacksonObjectMapperBuilder.timeZone(TimeZone.getTimeZone("GMT+8"));
//	}

}
