package com.microcore.center.service;

import com.microcore.center.model.DbServiceRecord;
import com.microcore.common.util.ResultVo;

/**
 * 节点上传使用记录
 */
public interface UploadRecordService {

	/**
	 * 节点上传服务接口调用记录
	 *
	 * @param dbServiceRecord 服务接口记录对象
	 * @return
	 */
	ResultVo serviceRecord(DbServiceRecord dbServiceRecord);

}
