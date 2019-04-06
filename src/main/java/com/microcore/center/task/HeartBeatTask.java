package com.microcore.center.task;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.microcore.center.config.SessionManage;

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
