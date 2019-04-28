package com.rainyhon.backend.controller;

import com.rainyhon.common.service.DynamicQueryConditionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("DynamicQueryConditionController")
@Api("自定义查询条件")
public class DynamicQueryConditionController {

	@Autowired
	private DynamicQueryConditionService service;

}