package com.rainyhon.backend.controller;

import com.rainyhon.common.service.DynamicQueryColumnService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("DynamicQueryColumnController")
@Api("自定义查询字段")
public class DynamicQueryColumnController {

	@Autowired
	private DynamicQueryColumnService service;

}