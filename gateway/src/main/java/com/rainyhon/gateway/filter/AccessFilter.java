package com.rainyhon.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.rainyhon.api.AuthApi;
import com.rainyhon.common.util.*;
import com.rainyhon.common.vo.ResultVo;
import com.rainyhon.common.vo.UserInfo;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import lombok.extern.slf4j.Slf4j;

/**
 * @author
 */
@Slf4j
public class AccessFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String requestURL = request.getRequestURL().toString();

		// 不过滤登录请求
		if (requestURL.contains("/auth/login")) {
			return null;
		}

		boolean flag = true;
		if (flag) {
//			return null;
		}

		// 过滤一般非登录请求
		String accessToken = request.getHeader("access-token");
		if (accessToken != null && !accessToken.trim().equals("")) {
//			log.info("AccessToken: [{}]", accessToken);
			UserInfo user = null;
			try {
				user = CommonUtil.getBean(AuthApi.class).isLogged(accessToken);
				if (user != null && user.getIsLogged() != null && user.getIsLogged()) {
//					String json = JSONUtils.toJSONString(user);
					//ctx.addZuulRequestHeader("user_info", ByteUtils.byte2hex(Object2Byte.getBytesFromObject(user)));
//					ctx.addZuulRequestHeader("user_roles", JSONUtils.toJSONArray(user.getRoles()).toString());
					String userInfo = new Gson().toJson(user);
					ctx.addZuulRequestHeader("user_info", Base64Utils.base64Ecode(userInfo));
//					log.info("Logged: {}", user.getUsername());
					log.info(String.format("%-4s request to %s", request.getMethod(), request.getRequestURL().toString()));
					return null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 验证未通过
		String result = JSONUtils.toJSONString(ResultVo.sessionOut());
		ctx.setResponseBody(result);
		ctx.setSendZuulResponse(false);
		ctx.getResponse().setContentType("application/json");
		ctx.setResponseStatusCode(250);

		log.error(String.format("%-4s request to %s auth failed", request.getMethod(), request.getRequestURL().toString()));

		return null;
	}

}
