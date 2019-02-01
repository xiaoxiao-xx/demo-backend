package com.microcore.center.client.exchange;

import com.microcore.common.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component
public class ExchangeTemplate {
	private final ExchangeTemplateBase template;

	@Autowired
	public ExchangeTemplate(@Qualifier("rabbitTemplate") ExchangeTemplateBase template) {
		this.template = template;
	}

	public ResultVo registerService(ProxyServiceInfo serviceInfo) throws InterruptedException, TimeoutException, IOException {
		return template.registerService(serviceInfo);
	}

	public ResultVo createExchangeTask(ProxyExchangeInfo exchangeInfo) throws InterruptedException, TimeoutException, IOException {
		return template.createExchangeTask(exchangeInfo);
	}

	public ResultVo runExchange(String id) throws InterruptedException, TimeoutException, IOException {
		return template.runExchange(id);
	}
}
