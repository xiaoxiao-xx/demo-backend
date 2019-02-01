package com.microcore.center.client;

import com.microcore.api.model.Policy;
import com.microcore.api.vo.PolicyInfo;
import com.microcore.common.client.BaseTemplate;
import com.microcore.common.dto.DbModelDto;
import com.microcore.common.vo.SecLabelVo;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.SendUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author
 */
@Component
public class PolicyTemplate extends BaseTemplate {

	private final RestTemplate restTemplate;

	@Value("${sls-policy.ip}")
	private String ip;

	@Value("${sls-policy.port}")
	private String port;

	private final SendUtil sendUtil;

	@Autowired
	public PolicyTemplate(RestTemplate restTemplate, SendUtil sendUtil) {
		this.restTemplate = restTemplate;
		this.sendUtil = sendUtil;
	}

	public void addPolicy(Policy policy) {
		sendUtil.send("policy", "/policy/addPolicy", policy);
	}

	public ResultVo addPolicyInfo(PolicyInfo policyInfo) {
		sendUtil.send("policy", "/policy/addPolicyInfo", policyInfo);
		return ResultVo.ok();
	}

	public ResultVo generateLabelXml(DbModelDto modelDto) {
		sendUtil.send("policy", "/policy/generateLabelXml", modelDto);
		return ResultVo.ok();
	}

	public ResultVo queryPolicy(String policyId) {
		return get("/sls-policy/policy/queryPolicy?policyId=" + policyId, ResultVo.class);
	}

	public ResultVo updPolicyInfo(PolicyInfo policyInfo) {
		return post("/sls-policy/policy/updPolicyInfo", policyInfo, ResultVo.class);
	}

	public ResultVo getSecLabelList(SecLabelVo vo) {
		return post("/sls-policy/policy/getSecLabelList", vo, ResultVo.class);
	}

	public ResultVo getSecLabelDetailedInfo(String labelId) {
		return get("/sls-policy/policy/getSecLabelDetailedInfo?labelId=" + labelId, ResultVo.class);
	}

	@Override
	public <T, V> T post(String serviceURL, V v, Class<T> t) {
		return super.post(serviceURL, v, t, restTemplate, ip, port);
	}

	@Override
	public <T> T get(String serviceURL, Class<T> t) {
		return super.get(serviceURL, t, restTemplate, ip, port);
	}

}
