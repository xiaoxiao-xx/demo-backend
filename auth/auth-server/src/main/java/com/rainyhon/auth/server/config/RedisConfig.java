package com.rainyhon.auth.server.config;

import com.microcore.center.util.JedisPoolUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {

	@Bean
	public JedisPoolUtil getJedisUtil(@Value("${redis.server}") final String redisServer,
	                                  @Value("${redis.port}") final int redisPort) {
		JedisPoolUtil jedisUtil = new JedisPoolUtil(redisServer, redisPort);
		// JedisPoolUtil.jedis = jedisUtil.getJedis();
		return jedisUtil;
	}

}

