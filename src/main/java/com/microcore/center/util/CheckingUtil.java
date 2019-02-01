package com.microcore.center.util;

/**
 * 参数校验
 */
public class CheckingUtil {

	/**
	 * 校验参数是否为空
	 *
	 * @param param String类型参数
	 * @return true:为空，false:非空
	 */
	public static boolean checkingIsEmpty(String param) {
		return (param == null || "".equals(param) || param.length() == 0);
	}

	/**
	 * 校验IP格式
	 *
	 * @param ip
	 * @return true:格式正确，false:格式错误
	 */
	public static boolean checkingIp(String ip) {
		return ip.matches("^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)$");
	}

	/**
	 * 校验端口格式
	 *
	 * @param port
	 * @return true:格式正确，false:格式错误
	 */
	public static boolean checkingPort(String port) {
		return port.matches("^[1-9]\\d{0,3}$|^[1-5]\\d{4}$|^6[0-4]\\d{3}$|^65[0-4]\\d{2}$|^655[0-2]\\d$|^6553[0-5]$");
	}

	/**
	 * 校验文件路径
	 */
	public static boolean checkingPath(String path) {
//		return path.matches("^[a-zA-Z]?:\\\\((.+?\\\\)|(.+?))*$");
		return true;
	}
}
