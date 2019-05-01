package com.rainyhon.backend.controller;

import com.rainyhon.common.service.HomePageService;
import com.rainyhon.common.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("homePage")
public class HomePageController {

	@Autowired
	private HomePageService homePageService;

	@ApiOperation(value = "获取首页统计信息", notes = "获取首页统计信息")
	@GetMapping("getHomePageStatInfo")
	public ResultVo<?> getHomePageStatInfo() {
		return homePageService.getHomePageStatInfo();
	}

}
