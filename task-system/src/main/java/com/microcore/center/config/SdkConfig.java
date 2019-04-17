package com.microcore.center.config;

import com.microcore.center.hcnetsdk.HCNetSDK;
import com.microcore.center.service.SdkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 *
 */
@Configuration
@Slf4j
public class SdkConfig {

	/**
	 * 设备IP
	 */
	@Value("${nvr.device.ip}")
	private String deviceIp;

	/**
	 * 设备Port
	 */
	@Value("${nvr.device.port}")
	private Short devicePort;

	/**
	 * 用户登录名
	 */
	@Value("${login.username}")
	private String username;

	/**
	 * 用户登录密码
	 */
	@Value("${login.password}")
	private String password;

	@Autowired
	private SdkService sdkService;

	// SDK instance
	private HCNetSDK sdk = HCNetSDK.INSTANCE;

	@PostConstruct
	private void initSdkService() {
		// 初始化SDK
		boolean initSuc = sdk.NET_DVR_Init();
		if (!initSuc) {
			log.error("SDK初始化失败");
		} else {
			log.info("SDK初始化成功");
		}

		// 设置超时时间
		sdk.NET_DVR_SetConnectTime(12, 2);

		sdkService.setSdk(sdk);
		sdkService.startLogin(deviceIp, devicePort, username, password);
		log.info("Log in device finished");
	}

}
