package com.microcore.center.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microcore.api.vo.SecurityKeyVo;
import com.microcore.common.util.SendUtil;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KeymanagerTemplate {

	@Autowired
	private SendUtil sendUtil;

	public void addSecurity(SecurityKeyVo securityKeyVo) {
		sendUtil.send("keymanager", "/security/addSecurity", securityKeyVo);
	}

	public void addServiceSecurity(SecurityKeyVo securityKeyVo) {
		sendUtil.send("keymanager", "/security/addServiceSecurity", securityKeyVo);
	}
}

