package com.microcore.center.client;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.microcore.api.vo.PolicyVo;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.ResultVo;

@Component
public class LabelTemplate {

	private final RestTemplate restTemplate;

	@Autowired
	public LabelTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	/**
	 * 溯源
	 *
	 * @param label
	 * @return
	 */
	public ResultVo<PolicyVo> traceInfo(String ip, String port, String label) {
		ResultVo vo = get(ip, port, "/label/traceInfo?label=" + label, ResultVo.class);
		Map<String, Object> record = (Map<String, Object>) vo.getData();
		PolicyVo policyVo = CommonUtil.map2POx(record, PolicyVo.class);
		vo.setData(policyVo);
		return vo;
	}

	/*
	private <T> T post(String ip,String port,String serviceURL,Object param,Class<T> t) {
		return restTemplate
				.postForEntity("http://" + ip + ":" + port + serviceURL , param, t)
				.getBody();
	}
	*/

	private <T> T get(String ip, String port, String serviceURL, Class<T> t) {
		return restTemplate
				.getForEntity("http://" + ip + ":" + port + serviceURL, t)
				.getBody();
	}

}
