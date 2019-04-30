package com.rainyhon.common.exception;

import java.util.HashMap;
import java.util.Map;

public enum CommonExceptionMessage {

	// public CommonExceptionMessage USER_ALREADY_EXISTS = new CommonExceptionMessage("USER_ALREADY_EXISTS","同名用户已经存在");
	USER_ALREADY_EXISTS("USER_ALREADY_EXISTS", "同名用户已经存在");

	private String realMessage;

	private String displayMessage;

	CommonExceptionMessage(String realMessage, String displayMessage) {
		this.realMessage = realMessage;
		this.displayMessage = displayMessage;
	}

	private static final Map<String, CommonExceptionMessage> MAP = new HashMap<>();

	static {
		for (CommonExceptionMessage message : CommonExceptionMessage.values()) {
			MAP.put(message.getRealMessage(), message);
		}
	}

	public static String getDisplayMessageByRealMessage(String errorNo) {
		if (MAP.containsKey(errorNo)) {
			return MAP.get(errorNo).getDisplayMessage();
		}

		return errorNo;
	}

	public static String getNameByRealMessage(String realMessage) {
		if (MAP.containsKey(realMessage)) {
			return MAP.get(realMessage).getName();
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
