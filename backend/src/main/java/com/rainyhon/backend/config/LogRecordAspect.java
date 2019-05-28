package com.rainyhon.backend.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.rainyhon.common.util.WebLogUtil;

import lombok.extern.slf4j.Slf4j;

@Aspect // 定义一个切面
@Order(5)
@Component
@Slf4j
public class LogRecordAspect {

	// 定义切点Pointcut
	@Pointcut("execution(* com.rainyhon.backend.controller.*Controller.*(..))")
	public void webLog() {
	}

	@Around("webLog()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		try {
			return WebLogUtil.aspectWebLog(pjp);
		} catch (Throwable throwable) {
			log.error("系统异常请联系管理员！", throwable);
			// 各种异常都变成了RuntimeException，这样做不好
			// throw new RuntimeException("系统异常, 请联系管理员: " + throwable.getMessage());
			throw throwable;
		}
	}
}