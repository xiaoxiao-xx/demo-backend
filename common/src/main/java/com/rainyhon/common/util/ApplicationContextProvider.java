package com.rainyhon.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * ApplicationContextProvider 
 * 设置spring上下文以获取多例的线程
 *
 * @author lijie
 * @date 2018/3/29
 */
@Component
public class ApplicationContextProvider implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	/**
	 * 复写方法，获得spring的上下文 提供注入bean的功能
	 *
	 * @param applicationContext
	 *            spring上下文
	 * @throws BeansException
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ApplicationContextProvider.applicationContext = applicationContext;
	}

	public static <T> T getBean(Class<T> tclass) {
		return applicationContext.getBean(tclass);
	}

	/**
	 * 注入bean
	 *
	 * @param name
	 *            bean名称
	 * @param tclass
	 *            class文件
	 * @param <T>
	 * @return
	 */
	public static <T> T getBean(String name, Class<T> tclass) {
		return applicationContext.getBean(name, tclass);
	}
}
