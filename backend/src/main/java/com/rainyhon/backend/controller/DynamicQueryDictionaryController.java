package com.rainyhon.backend.controller;

import com.rainyhon.common.service.DynamicQueryDictionaryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("DynamicQueryDictionaryController")
@Api("自定义查询字典")
public class DynamicQueryDictionaryController {

	@Autowired
	private DynamicQueryDictionaryService service;

}