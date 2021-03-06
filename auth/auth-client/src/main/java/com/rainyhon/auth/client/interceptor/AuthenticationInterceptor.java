package com.rainyhon.auth.client.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rainyhon.common.context.AuthContextHandler;
import com.rainyhon.common.util.Base64Utils;
import com.rainyhon.common.util.StringUtil;
import com.rainyhon.common.vo.ResultVo;
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

		if (request.getRequestURL().toString().contains("swagger-resources")) {
			// log.info("Swagger url: {}", request.getRequestURL().toString());
			return true;
		}

		if (request.getRequestURI().contains("/auth/login")) {
			return true;
		}

		if (request.getRequestURI().contains("/auth/isLogged")) {
			return true;
		}

		// TODO 如果注销也要验证，则一个客户端退出了，另一个的注销请求就不会先auth成功
		if (request.getRequestURI().contains("/auth/logout")) {
			return true;
		}

		// TODO 这会影响userInfo接口 注意
//		if (request.getRequestURI().contains("user")) {
//			return true;
//		}

		// TODO 内部调用，没有携带用户信息
		if (request.getRequestURI().contains("getUserByUsername")) {
			return true;
		}

		// TODO 删除
		if (request.getRequestURI().contains("fileUpload")) {
			return true;
		}

		// 如果请求头中带有用户信息，则将用户信息JSON字符串转成UserInfo对象，保存值AuthContextHandler中
		String userInfoBase64Str = request.getHeader("user_info");
		// String user_roles = request.getHeader("user_roles");
		if (StringUtil.isNotEmpty(userInfoBase64Str)) {
			try {
				String userInfoJsonStr = Base64Utils.base64Dcode(userInfoBase64Str);
				UserInfo userInfo = new Gson().fromJson(userInfoJsonStr, UserInfo.class);
				AuthContextHandler.setLoginUserInfo(userInfo);
				// AuthContextHandler.set("user_info_string", userInfo1);
				return true;
			} catch (Exception e) {
				log.error("解析JSON出错！url[" + request.getRequestURL().toString() + "]json:" + userInfoBase64Str, e);
				return false;
			}
		}

		response.getWriter().println(new Gson().toJson(ResultVo.sessionOut()));
		response.setContentType("application/json");

		// do not deal the request
		return false;
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
