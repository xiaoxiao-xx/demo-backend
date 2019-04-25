package com.rainyhon.common.mq.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component
@Slf4j
public class RabbitMQUtil {

	private static Channel channel;

	@Value("${rabbit.server.ip}")
	private String MQ_SERVER_IP;

	@Value("${rabbit.server.port}")
	private Integer MQ_SERVER_PORT;

	@Value("${rabbit.username}")
	private String MQ_USERNAME;

	@Value("${rabbit.password}")
	private String MQ_PASSWORD;

	/**
	 * 初始化消息队列连接
	 */
	@PostConstruct
	public void init() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		// ip of RabbitMQ server
		factory.setHost(MQ_SERVER_IP);
		factory.setPort(MQ_SERVER_PORT);
		factory.setUsername(MQ_USERNAME);
		factory.setPassword(MQ_PASSWORD);
		Connection connection = factory.newConnection();
		channel = connection.createChannel();
	}

	/**
	 * 发送消息
	 *
	 * @param msg 消息
	 */
	public void sendMsg(String msg) {
		try {
			log.info("消息[{}]", msg);
			channel.basicPublish("amq.topic", "topic_test", null, msg.getBytes("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

