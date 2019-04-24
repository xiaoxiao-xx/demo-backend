package com.rainyhon.backend.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author
 */
@Component
public class ScheduleDetailTask {

	/**
	 * 每天23:00执行生成日程的任务
	 */
	@Scheduled(cron = "0 0 23 * * *")
	private void heartbeatToCenter() {

	}

}
