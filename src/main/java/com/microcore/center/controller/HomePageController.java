package com.microcore.center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microcore.center.service.HomePageService;
import com.microcore.common.util.ResultVo;

import io.swagger.annotations.ApiOperation;

/**
 * 首页管理
 */
@RestController
@RequestMapping("homePage")
public class HomePageController {

	private final HomePageService homePageService;

	@Autowired
	public HomePageController(HomePageService homePageService) {
		this.homePageService = homePageService;
	}

	@Cacheable(value = "data1")
	@ApiOperation(value = "各行业模型数量统计", notes = "各行业模型数量统计")
	@GetMapping("getModelStat")
	public ResultVo getModelStat() {
		return ResultVo.ok(homePageService.getModelStat());
	}

	@Cacheable(value = "data2")
	@ApiOperation(value = "模型订阅频次TOP5", notes = "模型订阅频次TOP5")
	@GetMapping("modelSubTop5")
	public ResultVo modelSubTop5() {
		return ResultVo.ok(homePageService.modelSubTop5());
	}

	@Cacheable(value = "data3")
	@ApiOperation(value = "机构数据流转量TOP5", notes = "机构数据流转量TOP5")
	@GetMapping("orgDataSubTop5")
	public ResultVo orgDataSubTop5() {
		return ResultVo.ok(homePageService.orgDataSubTop5());
	}

	@Cacheable(value = "data4")
	@ApiOperation(value = "库表数据流转量", notes = "库表数据流转量")
	@GetMapping("dbDataSubCount")
	public ResultVo dbDataSubCount() {
		return ResultVo.ok(homePageService.dbDataSubCount());
	}

	@Cacheable(value = "data5")
	@ApiOperation(value = "文件数据流转量", notes = "文件数据流转量")
	@GetMapping("getFileRecord")
	public ResultVo getFileRecord() {
		return ResultVo.ok(homePageService.getFileRecord());
	}

	@Cacheable(value = "data6")
	@ApiOperation(value = "获取近一年每月服务接口调用量", notes = "获取近一年每月服务接口调用量")
	@GetMapping("getServiceRecord")
	public ResultVo getServiceRecord() throws Exception {
		return homePageService.getServiceRecord();
	}

	@Cacheable(key = "#p0", value = "data7")
	@ApiOperation(value = "获取本机构的数据流转", notes = "获取本机构的数据流转")
	@GetMapping("getUseOrgs")
	public ResultVo getUseOrgs(String orgId) {
		return homePageService.getUseOrgs(orgId,"pub");
	}

	@ApiOperation(value = "获取机构的地址经纬度", notes = "获取机构的地址经纬度")
	@GetMapping("getLngByOrgId")
	public ResultVo getLngByOrgId(String orgId) {
		return homePageService.getLngByOrgId(orgId);
	}

	@ApiOperation(value = "获取机构的地址经纬度", notes = "获取机构的地址经纬度")
	@GetMapping("getOrgDataUse")
	public ResultVo getOrgDataUse() {
		return homePageService.getOrgDataUse();
	}

	@ApiOperation(value = "清理并重新加载缓存", notes = "清理并重新加载缓存")
	@GetMapping("clearOrgAddressCache")
	public ResultVo clearOrgAddressCache() {
		return homePageService.clearOrgAddressCache();
	}

}
