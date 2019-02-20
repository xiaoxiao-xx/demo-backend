package com.microcore.center.config;

import java.util.HashMap;
import java.util.Map;

import com.microcore.center.vo.UserInfo;

import lombok.Data;

@Data
public class SessionManage {
	private static Map<String,UserInfo> session = new HashMap<>();
}
