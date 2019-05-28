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

import java.util.HashSet;
import java.util.Set;

import static com.rainyhon.common.util.CommonUtil.getBean;

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

	private Set<String> urlWhiteList = new HashSet<>();

	{
		// urlWhiteList.add("/user/addUser");
	}

	// private Map<String, UserInfo> userInfoMap = new HashMap<>();

	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		String requestURL = request.getRequestURL().toString();
		String uri = request.getRequestURI();

		// 不过滤登录请求
		if (requestURL.contains("/auth/login")) {
			return null;
		}

		if (urlWhiteList.contains(uri)) {
			return null;
		}

		// TODO 这会影响userInfo接口 注意
//		if (uri.contains("user")) {
//			return null;
//		}

		// TODO 删除
		if (uri.contains("/static/")) {
			return null;
		}

		// TODO 删除
		if (uri.contains("/file/")) {
			return null;
		}

		// TODO 如果注销也要验证，则一个客户端退出了，另一个的注销请求就不会先auth成功
		if (uri.contains("logout")) {
			return null;
		}

		// 过滤一般非登录请求
		String accessToken = request.getHeader("access-token");
		if (accessToken != null && !accessToken.trim().equals("")) {
//			log.info("AccessToken: [{}]", accessToken);
			UserInfo userInfo = null;
			try {
				// TODO 没有必要每次都调用auth的服务，可以缓存结果，每几分钟失效一下
				userInfo = getBean(AuthApi.class).isLogged(accessToken);

				if (userInfo != null && userInfo.getIsLogged() != null && userInfo.getIsLogged()) {
					// userInfoMap.put(userInfo.getId(), userInfo);

//					String json = JSONUtils.toJSONString(user);
					//ctx.addZuulRequestHeader("user_info", ByteUtils.byte2hex(Object2Byte.getBytesFromObject(user)));
//					ctx.addZuulRequestHeader("user_roles", JSONUtils.toJSONArray(user.getRoles()).toString());
					// UserInfo转成JSON字符串
					String userInfoJsonStr = new Gson().toJson(userInfo);
					// 再对JSON字符串进行Base64编码
					context.addZuulRequestHeader("user_info", Base64Utils.base64Ecode(userInfoJsonStr));
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
		context.setResponseBody(result);
		context.setSendZuulResponse(false);
		context.getResponse().setContentType("application/json");
		context.setResponseStatusCode(250);

		log.error(String.format("%-4s request to %s auth failed", request.getMethod(), request.getRequestURL().toString()));

		return null;
	}

}
