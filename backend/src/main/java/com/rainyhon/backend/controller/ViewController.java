package com.rainyhon.backend.controller;

import com.microcore.center.model.DynamicQueryVo;
import com.rainyhon.common.model.DynamicQuery;
import com.rainyhon.common.service.ViewService;
import com.rainyhon.common.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ViewController")
@Api("自定义视图")
public class ViewController {

	@Autowired
	private ViewService viewService;

	@GetMapping("getColumnByViewName")
	@ApiOperation("获取指定名称的视图字段")
	public ResultVo getColumnByViewName(String name){
		return viewService.getColumnByViewName(name);
	}


	@GetMapping("getAllViewName")
	@ApiOperation("获取所有视图名称")
	public ResultVo getAllViewName(){
		return viewService.getAllViewName();
	}

	@PostMapping("query")
	@ApiOperation("查询")
	public ResultVo query(@RequestBody DynamicQueryVo vo){
		return viewService.query(vo);
	}

	@PostMapping("save")
	public ResultVo save(DynamicQueryVo vo){
		return ResultVo.ok();
	}
}
