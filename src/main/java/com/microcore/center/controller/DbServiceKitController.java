package com.microcore.center.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microcore.api.model.DbServiceKit;
import com.microcore.center.dto.DbServiceKitDto;
import com.microcore.center.service.DbServiceKitService;
import com.microcore.center.util.CheckingUtil;
import com.microcore.center.vo.DbServiceKitVo;
import com.microcore.center.vo.ServiceKitVo;
import com.microcore.common.service.CommonService;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.ResultVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 服务接口套件管理
 */
@RestController
@RequestMapping("serviceKit")
public class DbServiceKitController {
	
	@Autowired
	private DbServiceKitService dbServiceKitService;
	@Autowired
	private CommonService commonService ;
	

	@ApiOperation(value = "新增服务接口套件", notes = "新增服务接口套件")
	@ApiImplicitParam(name = "dbServiceKitDto", value = "服务接口套件Dto对象", required = true, dataType = "DbServiceKitDto")
	@PostMapping("addServiceKit")
	public ResultVo addServiceKit(@RequestBody DbServiceKitDto dbServiceKitDto) {
		return dbServiceKitService.addServiceKit(dbServiceKitDto);
	}

	@ApiOperation(value = "修改服务接口套件信息", notes = "修改服务接口套件信息")
	@ApiImplicitParam(name = "dbServiceKitDto", value = "服务接口套件Dto对象", required = true, dataType = "DbServiceKitDto")
	@PostMapping("updateServiceKit")
	public ResultVo updateServiceKit(@RequestBody DbServiceKitDto dbServiceKitDto) {
		return dbServiceKitService.updateServiceKit(dbServiceKitDto);
	}

	@ApiOperation(value = "获取服务接口套件机构列表", notes = "获取服务接口套件机构列表")
	@GetMapping("getServiceKitOrgs")
	public ResultVo getServiceKitOrgs() {
		return dbServiceKitService.getServiceKitOrgs();
	}

	@ApiOperation(value = "获取单个服务接口套件信息", notes = "获取单个服务接口套件信息")
	@ApiImplicitParam(name = "id", value = "机构id", required = true, dataType = "String")
	@GetMapping("getServiceKit")
	public ResultVo getServiceKit(@RequestParam String id) {
		if (CheckingUtil.checkingIsEmpty(id)) {
			return ResultVo.fail("机构ID不能为空！");
		}
		DbServiceKit serviceKit = dbServiceKitService.getServiceKit(id);
		if (serviceKit != null) {
			// return ResultVo.fail("当前机构尚未创建服务接口套件！");
			DbServiceKitVo dbServiceKitVo = CommonUtil.po2VO(serviceKit, DbServiceKitVo.class);
			Map<String, Object> params = new HashMap<>();
			String sql = "SELECT avg(proxy_time) avg ,count(1) call_count  from db_service_record where pub_org_id = #{orgId}";
			params.put("sql", sql);
			params.put("orgId", id);
			Map<String, Object> record = commonService.executeSelectSQL(params).get(0);
			if (record.get("call_count") != null) {
				dbServiceKitVo.setCallCount(((Long) record.get("call_count")));
			}
			if (record.get("avg") != null) {
				dbServiceKitVo.setAvgProxyTime(((BigDecimal) record.get("avg")).longValue());
			}
			return ResultVo.ok(dbServiceKitVo);
		}
		return ResultVo.ok(serviceKit);
	}

	@ApiOperation(value = "获取验证码", notes = "获取验证码")
	@ApiImplicitParam(name = "id", value = "服务接口套件id", required = true, dataType = "String")
	@GetMapping("getVcode")
	public ResultVo getVcode(@RequestParam String id) {
		return dbServiceKitService.getVcode(id);
	}

	@ApiOperation(value = "解绑MAC地址", notes = "解绑MAC地址")
	@ApiImplicitParam(name = "id", value = "服务接口套件信息id", required = true, dataType = "String")
	@GetMapping("unbindMacAddress")
	ResultVo unbindMacAddress(@RequestParam String id) {
		return dbServiceKitService.unbindMacAddress(id);
	}

	@ApiOperation(value = "服务接口套件启动时上传信息并验证", notes = "服务接口套件启动时上传信息并验证")
	@ApiImplicitParam(name = "dbServcieVo", value = "DbServiceVo对象", required = true, dataType = "DbServiceVo")
	@PostMapping("authDbServiceInfo")
	ResultVo authDbServiceInfo(@RequestBody ServiceKitVo dbServiceKitVo) {
		return dbServiceKitService.authDbServiceInfo(dbServiceKitVo);
	}

}
