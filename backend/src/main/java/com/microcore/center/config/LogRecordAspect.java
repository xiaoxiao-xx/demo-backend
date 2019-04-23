package com.microcore.center.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.microcore.center.util.WebLogUtil;

import lombok.extern.slf4j.Slf4j;

@Aspect // 定义一个切面
@Order(5)
@Component
@Slf4j
public class LogRecordAspect {

	// 定义切点Pointcut
	@Pointcut("execution(* com.microcore.center.controller.*Controller.*(..))")
	public void webLog() {
	}

	@Around("webLog()")
	public Object doAround(ProceedingJoinPoint pjp) {
		try {
			return WebLogUtil.aspectWebLog(pjp);
		} catch (Throwable throwable) {
			log.error("系统异常请联系管理员！", throwable);
			throw new RuntimeException("系统异常, 请联系管理员: " + throwable.getMessage());
		}
	}
}