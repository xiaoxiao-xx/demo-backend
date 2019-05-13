package com.rainyhon.common.context;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用ThreadLocal传递变量，获取当前登录用户的信息建议从该类获取
 */
public class AuthContextHandler {

	private static final String LOG_IN_USER_INFO = "LogInUserInfo";

	/**
	 * 本地线程变量，每个线程都获取自己的数据，不会存在并发的问题
	 */
	private static ThreadLocal<Map<String, Object>> threadLocalMap = new ThreadLocal<>();

	/**
	 * 将值存储于本地线程
	 *
	 * @param key
	 * @param value
	 */
	public static void set(String key, Object value) {
		Map<String, Object> map = threadLocalMap.get();
		if (map == null) {
			map = new HashMap<>();
			threadLocalMap.set(map);
		}

		map.put(key, value);
	}

	/**
	 * 从本地线程获取
	 *
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		Map<String, Object> map = threadLocalMap.get();
		if (map == null) {
			map = new HashMap<>();
			threadLocalMap.set(map);
		}

		return map.get(key);
	}

	/**
	 * 获取当前登录用户的认证信息。仅鉴权模块使用
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getLoginUserInfo() {
		Object o = get(LOG_IN_USER_INFO);
		if (o != null) {
			return (T) o;
		}
		return null;
	}

	/**
	 * 设置当前登录用户的认证信息。仅鉴权模块使用
	 *
	 * @param t
	 */
	public static <T> void setLoginUserInfo(T t) {
		set(LOG_IN_USER_INFO, t);
	}

	/**
	 * 移除所有数据。仅拦截器调用，使用者无需理会
	 */
	public static void remove() {
		Map<String, Object> map = threadLocalMap.get();
		if (map != null) {
			map.clear();
		}
		threadLocalMap.remove();
	}

}
