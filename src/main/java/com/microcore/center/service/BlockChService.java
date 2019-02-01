/**
 * Project Name:sls-center
 * File Name:BlockChService.java
 * Package Name:com.microcore.center.service
 * Date:2019年1月15日上午10:24:41
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.microcore.center.service;

import java.util.Map;

/**
 * ClassName:BlockChService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2019年1月15日 上午10:24:41 <br/>
 * @author   whater
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface BlockChService {
	
	public boolean inite();
	public boolean dataRead(String labelId, String orgId);
	public void dataShare(String labelId, String orgIds);
	public void dataPubAndShare(String labelId, String dDomain, String dSensitivity, String dataType, String orgIds);
	public Map<String, String> registUser(String userId, String name, String email) ;
	public void dataRequest(String labelId);
	public void dataEvaluation(String labelId);
}

