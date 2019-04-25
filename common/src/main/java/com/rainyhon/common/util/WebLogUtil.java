package com.rainyhon.common.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebLogUtil {

	private static final String RESPONSE_PREFIX = "response|uri:{},{}";

	private static final Gson GSON = new Gson();

	public static Object aspectWebLog(ProceedingJoinPoint pjp) throws Throwable {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		if (sra == null) {
			return pjp.proceed();
		}
		HttpServletRequest request = sra.getRequest();
		String url = request.getRequestURL().toString();
		String method = request.getMethod();
		String uri = request.getRequestURI();
		String queryString = request.getQueryString();
		Map<String, String[]> map = request.getParameterMap();
		String postString = GSON.toJson(map).toString();
		log.info("request|url:{}, method:{}, uri:{}, getParams:{},postParams:{} ", url, method, uri, queryString,
				postString);
		Object result;
		try {
			result = pjp.proceed();// result的值就是被拦截方法的返回值
		} catch (Exception e) {
			log.error("log-异常！|response|" + uri, e);
			throw e;
		}
		if (result == null) {
			log.info(RESPONSE_PREFIX, uri, null);
		} else if (result.getClass() == String.class) {
			log.info(RESPONSE_PREFIX, uri, result);
		} else {
			log.info(RESPONSE_PREFIX, uri, GSON.toJson(result));
		}
		return result;
	}

}
