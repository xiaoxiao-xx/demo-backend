package com.rainyhon.api;

import com.rainyhon.common.vo.ResultVo;
import com.rainyhon.common.vo.UserInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "backend")
public interface SysApi {

	@GetMapping("sysUser/getApprover")
	String getApprover(@RequestParam(name = "orgId") String orgId);

	@PostMapping("dbLog/addLog")
	ResultVo addLog(@RequestParam("optType") String optType, @RequestParam("busiType") String busiType,
	                @RequestParam("tableName") String tableName, @RequestParam("recordId") String recordId,
	                @RequestParam("record") String record);

	@GetMapping("user/queryUser")
	UserInfo queryUser(@RequestParam(name = "id") String id);

	@GetMapping("user/getUserByUsername")
	UserInfo getUserByUsername(@RequestParam(name = "username") String username);

	@PostMapping("kit/heartbeat")
	ResultVo heartbeat(@RequestBody String key);

	@PostMapping("kit/isRun")
	ResultVo isRun(@RequestBody String orgId);

	@GetMapping("kit/isTagRun")
	ResultVo isTagRun(@RequestParam("orgId") String orgId, @RequestParam("type") String type);

	@GetMapping("kit/getRunMap")
	ResultVo getRunMap();

	@GetMapping("kit/getPolicyOrLabelOrg")
	ResultVo getPolicyOrLabelOrg(@RequestParam(name = "orgId") String orgId,
	                             @RequestParam(name = "type") String type);

}
