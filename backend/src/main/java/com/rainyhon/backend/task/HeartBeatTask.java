package com.rainyhon.backend.task;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.rainyhon.backend.config.SessionManage;

/**
 * @author
 */
@Component
public class HeartBeatTask {

	/**
	 * 1秒心跳一次
	 */
	@Scheduled(fixedRate = 1000)
	private void heartbeatToCenter() {
		SessionManage.checkAllUser();
	}

}
