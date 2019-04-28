package com.rainyhon.backend.controller;

import com.rainyhon.common.service.DynamicQueryService;
import com.rainyhon.common.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("DynamicQueryController")
@Api("自定义查询")
public class DynamicQueryController {

	@Autowired
	private DynamicQueryService service;


	@GetMapping("page")
	@ApiOperation("分页查询")
	/*
	@ApiImplicitParams({
			@ApiImplicitParam(value = "viewDisplayName", name = "viewDisplayName", type = "String"),
			@ApiImplicitParam(value = "pageIndex", name = "pageIndex", type = "Integer"),
			@ApiImplicitParam(value = "pageSize", name = "pageSize", type = "Integer")
	})*/
	public ResultVo page(String viewDisplayName, Integer pageIndex, Integer pageSize) {
		return service.page(viewDisplayName, pageIndex, pageSize);
	}

}