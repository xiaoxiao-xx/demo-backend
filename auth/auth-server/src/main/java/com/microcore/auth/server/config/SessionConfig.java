package com.microcore.auth.server.config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SessionConfig {

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return container -> container.setSessionTimeout(60 * 20);
	}

}

