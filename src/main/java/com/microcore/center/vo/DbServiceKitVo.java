/**
 * Project Name:sls-center
 * File Name:DbServiceKitVo.java
 * Package Name:com.microcore.center.vo
 * Date:2018年12月13日上午10:26:45
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.microcore.center.vo;

import com.microcore.api.model.DbServiceKit;

import lombok.Data;

/**
 * ClassName:DbServiceKitVo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年12月13日 上午10:26:45 <br/>
 * @author   whater
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Data
public class DbServiceKitVo extends DbServiceKit {
	private Long callCount ;
	private Long avgProxyTime ;
	private String orgName;
	private String runStatus;
}

