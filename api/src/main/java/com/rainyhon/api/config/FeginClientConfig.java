package com.rainyhon.api.config;

import com.microcore.center.util.UserUtil;
import com.microcore.center.vo.UserInfo;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import feign.RequestInterceptor;

@Component
public class FeginClientConfig {

	@Bean
	public RequestInterceptor headerInterceptor() {
		return requestTemplate -> {
			// 小示例，没什么卵用
			// requestTemplate.header("Content-Type", "application/json");

			UserInfo userInfo = UserUtil.getCurrentLoginUser();
			if (userInfo != null) {
				String userInfo2 = new Gson().toJson(UserUtil.getCurrentLoginUser());
//				requestTemplate.header("user_info", Base64Utils.base64Ecode(userInfo2));
			}
		};
	}

}
