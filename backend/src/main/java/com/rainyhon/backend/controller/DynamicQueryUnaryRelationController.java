package com.rainyhon.backend.controller;

import com.rainyhon.common.service.DynamicQueryUnaryRelationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("DynamicQueryUnaryRelationController")
@Api("自定义查询一元")
public class DynamicQueryUnaryRelationController {

	@Autowired
	private DynamicQueryUnaryRelationService service;

}