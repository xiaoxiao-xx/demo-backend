package com.microcore.center.controller;

import com.microcore.center.model.DbFileRecord;
import com.microcore.center.model.DbServiceRecord;
import com.microcore.center.service.DbFileRecordService;
import com.microcore.center.service.UploadRecordService;
import com.microcore.common.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 节点上传使用记录
 */
@RestController
@RequestMapping("uploadRecord")
public class UploadRecordController {

	private final UploadRecordService uploadRecordService;

	private final DbFileRecordService dbFileRecordService;

	@Autowired
	public UploadRecordController(UploadRecordService uploadRecordService, DbFileRecordService dbFileRecordService) {
		this.uploadRecordService = uploadRecordService;
		this.dbFileRecordService = dbFileRecordService;
	}

	/**
	 * 上传服务接口调用记录
	 */
	@PostMapping("serviceRecord")
	public ResultVo serviceRecord(@RequestBody DbServiceRecord dbServiceRecord) {
		return uploadRecordService.serviceRecord(dbServiceRecord);
	}

	@RequestMapping("addDbFileRecord")
	public ResultVo addDbFileRecord(@RequestBody DbFileRecord dbFileRecord) {
		return dbFileRecordService.addDbFileRecord(dbFileRecord);
	}

}
