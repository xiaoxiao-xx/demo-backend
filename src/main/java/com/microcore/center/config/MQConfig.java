package com.microcore.center.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.microcore.center.service.BlockChService;
import com.microcore.common.rabbit.RPCRabbitServer;
import com.microcore.common.rabbit.SimplestRabbitServer;
import com.zdsys.BlockChainService;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class MQConfig {

	@Autowired
	private RPCRabbitServer rpcRabbitServer;
	@Autowired
	private SimplestRabbitServer simplestRabbitServer;
	@Autowired
	private  BlockChService blockChService ;
	
	@PostConstruct
	public void init() {
		log.info("中心服务MQ监听启动！");
		try {
			rpcRabbitServer.initServer("center");
		} catch (Exception e) {
			log.info("中心服务MQ监听异常[{}]", e.getMessage());
			System.exit(0);
		}
		try {
			simplestRabbitServer.initServer("center");
		} catch (Exception e) {
			log.info("中心服务MQ监听异常[{}]", e.getMessage());
			System.exit(0);
		}
		blockChService.inite();
	}
}

