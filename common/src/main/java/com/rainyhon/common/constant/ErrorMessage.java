package com.rainyhon.common.constant;

import java.util.HashMap;
import java.util.Map;

public enum ErrorMessage {

	// TODO ADD MORE ERROR MESSAGES
	NET_DVR_NETWORK_FAIL_CONNECT(7, "连接设备失败。设备不在线或网络原因引起的连接超时等。"),
	NET_DVR_PARAMETER_ERROR(17, "参数错误。SDK接口中给入的输入或输出参数为空，或者参数格式或值不符合要求。");

	private int errorNo;

	private String errorMsg;

	ErrorMessage(int errorNo, String errorMsg) {
		this.errorNo = errorNo;
		this.errorMsg = errorMsg;
	}

	private static final Map<Integer, ErrorMessage> MAP = new HashMap<>();

	static {
		for (ErrorMessage message : ErrorMessage.values()) {
			MAP.put(message.getErrorNo(), message);
		}
	}

	public static String getErrorMsgByErrorNo(int errorNo) {
		if (MAP.containsKey(errorNo)) {
			return MAP.get(errorNo).getErrorMsg();
		}
		return "";
	}

	public static String getErrorTypeByErrorNo(int errorNo) {
		if (MAP.containsKey(errorNo)) {
			return MAP.get(errorNo).getName();
		}
		return "";
	}

	public int getErrorNo() {
		return errorNo;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public String getName() {
		return name();
	}

}
