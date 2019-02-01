package com.microcore.center.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microcore.center.mapper.DbServiceRecordMapper;
import com.microcore.center.model.DbServiceRecord;
import com.microcore.center.service.UploadRecordService;
import com.microcore.common.util.ResultVo;

/**
 * 节点上传使用记录
 */
@Transactional
@Service
public class UploadRecordServiceImpl implements UploadRecordService {
	
	/**
	 * 服务接口调用记录Mapper
	 */
	@Autowired
	private DbServiceRecordMapper dbServiceRecordMapper;
	
	@Override
	public ResultVo serviceRecord(DbServiceRecord dbServiceRecord) {
		if (dbServiceRecord == null) {
			return ResultVo.fail();
		}
		int insert = dbServiceRecordMapper.insert(dbServiceRecord);
		if (insert != 1) {
			return ResultVo.fail();
		}
		return ResultVo.ok();
	}

}
