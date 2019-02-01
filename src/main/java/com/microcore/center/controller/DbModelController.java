package com.microcore.center.controller;

import com.github.pagehelper.PageInfo;
import com.microcore.center.dto.DbModelDto;
import com.microcore.center.model.DbModel;
import com.microcore.center.service.DbModelService;
import com.microcore.center.util.ExcelUtil;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.StringUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 模型管理
 */
@RestController
@RequestMapping("dbModel")
@Slf4j
public class DbModelController {

	@Autowired
	private DbModelService dbModelService;

	@ApiOperation(value = "添加模型", notes = "添加模型")
	@ApiImplicitParam(name = "model", value = "DbModel对象", required = true, dataType = "DbModelDto")
	@PostMapping("addModel")
	public ResultVo addModel(@RequestBody DbModelDto model) {
		model.setPubCount(0);
		return dbModelService.addModel(model);
	}

	@ApiOperation(value = "模型列表", notes = "模型列表")
	@GetMapping("listModel")
	public ResultVo listModel() {
		return ResultVo.ok(dbModelService.listModel());
	}

	@ApiOperation(value = "获取模型级别", notes = "获取模型级别")
	@GetMapping("getModelDataLevels")
	public ResultVo getModelDataLevels() {
		return dbModelService.getModelDataLevels();
	}

	@ApiOperation(value = "获取模型总量", notes = "获取模型总量")
	@GetMapping("getModelCount")
	public ResultVo getModelCount() {
		return ResultVo.ok(dbModelService.getModelCount());
	}

	@ApiOperation(value = "根据模型类别获取模型总量", notes = "根据模型类别获取模型总量")
	@GetMapping("getModelCountByDataLevel")
	@ApiImplicitParam(name = "dataLevel", value = "模型级别", required = true, dataType = "String")
	public ResultVo getModelCountByDataLevel(@RequestParam(name = "dataLevel") String dataLevel) {
		return ResultVo.ok(dbModelService.getModelCountByDataLevel(dataLevel));
	}

	@ApiOperation(value = "分页获取模型", notes = "分页获取模型")
	@ApiImplicitParams({@ApiImplicitParam(name = "dataLevel", value = "模型级别", dataType = "String"),
			@ApiImplicitParam(name = "pageIndex", value = "页码", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "Integer")})
	@GetMapping("getModelList")
	public ResultVo<PageInfo<DbModel>> getModelList(@RequestParam(name = "dataLevel") String dataLevel,
	                                                @RequestParam(name = "pageIndex") Integer pageIndex,
	                                                @RequestParam(name = "pageSize") Integer pageSize) {
		return dbModelService.getModels(dataLevel, pageIndex, pageSize);
	}

	@ApiOperation(value = "搜索模型", notes = "搜索模型")
	@ApiImplicitParams({@ApiImplicitParam(name = "modelType", value = "模型类型(DB, FILE, SERVICE)", dataType = "String"),
			@ApiImplicitParam(name = "modelName", value = "模型名", dataType = "String"),
			@ApiImplicitParam(name = "pageIndex", value = "页码", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "Integer")})

	@GetMapping("searchModels")
	public ResultVo searchModels(@RequestParam(name = "modelType") String modelType,
	                             @RequestParam(name = "modelName") String modelName, @RequestParam(name = "dataLevel") String dataLevel,
	                             @RequestParam(name = "pageIndex") Integer pageIndex, @RequestParam(name = "pageSize") Integer pageSize) {
		return dbModelService.searchModels(modelType, modelName, dataLevel, pageIndex, pageSize);
	}

	@ApiOperation(value = "模型搜索", notes = "模型搜索")
	@GetMapping("queryModels")
	public ResultVo queryModels(@RequestParam(name = "modelName") String modelName,
	                            @RequestParam(name = "modelTrade") String modelTrade) {
		return ResultVo.ok(dbModelService.queryModels(modelName, modelTrade));
	}

	@ApiOperation(value = "机构视角获取模型", notes = "机构视角获取模型")
	@GetMapping("getModelsByOrg")
	public ResultVo getModelsByOrgId(String orgId, String modelName, String modelType, Integer pageIndex, Integer pageSize) {
		return ResultVo.ok(dbModelService.getModelsByOrgId(orgId, modelName, modelType, pageIndex, pageSize));
	}

	@ApiOperation(value = "行业视角获取模型", notes = "行业视角获取模型")
	@GetMapping("getModelsByTrade")
	public ResultVo getModelsByTradeId(String tradeId, String modelName, String modelType, Integer pageIndex, Integer pageSize) {
		return ResultVo.ok(dbModelService.getModelsByTradeId(tradeId, modelName, modelType, pageIndex, pageSize));
	}

	@ApiOperation(value = "删除模型", notes = "根据ID删除模型")
	@ApiImplicitParam(name = "id", value = "连接id", required = true, dataType = "String")
	@PostMapping("deleteModel")
	ResultVo<String> deleteModel(@RequestBody String id) {
		return dbModelService.deleteModelById(id);
	}

	@ApiOperation(value = "更新模型", notes = "更新模型")
	@ApiImplicitParam(name = "model", value = "DbModel对象", required = true, dataType = "DbModel")
	@PostMapping("updateModel")
	ResultVo<String> updateModel(@RequestBody DbModelDto model) {
		return dbModelService.updateModel(model);
	}

	@ApiOperation(value = "获取模型详情", notes = "获取模型详情")
	@GetMapping("modelDetailedInfo")
	ResultVo modelDetailedInfo(@RequestParam(name = "id") String id) {
		return dbModelService.getModelDetailedInfo(id);
	}

	@PostMapping("importModel")
	ResultVo importModel(@RequestParam(name = "file") MultipartFile file) {
		DbModelDto modelDto = null;
		try {
			modelDto = ExcelUtil.readExcel(file);
			modelDto.setModelType("DB");
			dbModelService.addModelByExcel(modelDto);
		} catch (Exception e) {
			return ResultVo.fail(e.getMessage());
		}
		return ResultVo.ok("导入成功");
	}

	@GetMapping("downloadModel")
	public void download(String type, HttpServletResponse res) {
		String filePath = dbModelService.getModelFile(type);
		if (StringUtil.isEmpty(filePath))
			return;
		File file = new File(filePath);
		if (!file.isFile())
			return;
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
		OutputStream toClient = null;
		InputStream fis = null;
		try {
			fis = new BufferedInputStream(new FileInputStream(file));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			toClient = new BufferedOutputStream(res.getOutputStream());
			toClient.write(buffer);
			toClient.flush();
		} catch (Exception e) {
			log.error("download failed", e);
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					log.error("IOException", e);
				}
			}
			if (toClient != null) {
				try {
					toClient.close();
				} catch (IOException e) {
					log.error("IOException", e);
				}
			}

		}
	}
	
	@GetMapping("getOrgListByModel")
	ResultVo getOrgListByModel() {
		return ResultVo.ok(dbModelService.getOrgListByModel());
	}
	
	@GetMapping("getTradeListByModel")
	ResultVo getTradeListByModel() {
		return ResultVo.ok(dbModelService.getTradeListByModel());
	}

}
