package com.microcore.center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.microcore.api.SysApi;
import com.microcore.api.model.DbLabelKit;
import com.microcore.api.model.DbOrg;
import com.microcore.center.context.VCodeContext;
import com.microcore.center.service.DbLabelKitService;
import com.microcore.center.service.DbOrgService;
import com.microcore.center.vo.DbLabelKitVo;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.StringUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("dbLabelKit")
@Slf4j
public class DbLabelKitController {

	private final DbLabelKitService dbLabelKitService;

	@Autowired
	public DbLabelKitController(DbLabelKitService dbLabelKitService) {
		this.dbLabelKitService = dbLabelKitService;
	}

	@GetMapping("labelKitList")
	public ResultVo<PageInfo<DbLabelKit>> labelKitList(@RequestParam(name = "orgId") String orgId,
			@RequestParam(name = "pageIndex") Integer pageIndex, @RequestParam(name = "pageSize") Integer pageSize) {
		return ResultVo.ok(dbLabelKitService.labelKitList(orgId, pageIndex, pageSize));
	}

	@GetMapping("getDbLabelKit")
	public ResultVo<DbLabelKit> getDbLabelKit(@RequestParam(name = "orgId") String orgId) {
		PageInfo<DbLabelKit> page = dbLabelKitService.labelKitList(orgId, 1, 1);
		if (CommonUtil.isEmpty(page.getList())) {
			return ResultVo.ok();
		}
		return ResultVo.ok(page.getList().get(0));
	}
	
	@GetMapping("getDbLabelKitById")
	public ResultVo<DbLabelKit> getDbLabelKitById(@RequestParam(name = "id") String id) {
		DbLabelKit labelKit = dbLabelKitService.getDbLabelKit(id);
		return ResultVo.ok(labelKit);
	}

	@PostMapping("add")
	public ResultVo add(@RequestBody DbLabelKit dbLabelKit) {
		return ResultVo.ok(dbLabelKitService.add(dbLabelKit));
	}

	@PostMapping("update")
	public ResultVo update(@RequestBody DbLabelKit dbLabelKit) {
		return ResultVo.ok(dbLabelKitService.update(dbLabelKit));
	}

	@PostMapping("delete")
	public ResultVo delete(@RequestBody String id) {
		dbLabelKitService.delete(id);
		return ResultVo.ok();
	}

	@PostMapping("getVCode")
	public ResultVo getVCode(@RequestBody DbLabelKit dbLabelKit) {
		if (dbLabelKitService.getDbLabelKit(dbLabelKit.getId()) == null) {
			return ResultVo.fail("数据ID非法！");
		}
		String vcode = VCodeContext.addVCodeInfo(dbLabelKit.getId());
		return ResultVo.ok(vcode);
	}

	@PostMapping("startLabelKit")
	public ResultVo startLabelKit(@RequestBody DbLabelKitVo dbLabelKitVo) {
		String macAddress = dbLabelKitVo.getMacAddress();
		String tagIp = dbLabelKitVo.getTagIp();
		String tagPort = dbLabelKitVo.getTagPort();
		String vCode = dbLabelKitVo.getVcode();

		DbLabelKit dbLabelKit = dbLabelKitService.getDbLabelKit(tagIp, tagPort);
		if (dbLabelKit == null) {
			return ResultVo.fail("请先到平台登记标签服务信息！");
		}
		if (StringUtil.isEmpty(dbLabelKit.getMacAddress())) {
			VCodeContext.addVCodeInfo(dbLabelKit.getId(), vCode);
			if (VCodeContext.verifyVCode(dbLabelKit.getId(), vCode)) {
				dbLabelKit.setMacAddress(macAddress);
				dbLabelKit.setStatus("RUN");
				dbLabelKitService.update(dbLabelKit);
			} else {
				return ResultVo.fail("验证码错误！");
			}
		} else {
			if (!dbLabelKit.getMacAddress().equals(macAddress)) {
				return ResultVo.fail("设备已经绑定！");
			}
		}

		return ResultVo.ok(dbLabelKit);
	}

	@ApiOperation(value = "清除MAC地址", notes = "清除MAC地址")
	@ApiImplicitParam(name = "DbLabelKit", value = "套件实体", required = true, dataType = "DbLabelKit")
	@PostMapping("clearnMAC")
	public ResultVo clearnMAC(@RequestBody DbLabelKit dbLabelKit) {
		try {
			return dbLabelKitService.clearMAC(dbLabelKit);
		} catch (Exception e) {
			log.error("clearnMAC failed");
			return ResultVo.fail("清除失败！");
		}
	}

	@Autowired
	private SysApi sysApi;
	@Autowired
	private DbOrgService dbOrgService;

	@GetMapping("getLabelIp")
	public ResultVo<String> getLabelIp(String orgId) {

		String labelIp = getRunningLabelIp(orgId);
		if(labelIp == null) {
			return ResultVo.fail("本机构及上级机构未安装标签服务！");
		}else {
			return ResultVo.ok(labelIp);
		}
		
	}

	private String getRunningLabelIp(String orgId) {
		ResultVo resultVo = sysApi.isTagRun(orgId, "-label");
		if (resultVo.getStatus() == 200 && "true".equals(resultVo.getData() + "")) {
				DbLabelKit dbLabelKit = dbLabelKitService.getDbLabelKitByOrgId(orgId);
				if (dbLabelKit != null) {
					return dbLabelKit.getTagIp();
				}
		}
		DbOrg dbOrg = dbOrgService.getDbOrgByOrgId(orgId);
		if (dbOrg != null && StringUtil.isNotEmpty(dbOrg.getOrgPid())) {
			return getRunningLabelIp(dbOrg.getOrgPid());
		}
		return null;
	}

}
