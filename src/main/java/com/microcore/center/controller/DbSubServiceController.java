package com.microcore.center.controller;

import com.microcore.center.mapper.DbPubServiceMapper;
import com.microcore.center.model.DbApproval;
import com.microcore.center.model.DbPubService;
import com.microcore.center.model.DbSubService;
import com.microcore.center.service.DbApprovalService;
import com.microcore.center.service.DbSubServiceService;
import com.microcore.center.util.CenterUtil;
import com.microcore.center.vo.SubServiceVo;
import com.microcore.center.vo.TestSubService;
import com.microcore.common.constant.Constants;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.ResultVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 服务接口申请
 *
 * @author 何语非
 */
@RestController
@RequestMapping("dbSubService")
public class DbSubServiceController {

	private final DbSubServiceService dbSubServiceService;

	@Autowired
	private DbApprovalService dbApprovalService;

	@Autowired
	private DbPubServiceMapper dbPubServiceMapper;

	@Autowired
	public DbSubServiceController(DbSubServiceService dbSubServiceService) {
		this.dbSubServiceService = dbSubServiceService;
	}

	@ApiOperation(value = "获取可申请服务接口列表", notes = "获取可申请服务接口列表信息")
	@GetMapping("/getSubServiceList")
	public ResultVo getSubServiceList(String orgId, String name, Integer pageIndex, Integer pageSize) {
		return dbSubServiceService.getSubServiceList(orgId, name, pageIndex, pageSize);
	}

	@ApiOperation(value = "获取单个可申请服务接口", notes = "获取单个可申请服务接口信息")
	@ApiImplicitParam(name = "id", value = "服务接口ID", required = true, dataType = "String")
	@GetMapping("/getSubService")
	public ResultVo getSubService(@RequestParam String id) {
		return dbSubServiceService.getSubService(id);
	}

	@ApiOperation(value = "申请服务接口", notes = "申请服务接口")
	@ApiImplicitParam(name = "pid", value = "服务接口注册ID", required = true, dataType = "String")
	@GetMapping("/applySubService")
	public ResultVo applySubService(@RequestParam String pid) {
		DbPubService pubService = dbPubServiceMapper.selectByPrimaryKey(pid);
		String autoApp = pubService.getAutoApp();
		String uuid = CommonUtil.getUUID();

		if (autoApp == null || Constants.TRUE.equals(autoApp)) {
			return dbSubServiceService.applySubService(uuid, pid, Constants.RUN_STATUS_RUN);
		} else {
			ResultVo resultVo = dbSubServiceService.applySubService(uuid, pid, Constants.PUB_STATUS_APPROVING);
			if (!Constants.STATUS_OK.equals(resultVo.getStatus())) {
				return resultVo;
			}

			DbApproval dbApproval = CenterUtil.buildApproval(Constants.DATA_TYPE_SERVICE, uuid,
					pubService.getCrtUserId(), pubService.getChineseDescribe());
			dbApprovalService.submitSubApproval(dbApproval);

			return ResultVo.ok();
		}
	}

	@ApiOperation(value = "获取已申请服务接口列表", notes = "获取已申请服务接口列表信息")
	@GetMapping("/getAlreadySubServiceList")
	public ResultVo getAlreadySubServiceList(String name, Integer pageIndex, Integer pageSize) {
		return dbSubServiceService.getAlreadySubServiceList(name, pageIndex, pageSize);
	}

	@ApiOperation(value = "获取已申请单个服务接口详情", notes = "获取已申请单个服务接口详情")
	@ApiImplicitParam(name = "sid", value = "服务接口申请ID", required = true, dataType = "String")
	@GetMapping("/getSubServiceDetail")
	public ResultVo getSubServiceDetail(@RequestParam String sid) {
		return dbSubServiceService.getSubServiceDetail(sid);
	}

	@ApiOperation(value = "删除我的订阅服务", notes = "删除我的订阅服务")
	@ApiImplicitParam(name = "ids", value = "多个服务接口ID", required = true, dataType = "String")
	@GetMapping("/delete")
	public ResultVo delete(@RequestParam String ids) {
		return dbSubServiceService.delete(ids);
	}

	@ApiOperation(value = "服务接口测试", notes = "服务接口测试")
	@ApiImplicitParam(name = "params", value = "服务接口测试对象", required = true, dataType = "TestSubService")
	@PostMapping("/testService")
	public ResultVo testService(@RequestBody TestSubService params) {
		return dbSubServiceService.testService(params);
	}

}
