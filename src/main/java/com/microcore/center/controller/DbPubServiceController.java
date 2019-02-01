package com.microcore.center.controller;

import com.microcore.center.dto.DbPubServiceDto;
import com.microcore.center.service.DbPubServiceService;
import com.microcore.center.vo.AddPubServiceVo;
import com.microcore.center.vo.TestService;
import com.microcore.common.util.ResultVo;
import com.microcore.common.vo.WithdrawPubVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 服务接口发布
 */
@RestController
@RequestMapping("dbPubService")
public class DbPubServiceController {

	private final DbPubServiceService dbPubServiceService;

	@Autowired
	public DbPubServiceController(DbPubServiceService dbPubServiceService) {
		this.dbPubServiceService = dbPubServiceService;
	}

	@ApiOperation(value = "新增服务接口任务", notes = "新增服务接口信息")
	@ApiImplicitParam(name = "addPubServiceVo", value = "服务接口vo对象", required = true, dataType = "AddPubServiceVo")
	@PostMapping("/addService")
	public ResultVo addService(@RequestBody AddPubServiceVo addPubServiceVo) {
		return dbPubServiceService.addService(addPubServiceVo);
	}

	@ApiOperation(value = "获取已经/尚未发布服务接口列表", notes = "获取已经/尚未发布服务接口列表信息")
	@ApiImplicitParam(name = "pubStatus", value = "服务接口发布状态(PUB/NOT)", required = true, dataType = "String")
	@GetMapping("/getPubServiceList")
	public ResultVo getPubServiceList(@RequestParam String pubStatus,String name, Integer pageIndex, Integer pageSize) {
		return dbPubServiceService.getPubServiceList(pubStatus, null, name, pageIndex, pageSize);
	}

	@ApiOperation(value = "获取单个未发布服务接口", notes = "获取单个服务接口信息")
	@ApiImplicitParam(name = "id", value = "服务接口ID", required = true, dataType = "String")
	@GetMapping("/getPubService")
	public ResultVo getPubService(@RequestParam String id) {
		return dbPubServiceService.getPubService(id);
	}

	@ApiOperation(value = "修改服务接口配置", notes = "修改服务接口配置信息")
	@ApiImplicitParam(name = "addPubServiceVo", value = "服务接口vo对象", required = true, dataType = "AddPubServiceVo")
	@PostMapping("/updatePubService")
	public ResultVo updatePubService(@RequestBody AddPubServiceVo addPubServiceVo) {
		return dbPubServiceService.updatePubService(addPubServiceVo);
	}

	@ApiOperation(value = "批量删除服务接口", notes = "批量删除服务接口")
	@ApiImplicitParam(name = "ids", value = "多个服务接口ID", required = true, dataType = "String")
	@GetMapping("/volumeDeletePubService")
	public ResultVo volumeDeletePubService(@RequestParam String ids) {
		return dbPubServiceService.volumeDeletePubService(ids);
	}

	@ApiOperation(value = "发布服务接口", notes = "发布服务接口")
	@ApiImplicitParam(name = "id", value = "服务接口ID", required = true, dataType = "String")
	@GetMapping("/publishService")
	public ResultVo publishService(@RequestParam String id) {
		return dbPubServiceService.publishService(id);
	}

	@ApiOperation(value = "批量发布服务接口", notes = "批量发布服务接口")
	@PostMapping("publishServiceBatch")
	public ResultVo publishServiceBatch(@RequestBody List<String> ids) {
		return dbPubServiceService.publishServiceBatch(ids);
	}

	@ApiOperation(value = "启动/停用已发布服务接口", notes = "启动/停用已发布服务接口")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "服务接口ID", required = true, dataType = "String"),
			@ApiImplicitParam(name = "runStatus", value = "服务接口的运行状态(RUN/STOP)", required = true, dataType = "String")
	})
	@GetMapping("/updateServiceRunStatus")
	public ResultVo updateServiceRunStatus(@RequestParam String id, @RequestParam String runStatus) {
		return dbPubServiceService.updateServiceRunStatus(id, runStatus);
	}

	@ApiOperation(value = "批量启动/停用已发布服务接口", notes = "批量启动/停用已发布服务接口")
	@PostMapping("updateServiceRunStatusBatch")
	public ResultVo updateServiceRunStatusBatch(@RequestBody DbPubServiceDto dto) {
		return dbPubServiceService.updateServiceRunStatusBatch(dto.getIds(), dto.getRunStatus());
	}

	@ApiOperation(value = "获取接口类型/请求方式", notes = "获取接口类型/请求方式")
	@ApiImplicitParam(name = "typeOrMode", value = "接口类型:inter_type/请求方式:reque_mode", required = true, dataType = "String")
	@GetMapping("/getTypeOrMode")
	public ResultVo getTypeOrMode(@RequestParam String typeOrMode) {
		return dbPubServiceService.getTypeOrMode(typeOrMode);
	}

	@ApiOperation(value = "服务接口测试", notes = "服务接口测试")
	@ApiImplicitParam(name = "testService", value = "服务接口测试对象", required = true, dataType = "TestService")
	@PostMapping("/testService")
	public ResultVo testService(@RequestBody TestService testService) {
		return dbPubServiceService.testService(testService);
	}

	@ApiOperation(value = "获取WebService接口的方法名", notes = "获取WebService接口的方法名")
	@GetMapping("/getMethodName")
	public ResultVo getMethodName(@RequestParam String url) {
		return dbPubServiceService.getMethodName(url);
	}

	@GetMapping("getWithdrawOrgList")
	public ResultVo getWithdrawOrgList(@RequestParam String pubId) {
		return dbPubServiceService.getWithdrawOrgList(pubId);
	}

	@PostMapping("withdrawPub")
	public ResultVo withdrawPub(@RequestBody WithdrawPubVo vo) {
		return dbPubServiceService.withdrawPub(vo);
	}

}
