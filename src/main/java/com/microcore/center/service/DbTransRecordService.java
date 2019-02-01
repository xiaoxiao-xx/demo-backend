package com.microcore.center.service;

import com.microcore.center.model.DbTransRecord;

public interface DbTransRecordService {

	/**
	 * 上报打标操作记录
	 *
	 * @param dbTransRecord 打标操作记录
	 */
	void addDbTransRecord(DbTransRecord dbTransRecord);

}

