package com.microcore.center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microcore.api.model.DbDbKit;
import com.microcore.api.vo.ClearTableOpVo;
import com.microcore.center.client.DbKitTemplate;
import com.microcore.center.context.VCodeContext;
import com.microcore.center.service.DbDbKitService;
import com.microcore.center.vo.DbKitVo;
import com.microcore.common.util.ResultVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * 库表套件管理
 */
@RestController
@RequestMapping("dbKit")
public class DbDbKitController {

	private final DbDbKitService dbKitService;
	private final DbKitTemplate dbKitTemplate;

	@Autowired
	public DbDbKitController(DbDbKitService dbKitService, DbKitTemplate dbKitTemplate) {
		this.dbKitService = dbKitService;
		this.dbKitTemplate = dbKitTemplate;
	}

	@ApiOperation(value = "添加套件信息", notes = "添加添加套件信息")
	@ApiImplicitParam(name = "kitVo", value = "DbKitVo对象", required = true, dataType = "DbKitVo")
	@PostMapping("addKitInfo")
	public ResultVo<?> addKitInfo(@RequestBody DbKitVo kitVo) {
		dbKitService.addKitInfo(kitVo);
		return ResultVo.ok();
	}

	@ApiOperation(value = "删除套件信息", notes = "根据ID删除套件信息")
	@ApiImplicitParam(name = "id", value = "套件信息id", required = true, dataType = "String")
	@PostMapping("deleteKitInfo")
	public ResultVo<?> deleteKitInfo(@RequestParam String id) {
		dbKitService.deleteKitInfoById(id);
		return ResultVo.ok();
	}

	@ApiOperation(value = "更新套件信息", notes = "更新套件信息")
	@ApiImplicitParam(name = "kitDto", value = "DbKitVo对象", required = true, dataType = "DbKitVo")
	@PostMapping("updateKitInfo")
	public ResultVo<?> updateKitInfo(@RequestBody DbKitVo kitDto) {
		dbKitService.updateKitInfo(kitDto);
		return ResultVo.ok();
	}

	@ApiOperation(value = "根据机构ID查询套件信息", notes = "根据机构ID查询套件信息")
	@ApiImplicitParam(name = "orgId", value = "组织机构ID", required = true, dataType = "String")
	@PostMapping("getDbKitByOrgId")
	public ResultVo<?> getDbKitByOrgId(@RequestParam String orgId) {
		return ResultVo.ok(dbKitService.getDbKitByOrgId(orgId));
	}
	
	@ApiOperation(value = "根据ID查询套件信息", notes = "根据ID查询套件信息")
	@ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String")
	@PostMapping("getDbKitById")
	public ResultVo<?> getDbKitById(@RequestParam String id) {
		return ResultVo.ok(dbKitService.getDbKitById(id));
	}

	@ApiOperation(value = "启用库表套件", notes = "启用库表套件")
	@ApiImplicitParam(name = "id", value = "套件信息id", required = true, dataType = "String")
	@PostMapping("enableDbKit")
	public ResultVo<?> enableDbKit(@RequestParam String id) {
		dbKitService.enableDbKit(id);
		return ResultVo.ok();
	}

	@ApiOperation(value = "停用库表套件", notes = "停用库表套件")
	@ApiImplicitParam(name = "id", value = "套件信息id", required = true, dataType = "String")
	@PostMapping("disableDbKit")
	public ResultVo<?> disableDbKit(@RequestParam String id) {
		dbKitService.disableDbKit(id);
		return ResultVo.ok();
	}

	@ApiOperation(value = "解绑MAC地址", notes = "解绑MAC地址")
	@ApiImplicitParam(name = "id", value = "套件信息id", required = true, dataType = "String")
	@PostMapping("unbindMacAddress")
	public ResultVo<?> unbindMacAddress(@RequestParam String id) {
		dbKitService.unbindMacAddress(id);
		return ResultVo.ok();
	}

	@ApiOperation(value = "获取验证码", notes = "获取验证码")
	@ApiImplicitParam(name = "dbKit", value = "DbDbKit对象", required = true, dataType = "DbDbKit")
	@PostMapping("getVCode")
	public ResultVo<?> getVCode(@RequestBody DbDbKit dbKit) {
		// try {
		// if(dbLabelKitService.getDbLabelKit(id) == null) {
		// return ResultVo.fail("数据ID非法！") ;
		// }
		// String token = JwtUtil.createJwtToken(id,
		// TimeUtil.nextMonthDate(CommonUtil.getCurrentTime(), 6));
		// return ResultVo.ok(token);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// return ResultVo.fail("生成token失败！");

		if (dbKitService.getDbKitById(dbKit.getId()) == null) {
			return ResultVo.fail("数据ID非法！");
		}
		String vcode = VCodeContext.addVCodeInfo(dbKit.getId());
		return ResultVo.ok(vcode);
	}

	@ApiOperation(value = "库表套件启动时上传信息并验证", notes = "库表套件启动时上传信息并验证")
	@ApiImplicitParam(name = "dbKitVo", value = "DbKitVo对象", required = true, dataType = "DbKitVo")
	@PostMapping("authDbKitInfo")
	public ResultVo<?> authDbKitInfo(@RequestBody DbKitVo dbKitVo) {
		return dbKitService.authDbKitInfo(dbKitVo);
	}

	@GetMapping("getDbTableInfo")
	public ResultVo<?> getDbTableInfo(@RequestParam(name = "kitId") String kitId,
			@RequestParam(name = "type") String type) {
		return dbKitTemplate.getDbTableInfo(kitId, type);
	}

	@PostMapping("clearTabel")
	public ResultVo<?> clearTable(@RequestBody ClearTableOpVo clearTableOpVo) {
		dbKitTemplate.clearTable(clearTableOpVo);
		return ResultVo.ok();
	}
}
