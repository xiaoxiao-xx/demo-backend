package com.rainyhon.common.constant;

import java.util.HashMap;
import java.util.Map;

import static java.util.Optional.ofNullable;

public class AreaDef {

	private static Map<String, String> areaMap = new HashMap<>(5);

	static {
		areaMap.put("1", "入口");
		areaMap.put("2", "入口");
		areaMap.put("3", "工作区");
		areaMap.put("4", "会议室");
		areaMap.put("5", "总经理室");
	}

	public static String getAreaNameById(String id) {
		String areaName = areaMap.get(id);
		return ofNullable(areaName).orElse("");
	}

}
