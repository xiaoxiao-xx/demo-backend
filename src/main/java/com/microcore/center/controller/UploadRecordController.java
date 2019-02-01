package com.microcore.center.controller;

import com.microcore.center.vo.ResultVo;
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

	@PostMapping("serviceRecord")
	public ResultVo serviceRecord() {
		return ResultVo.ok();
	}

	@RequestMapping("addDbFileRecord")
	public ResultVo addDbFileRecord() {
		return ResultVo.ok();
	}

}
