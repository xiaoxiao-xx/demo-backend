package com.microcore.center.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.microcore.center.config.SessionManage;
import com.microcore.center.util.StringUtil;
import com.microcore.center.vo.ResultVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 如果请求头中带有用户信息，则将用户信息JSON字符串转成UserInfo对象，保存值AuthContextHandler中
		String userInfo = request.getHeader("user_info");
		if (!StringUtil.isEmpty(userInfo) && SessionManage.isLogin(userInfo)) {
			return true;
		}
		/*response.getWriter().println(new Gson().toJson(ResultVo.sessionOut()));
		return true;*/
		log.error("回话失效！");
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
