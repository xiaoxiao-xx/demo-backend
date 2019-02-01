package com.microcore.center.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microcore.center.dto.DbPubTableDto;
import com.microcore.center.service.DbPubFileService;
import com.microcore.center.service.DbPubResourceService;
import com.microcore.center.service.DbPubServiceService;
import com.microcore.center.service.DbPubTableService;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.StringUtil;

@RestController
@RequestMapping("dbPub")
public class DbPubController {

	@Autowired
	private DbPubFileService dbPubFileService;
	@Autowired
	private DbPubTableService dbPubTableService;
	@Autowired
	private DbPubServiceService dbPubServiceService;
	@Autowired
	private DbPubResourceService dbPubResourceService;

	@GetMapping("getPubListByOrg")
	public ResultVo getPubListByOrg(String orgId) {
		if (StringUtil.isEmpty(orgId)) {
			return ResultVo.fail("机构不能为空");
		}
		ResultVo fileVo = dbPubFileService.getDbPubFilelistT(orgId, "",
				null, null, null, null);
		ResultVo<List<DbPubTableDto>> dbVo = dbPubTableService.getPubList("YES",
				null, null, orgId);
		ResultVo serviceVo = dbPubServiceService.getPubServiceList("YES", orgId,
				null, null, null);
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("fileList", fileVo.getData());
		resMap.put("dbList", dbVo.getData());
		resMap.put("serviceList", serviceVo.getData());

		return ResultVo.ok(resMap);
	}

	@GetMapping("getPubResourceByOrg")
	public ResultVo getPubResourceByOrg(@RequestParam(name = "orgId", required = false) String orgId,
	                                    @RequestParam(name = "keywords", required = false) String keywords,
	                                    @RequestParam(name = "pageIndex") Integer pageIndex,
	                                    @RequestParam(name = "pageSize") Integer pageSize) {
		return ResultVo.ok(dbPubResourceService.getPubResourceByOrg(orgId, keywords, pageIndex, pageSize));
	}

	@GetMapping("getPubResourceByTrade")
	public ResultVo getPubResourceByTrade(@RequestParam(name = "paramsKey", required = false) String paramsKey,
	                                      @RequestParam(name = "keywords", required = false) String keywords,
	                                      @RequestParam(name = "pageIndex") Integer pageIndex,
	                                      @RequestParam(name = "pageSize") Integer pageSize) {
		return ResultVo.ok(dbPubResourceService.getPubResourceByTrade(paramsKey, keywords, pageIndex, pageSize));
	}
	
	@GetMapping("getTradeList")
	public ResultVo getTradeList() {
		return ResultVo.ok(dbPubResourceService.getTradeList());
	}

}
