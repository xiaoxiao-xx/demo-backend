package com.rainyhon.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rainyhon.common.service.ParaDefineService;
import com.rainyhon.common.vo.ResultVo;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("paraDefineController")
public class ParaDefineController {

	@Autowired
	private ParaDefineService paraDefineService;

	@ApiOperation(value = "参数列表查询", notes = "参数列表查询")
	@GetMapping("query")
	public ResultVo query(@RequestParam(name = "type") String type) {
		return ResultVo.ok(paraDefineService.getParaDefineByType(type));
	}

}
