package com.microcore.center.config;

import com.microcore.center.util.JedisPoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RedisConfig {

	@Bean
	public JedisPoolUtil getJedisUtil(@Value("${redis.server}") final String redisServer,
	                                  @Value("${redis.port}") final int redisPort) {
		JedisPoolUtil jedisUtil = new JedisPoolUtil(redisServer, redisPort);
		// JedisPoolUtil.jedis = jedisUtil.getJedis();
		log.info("Redis server started");
		return jedisUtil;
	}

}

