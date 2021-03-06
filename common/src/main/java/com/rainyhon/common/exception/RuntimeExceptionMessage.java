package com.rainyhon.common.exception;

import java.util.HashMap;
import java.util.Map;

import static com.rainyhon.common.constant.Constants.*;

/**
 *
 */
public enum RuntimeExceptionMessage {

	// public CommonExceptionMessage USER_ALREADY_EXISTS = new CommonExceptionMessage("USER_ALREADY_EXISTS","同名用户已经存在");
	USER_ALREADY_EXISTS(CommonExceptionType.USER_ALREADY_EXISTS, "同名用户已经存在"),
	GET_ROOT_ORG_FAILED(CommonExceptionType.GET_ROOT_ORG_FAILED, "获取顶级机构失败");

	private String realMessage;

	private String displayMessage;

	RuntimeExceptionMessage(String realMessage, String displayMessage) {
		this.realMessage = realMessage;
		this.displayMessage = displayMessage;
	}

	private static final Map<String, RuntimeExceptionMessage> COMMON_EXCEPTION_MAP = new HashMap<>();

	private static final Map<String, String> RUNTIME_EXCEPTION_MAP = new HashMap<>();

	static {
		RUNTIME_EXCEPTION_MAP.put(NullPointerException.class.getName(), NullPointerExceptionStr);
		RUNTIME_EXCEPTION_MAP.put(ClassCastException.class.getName(), ClassCastExceptionStr);
		RUNTIME_EXCEPTION_MAP.put(ArrayIndexOutOfBoundsException.class.getName(), ArrayIndexOutOfBoundsStr);

		for (RuntimeExceptionMessage message : RuntimeExceptionMessage.values()) {
			COMMON_EXCEPTION_MAP.put(message.getRealMessage(), message);
		}
	}

	public static String getDisplayMessageByRealMessage(String realMessage) {
		if (COMMON_EXCEPTION_MAP.containsKey(realMessage)) {
			return COMMON_EXCEPTION_MAP.get(realMessage).getDisplayMessage();
		}

		return realMessage;
	}

	/**
	 * 根据RuntimeException名获取对应的中文说明
	 *
	 * @param exceptionName RuntimeException名
	 * @return 中文说明
	 */
	public static String getDisplayMessageByRuntimeExceptionName(String exceptionName) {
		if (RUNTIME_EXCEPTION_MAP.containsKey(exceptionName)) {
			return RUNTIME_EXCEPTION_MAP.get(exceptionName);
		}

		return exceptionName;
	}

	public static String getNameByRealMessage(String realMessage) {
		if (COMMON_EXCEPTION_MAP.containsKey(realMessage)) {
			return COMMON_EXCEPTION_MAP.get(realMessage).getName();
		}
		return "";
	}

	public String getRealMessage() {
		return realMessage;
	}

	public String getDisplayMessage() {
		return displayMessage;
	}

	public String getName() {
		return name();
	}

}
