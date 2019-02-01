package com.microcore.center.controller;

import com.microcore.center.model.DbParams;
import com.microcore.center.service.DbParamsService;
import com.microcore.common.util.ResultVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("dbparams")
public class DbParamsController {

	private final DbParamsService paramsService;

	@Autowired
	public DbParamsController(DbParamsService paramsService) {
		this.paramsService = paramsService;
	}

	@ApiOperation(value = "获取下拉参数", notes = "通过传入类型获取下拉参数")
	@ApiImplicitParam(name = "paramsType", value = "传入类型", required = true, dataType = "String")
	@GetMapping("getParams")
	public ResultVo getTypeOrMode(@RequestParam String paramsType) {
		return ResultVo.ok(paramsService.getTypeOrMode(paramsType));
	}

	@GetMapping("getParamListByTypeAndKey")
	public ResultVo getParamListByTypeAndKey(@RequestParam String paramsType, @RequestParam String paramsKey) {
		return ResultVo.ok(paramsService.getParamListByTypeAndKey(paramsType, paramsKey));
	}

	@ApiOperation(value = "获取交换平台是否启用开关信息", notes = "获取交换平台是否启用开关信息")
	@GetMapping("getExchangePlatformStatus")
	public ResultVo getExchangePlatformStatus() {
		String value = paramsService.getParamsValueByTypeAndKey("exchange_platform", "enable");
		return ResultVo.ok(value);
	}

	@PostMapping("addParams")
	public ResultVo addParams(@RequestBody List<DbParams> params) {
		return paramsService.addParams(params);
	}

	@PostMapping("openOrCloseMasterKey")
	public ResultVo openOrCloseMasterKey(String status){
		return paramsService.openOrCloseMasterKey(status);
	}
	
}
