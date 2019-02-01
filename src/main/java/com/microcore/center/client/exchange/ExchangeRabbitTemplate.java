package com.microcore.center.client.exchange;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.microcore.common.rabbit.MqExchangeVo;
import com.microcore.common.rabbit.RPCRabbitClient;
import com.microcore.common.util.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.TimeoutException;

@Component
@Slf4j
@Qualifier(value = "rabbitTemplate")
public class ExchangeRabbitTemplate implements ExchangeTemplateBase {

	private static final String REGISTER_SERVICE_URI = "/api/service/createKit";
	private static final String CREATE_EXCHANGE_TASK_URI = "/api/service/createProxyExchange";
	private static final String RUN_EXCHANGE_URI = "/api/service/runExchange";

	private final RPCRabbitClient rpcRabbitClient;

	@Autowired
	public ExchangeRabbitTemplate(RPCRabbitClient rpcRabbitClient) {
		this.rpcRabbitClient = rpcRabbitClient;
	}

	@Override
	public ResultVo registerService(ProxyServiceInfo serviceInfo) throws InterruptedException, IOException, TimeoutException {
		return callExchange(REGISTER_SERVICE_URI, serviceInfo);
	}

	@Override
	public ResultVo createExchangeTask(ProxyExchangeInfo exchangeInfo) throws InterruptedException, IOException, TimeoutException {
		return callExchange(CREATE_EXCHANGE_TASK_URI, exchangeInfo);
	}

	@Override
	public ResultVo runExchange(String id) throws InterruptedException, IOException, TimeoutException {
		return callExchange(RUN_EXCHANGE_URI, id);
	}

	private <T> ResultVo callExchange(String uri, T t) throws InterruptedException, TimeoutException, IOException {
		String s = rpcRabbitClient.callExchange(buildExchangeVo(uri, t));
		return new Gson().fromJson(s, ResultVo.class);
	}

	private <T> MqExchangeVo<T> buildExchangeVo(String uri, T param) {
		MqExchangeVo<T> vo = new MqExchangeVo<>();
		vo.setURI(uri);
		vo.setParam(param);
		return vo;
	}

}
