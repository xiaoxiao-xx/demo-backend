package com.microcore.center.vo;

import java.util.List;

import lombok.Data;

@Data
public class KitInfoVo {

	private List<DbKitVo> dbKitList;
	
	private List<DbFileKitVo> fileKitList;
	
	private List<DbServiceKitVo> serviceKitList;
	
	
}
