package com.microcore.center.controller;

import com.github.pagehelper.PageInfo;
import com.microcore.center.dto.DbApprovalDto;
import com.microcore.center.model.DbApproval;
import com.microcore.center.service.DbApprovalService;
import com.microcore.center.vo.DbApprovalVo;
import com.microcore.common.util.ResultVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 审批
 *
 * @author lmh
 */
@RestController
@RequestMapping("dbApproval")
public class DbApprovalController {

	private final DbApprovalService dbApprovalService;

	@Autowired
	public DbApprovalController(DbApprovalService dbApprovalService) {
		this.dbApprovalService = dbApprovalService;
	}

	@ApiOperation(value = "查询库表、文件、接口、数据服务发布为无审批发布还是有审批发布(YES-有审批发布，NO-无审批发布)",
			notes = "查询库表、文件、接口、数据服务发布为无审批发布还是有审批发布(YES-有审批发布，NO-无审批发布)")
	@GetMapping("pubTableWithApproval")
	public ResultVo pubWithApproval() {
		return dbApprovalService.pubWithApproval();
	}

	/**
	 * 有审批发布调用该接口
	 */
	@ApiOperation(value = "提交审批申请", notes = "提交审批申请")
	@ApiImplicitParam(name = "dbApproval", value = "DbApproval对象", required = true, dataType = "DbApproval")
	@PostMapping("submitPubApproval")
	public ResultVo submitPubApproval(@RequestBody DbApproval dbApproval) {
		return dbApprovalService.submitPubApproval(dbApproval);
	}

	@ApiOperation(value = "批量提交审批申请", notes = "批量提交审批申请")
	@ApiImplicitParam(name = "list", value = "DbApproval对象列表", required = true, dataType = "List<DbApproval>")
	@PostMapping("submitPubApprovalBatch")
	public ResultVo submitPubApprovalBatch(@RequestBody List<DbApproval> list) {
		return dbApprovalService.submitPubApprovalBatch(list);
	}

	@ApiOperation(value = "审批被拒绝后重新提交审批申请", notes = "审批被拒绝后重新提交审批申请")
	@ApiImplicitParam(name = "dbApproval", value = "DbApproval对象", required = true, dataType = "DbApproval")
	@PostMapping("resubmitPubApproval")
	public ResultVo resubmitPubApproval(@RequestBody DbApproval dbApproval) {
		return dbApprovalService.resubmitPubApproval(dbApproval);
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "type", value = "审批类型", required = true, dataType = "String"),
			@ApiImplicitParam(name = "status", value = "审批状态", required = true, dataType = "String"),
			@ApiImplicitParam(name = "pageIndex", value = "页码", required = true, dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "每页大小", required = true, dataType = "Integer")
	})
	@GetMapping("getApprovalList")
	public ResultVo<PageInfo<DbApprovalDto>> getDbApprovalLIst(@RequestParam String type, @RequestParam String status,
	                                                           @RequestParam Integer pageIndex, @RequestParam Integer pageSize) {
		return ResultVo.ok(dbApprovalService.getDbApprovalList(type, status, pageIndex, pageSize));
	}

	@ApiOperation(value = "根据ID获取审批", notes = "根据ID获取审批")
	@ApiImplicitParam(name = "id", value = "审批ID", required = true, dataType = "String")
	@GetMapping("getApprovalById")
	public ResultVo<DbApprovalDto> getDbApprovalById(@RequestParam String id) {
		return ResultVo.ok(dbApprovalService.getDbApprovalById(id));
	}

	@ApiOperation(value = "根据发布ID获取审批", notes = "根据发布ID获取审批")
	@ApiImplicitParam(name = "pubId", value = "发布ID", required = true, dataType = "String")
	@GetMapping("getApprovalByPubId")
	public ResultVo<DbApprovalDto> getDbApprovalByPubId(@RequestParam String pubId) {
		return ResultVo.ok(dbApprovalService.getDbApprovalByPubId(pubId));
	}

	@ApiOperation(value = "处理审批", notes = "处理审批")
	@ApiImplicitParam(name = "dbApproval", value = "DbApproval对象", required = true, dataType = "DbApproval")
	@PostMapping("handleApproval")
	public ResultVo<String> updateApproval(@RequestBody DbApprovalVo dbApproval) {
		dbApprovalService.handleApproval(dbApproval);
		return ResultVo.ok();
	}

	@ApiOperation(value = "根据ID删除审批", notes = "根据ID删除审批")
	@ApiImplicitParam(name = "id", value = "审批ID", required = true, dataType = "String")
	@PostMapping("deleteApprovalById")
	public ResultVo<String> delete(@RequestParam String id) {
		dbApprovalService.deleteApprovalById(id);
		return ResultVo.ok();
	}

}

