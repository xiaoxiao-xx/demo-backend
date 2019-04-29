package com.rainyhon.backend.controller;

import com.rainyhon.common.service.DynamicQueryWebService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("DynamicQueryController")
@Api("自定义查询")
public class DynamicQueryWebController {

	@Autowired
	private DynamicQueryWebService service;

}