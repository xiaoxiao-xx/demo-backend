package com.rainyhon.backend.controller;

import com.rainyhon.common.service.DynamicQueryUnaryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("DynamicQueryUnaryController")
@Api("自定义查询一元")
public class DynamicQueryUnaryController {

	@Autowired
	private DynamicQueryUnaryService service;

}