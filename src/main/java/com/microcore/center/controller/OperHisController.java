package com.microcore.center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microcore.center.service.OperHisService;
import com.microcore.center.vo.ResultVo;

@RestController
@RequestMapping("operHis")
public class OperHisController {
	
	@Autowired
	private OperHisService operHisService ;
	
	@GetMapping("query")
	public ResultVo query(String operTarget) {
		return ResultVo.ok(operHisService.getPsmOperHis(operTarget));
	}
}
