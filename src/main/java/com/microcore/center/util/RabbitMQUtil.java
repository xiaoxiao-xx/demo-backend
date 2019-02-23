package com.microcore.center.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeoutException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RabbitMQUtil {
	private static Channel channel;

	@PostConstruct
	public void init() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("192.168.1.111");
		factory.setPort(5672);
		factory.setUsername("admin");
		factory.setPassword("123123");
		Connection connection = factory.newConnection();
		channel = connection.createChannel();
	}

	public void sendMsg(String msg) {
		/*try {
			log.info("消息[{}]",msg);
			channel.basicPublish("amq.topic", "topic_test", null, msg.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
}
