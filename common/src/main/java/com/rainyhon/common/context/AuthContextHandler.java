package com.rainyhon.common.context;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用ThreadLocal传递变量，获取当前登录用户的信息建议从该类获取
 *
 * @author whater
 * @version 1.0
 * @date 2018/1/2 11:24
 */
public class AuthContextHandler {

	/**
	 * 本地线程变量，每个线程都获取自己的数据，不会存在并发的问题
	 */
	private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

	/**
	 * 将值存储于本地线程
	 *
	 * @param key
	 * @param value
	 */
	public static void set(String key, Object value) {
		Map<String, Object> map = threadLocal.get();
		if (map == null) {
			map = new HashMap<>();
			threadLocal.set(map);
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
		Map<String, Object> map = threadLocal.get();
		if (map == null) {
			map = new HashMap<>();
			threadLocal.set(map);
		}

		return map.get(key);
	}

	/**
	 * 设置当前登录用户的认证信息。仅鉴权模块使用
	 *
	 * @param dbUserDto
	 */
	public static <T> void setDbUserDto(T dbUserDto) {
		set("dbUserDto", dbUserDto);
	}

	/**
	 * 获取当前登录用户的认证信息。仅鉴权模块使用
	 *
	 * @return
	 */
	public static <T> T getDbUserDto() {
		Object o = get("dbUserDto");
		if (o != null) {
			return (T) o;
		}
		return null;
	}

	/**
	 * 移除所有数据。仅拦截器调用，使用者无需理会
	 */
	public static void remove() {
		Map<String, Object> map = threadLocal.get();
		if (map != null) {
			map.clear();
		}
		threadLocal.remove();
	}

}
