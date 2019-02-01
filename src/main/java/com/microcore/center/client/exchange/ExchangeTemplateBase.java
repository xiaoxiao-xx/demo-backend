package com.microcore.center.client.exchange;

import com.microcore.common.util.ResultVo;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface ExchangeTemplateBase {

	/**
	 * @param serviceInfo
	 * @return
	 */
	ResultVo registerService(ProxyServiceInfo serviceInfo) throws InterruptedException, IOException, TimeoutException;

	/**
	 * @param exchangeInfo
	 * @return
	 */
	ResultVo createExchangeTask(ProxyExchangeInfo exchangeInfo) throws InterruptedException, IOException, TimeoutException;

	/**
	 * @param id
	 */
	ResultVo runExchange(String id) throws InterruptedException, IOException, TimeoutException;
}
