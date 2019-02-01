package com.microcore.center.controller;

import com.microcore.center.dto.DbExtTemplateDto;
import com.microcore.center.model.DbExtTemplate;
import com.microcore.center.service.DbExtTemplateService;
import com.microcore.common.util.ResultVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 策略扩展属性
 */
@RestController
@RequestMapping("dbExtTemplate")
public class DbExtTemplateController {

	private final DbExtTemplateService extTemplateService;

	@Autowired
	public DbExtTemplateController(DbExtTemplateService extTemplateService) {
		this.extTemplateService = extTemplateService;
	}

	@ApiOperation(value = "根据ID查询扩展属性", notes = "根据ID查询扩展属性")
	@ApiImplicitParam(name = "id", value = "扩展属性ID", required = true, dataType = "String")
	@GetMapping("getExtTemplateById")
	public ResultVo<DbExtTemplateDto> getExtTemplateById(@RequestParam(name = "id") String id) {
		return ResultVo.ok(extTemplateService.getExtTemplateById(id));
	}

	@ApiOperation(value = "查询扩展属性", notes = "查询扩展属性")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "templateType", value = "模板类型（COLUMN, MODEL）", required = true, dataType = "String"),
			@ApiImplicitParam(name = "getAll", value = "是否获取所有扩展属性", required = true, dataType = "String") })
	@GetMapping("getExtTemplateList")
	public ResultVo<List<DbExtTemplateDto>> getExtTemplateList(@RequestParam(name = "templateType", required = false) String templateType,
	                                                           @RequestParam(name = "getAll", required = false) String getAll) {
		boolean all = "YES".equals(getAll);
		return ResultVo.ok(extTemplateService.getExtTemplateList(templateType, all));
	}

	@ApiOperation(value = "添加扩展属性", notes = "添加扩展属性")
	@ApiImplicitParam(name = "extTemplate", value = "DbExtTemplate对象", required = true, dataType = "DbExtTemplate")
	@PostMapping("addExtTemplate")
	public ResultVo<String> addExtTemplate(@RequestBody DbExtTemplate extTemplate) {
		extTemplateService.addExtTemplate(extTemplate);
		return ResultVo.ok();
	}

	@ApiOperation(value = "根据ID删除扩展属性", notes = "根据ID删除扩展属性")
	@ApiImplicitParam(name = "id", value = "扩展属性ID", required = true, dataType = "String")
	@PostMapping("deleteExtTemplateById")
	public ResultVo<String> deleteExtTemplateById(@RequestParam String id) {
		return extTemplateService.deleteExtTemplateById(id);
	}

	@ApiOperation(value = "更新扩展属性", notes = "更新扩展属性")
	@ApiImplicitParam(name = "extTemplate", value = "DbExtTemplate对象", required = true, dataType = "DbExtTemplate")
	@PostMapping("updateExtTemplate")
	public ResultVo<String> updateExtTemplate(@RequestBody DbExtTemplate extTemplate) {
		extTemplateService.updateExtTemplate(extTemplate);
		return ResultVo.ok();
	}

}

