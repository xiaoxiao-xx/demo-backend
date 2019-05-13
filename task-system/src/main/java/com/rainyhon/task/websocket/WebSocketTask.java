package com.rainyhon.task.websocket;

import com.google.gson.Gson;
import com.rainyhon.common.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class WebSocketTask {

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	@Autowired
	private SummaryService summaryService;

	private Gson gson = new Gson();

	public void sendDetailList() {
		simpMessagingTemplate.convertAndSend("/topic/greetings",
				gson.toJson(summaryService.getDetailListRedis2()));
	}

}
