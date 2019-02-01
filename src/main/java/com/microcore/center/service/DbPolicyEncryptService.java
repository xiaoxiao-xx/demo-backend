/**
 * Project Name:sls-center
 * File Name:DbPolicyEncryptService.java
 * Package Name:com.microcore.center.service
 * Date:2018年12月20日上午10:30:39
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.microcore.center.service;

import java.util.List;
import java.util.Map;

import com.microcore.center.model.DbPolicyEncrypt;

/**
 * ClassName:DbPolicyEncryptService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年12月20日 上午10:30:39 <br/>
 * @author   whater
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface DbPolicyEncryptService {
	public Map<String,DbPolicyEncrypt> getDbPolicyEncryptMap(String templateId);
	public List<DbPolicyEncrypt> getDbPolicyEncrypt(String templateId);
}

