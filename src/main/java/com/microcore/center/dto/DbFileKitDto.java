package com.microcore.center.dto;

import com.microcore.api.model.DbFileKit;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DbFileKitDto extends DbFileKit {

//	/**
//	 * 启动时间
//	 */
//	private Date startupTime;
	
	private Object spaceInfo ;
	
	
	
}
