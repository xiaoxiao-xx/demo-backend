package com.microcore.center;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@EnableCaching
@EnableAsync
@EnableTransactionManagement
@EnableScheduling
//@EnableAspectJAutoProxy
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.microcore.api"})
@MapperScan(basePackages = { "com.microcore.center.mapper", "com.microcore.common.mapper" })
@ComponentScan(basePackages = { "com.microcore.api", "com.microcore.center", "com.microcore.common", "com.microcore.auth.client" })
public class SlsCenterApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SlsCenterApplication.class).web(true).run(args);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	/*@Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Collections.singletonList(new ConcurrentMapCache("models")));
        return cacheManager;
    }*/
}
