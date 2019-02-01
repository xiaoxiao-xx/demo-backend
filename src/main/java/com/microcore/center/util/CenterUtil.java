package com.microcore.center.util;

import com.microcore.center.model.DbApproval;
import com.microcore.common.constant.Constants;

/**
 * @author lmh
 */
public class CenterUtil {

	public static DbApproval buildApproval(String dataType, String taskId,
	                                       String appUserId, String pubDesc) {
		DbApproval dbApproval = new DbApproval();
		dbApproval.setTaskType(Constants.SUB);
		dbApproval.setDataType(dataType);
		dbApproval.setTaskId(taskId);
		dbApproval.setAppUserId(appUserId);
		dbApproval.setAppComment(pubDesc);

		return dbApproval;
	}

}
