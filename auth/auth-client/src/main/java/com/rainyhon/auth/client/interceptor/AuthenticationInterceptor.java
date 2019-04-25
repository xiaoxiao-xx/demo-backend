package com.rainyhon.auth.client.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rainyhon.common.context.AuthContextHandler;
import com.rainyhon.common.util.Base64Utils;
import com.rainyhon.common.util.StringUtil;
import com.rainyhon.common.vo.UserInfo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 如果请求头中带有用户信息，则将用户信息JSON字符串转成UserInfo对象，保存值AuthContextHandler中
		String userInfo1 = request.getHeader("user_info");
		// String user_roles = request.getHeader("user_roles");
		if (!StringUtil.isEmpty(userInfo1)) {
			try {
				String userInfo2 = Base64Utils.base64Dcode(userInfo1);
				UserInfo userInfo = new Gson().fromJson(userInfo2, UserInfo.class);
				AuthContextHandler.setDbUserDto(userInfo);
				// AuthContextHandler.set("user_info_string", userInfo1);
			} catch (Exception e) {
				log.error("解析JSON出错！url[" + request.getRequestURL().toString() + "]json:" + userInfo1, e);
			}
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	                       ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e)
			throws Exception {
	}

}
