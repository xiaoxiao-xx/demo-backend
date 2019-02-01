/**
 * Project Name:sls-center
 * File Name:DbPubColumnService.java
 * Package Name:com.microcore.center.service
 * Date:2018年12月20日下午3:33:29
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.microcore.center.service;

import com.microcore.center.model.DbPubColumn;

/**
 * ClassName:DbPubColumnService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年12月20日 下午3:33:29 <br/>
 * @author   whater
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface DbPubColumnService {
	public DbPubColumn getDbPubColumnByPolicyId(String policyId);
}

