package com.microcore.center.controller;

import com.microcore.center.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 节点上传使用记录
 */
@RestController
@RequestMapping("uploadRecord")
public class UploadRecordController {

	@GetMapping("serviceRecord")
	public ResultVo serviceRecord() {
		return ResultVo.ok("asdfasdf");
	}

	@RequestMapping("addDbFileRecord")
	public ResultVo addDbFileRecord() {
		return ResultVo.ok();
	}

}
