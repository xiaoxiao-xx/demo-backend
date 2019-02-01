package com.microcore.center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microcore.api.model.DbFileKit;
import com.microcore.api.vo.ClearFileOpVo;
import com.microcore.center.client.FileKitTemplate;
import com.microcore.center.dto.DbFileKitDto;
import com.microcore.center.service.DbFileKitService;
import com.microcore.center.vo.DbFileKitVo;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.StringUtil;
import com.microcore.common.util.UserUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@RestController
@RequestMapping("filekit")
@Slf4j
public class DbFileKitController {

	private final DbFileKitService dbFileKitService;
	private final FileKitTemplate fileKitTemplate;

	@Autowired
	public DbFileKitController(DbFileKitService dbFileKitService, FileKitTemplate fileKitTemplate) {
		this.dbFileKitService = dbFileKitService;
		this.fileKitTemplate = fileKitTemplate;
	}

	@ApiOperation(value = "新增套件", notes = "新增套件")
	@ApiImplicitParam(name = "dbFileKitDto", value = "套件实体", required = true, dataType = "DbFileKitDto")
	@PostMapping("addDbFileKit")
	public ResultVo addDbFileKit(@RequestBody DbFileKitDto dbFileKitDto) {
		try {
			return dbFileKitService.addDbFileKit(dbFileKitDto);
		} catch (Exception e) {
			log.error("addDbFileKit fail", e);
			return ResultVo.fail("新增失败！");
		}
	}

	@ApiOperation(value = "修改套件", notes = "修改套件")
	@ApiImplicitParam(name = "dbFileKitDto", value = "套件实体", required = true, dataType = "DbFileKitDto")
	@PostMapping("updDbFileKit")
	public ResultVo updDbFileKit(@RequestBody DbFileKitDto dbFileKitDto) {
		try {
			return dbFileKitService.updDbFileKit(dbFileKitDto);
		} catch (Exception e) {
			log.error("updDbFileKit fail", e);
			return ResultVo.fail("修改失败！");
		}
	}

	@ApiOperation(value = "清除MAC地址", notes = "清除MAC地址")
	@ApiImplicitParam(name = "dbFileKitDto", value = "套件实体", required = true, dataType = "DbFileKitDto")
	@PostMapping("clearnMAC")
	public ResultVo clearnMAC(@RequestBody DbFileKitDto dbFileKitDto) {
		try {
			return dbFileKitService.clearMAC(dbFileKitDto);
		} catch (Exception e) {
			log.error("clearnMAC fail", e);
			return ResultVo.fail("清除失败！");
		}
	}

	@ApiOperation(value = "删除套件", notes = "通过ID删除套件")
	@ApiImplicitParam(name = "kid", value = "套件ID", required = true, dataType = "String")
	@PostMapping("delDbFileKit")
	public ResultVo delDbFileKit(@RequestBody String kid) {
		try {
			return dbFileKitService.delDbFileKit(kid);
		} catch (Exception e) {
			log.error("delDbFileKit fail", e);
			return ResultVo.fail("删除失败！");
		}
	}

	@ApiOperation(value = "启动/禁用 套件", notes = "通过ID 启动/禁用 套件")
	@ApiImplicitParam(name = "kid", value = "套件ID", required = true, dataType = "String")
	@PostMapping("startDbFileKit")
	public ResultVo startDbFileKit(@RequestParam String kid) {
		return dbFileKitService.startDbFileKit(kid);
	}

	@ApiOperation(value = "根据机构ID套件", notes = "根据机构ID套件")
	@ApiImplicitParam(name = "orgId", value = "机构ID", required = true, dataType = "String")
	@GetMapping("getDbFileKitByOrgId")
	public ResultVo getDbFileKitByOrgId(@RequestParam String orgId) {
		try {
			return dbFileKitService.getDbFileKitByOrgId(orgId);
		} catch (Exception e) {
			log.error("getDbFileKitByOrgId fail", e);
			return ResultVo.ok(new DbFileKit());
		}
	}

	@ApiOperation(value = "根据ID套件", notes = "根据ID套件")
	@ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String")
	@GetMapping("getDbFileKitById")
	public ResultVo getDbFileKitById(@RequestParam String id) {
		try {
			return dbFileKitService.getDbFileKitById(id);
		} catch (Exception e) {
			log.error("getDbFileKitById fail", e);
			return ResultVo.ok(new DbFileKit());
		}
	}

	@ApiOperation(value = "套件ID获取验证码", notes = "套件ID获取验证码")
	@ApiImplicitParam(name = "kid", value = "套件ID", required = true, dataType = "String")
	@GetMapping("getVCode")
	public ResultVo getVCode(String kid) {
		return dbFileKitService.getVCode(kid);
	}

	@PostMapping("contrast")
	public ResultVo contrast(@RequestBody DbFileKitVo dbFileKitVo) {
		return dbFileKitService.contrast(dbFileKitVo);
	}

	@GetMapping("getFileSpace")
	public ResultVo getFileSpace(@RequestParam(name = "kitId") String kitId) {
		return fileKitTemplate.fileServiceRPC("/kit/getFileSpace", null, kitId);
	}

	@GetMapping("getFileInfo")
	public ResultVo getFileInfo(@RequestParam(name = "kitId") String kitId, @RequestParam(name = "type") String type) {
		return fileKitTemplate.fileServiceRPC("/kit/getFileInfo", type, kitId);
	}
	
	@GetMapping("getFileInfoByOrg")
	public ResultVo getFileInfoByOrg(@RequestParam(name = "type") String type) {
		if (StringUtil.isEmpty(type)) {
			type = "exchange";
		}
		DbFileKit fileKit = dbFileKitService.getDbFileKitByOrg();
		if (null==fileKit) {
			return ResultVo.fail("请先注册文件套件");
		}
		String kitId = fileKit.getId();
		return fileKitTemplate.fileServiceRPC("/kit/getFileInfo", type, kitId);
	}

	@PostMapping("clearFile")
	public ResultVo clearFile(@RequestBody ClearFileOpVo clearFileOpVo) {
		fileKitTemplate.fileService("/kit/clearFile", clearFileOpVo, clearFileOpVo.getKitId());
		return ResultVo.ok();
	}

}
