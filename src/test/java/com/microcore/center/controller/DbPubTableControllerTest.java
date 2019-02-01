package com.microcore.center.controller;

import com.microcore.center.SlsCenterApplication;
import com.microcore.center.client.PolicyTemplate;
import com.microcore.center.dto.DbPubTableDto;
import com.microcore.center.model.DbModel;
import com.microcore.center.model.DbModelDetail;
import com.microcore.center.model.DbPubTable;
import com.microcore.center.service.DbModelService;
import com.microcore.center.service.DbOrgService;
import com.microcore.center.service.DbPubTableService;
import com.microcore.common.dto.DbModelDetailDto;
import com.microcore.common.dto.DbModelDto;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SlsCenterApplication.class)
@Slf4j
public class DbPubTableControllerTest {

	@Autowired
	private PolicyTemplate policyTemplate;

	@Autowired
	private DbModelService dbModelService;

	@Autowired
	private DbOrgService dbOrgService;

	@Autowired
	private DbPubTableService dbPubTableService;

	private ResultVo testGenXml() {
		String id = "2541b0b41da84bc2a2a4ce05c6da2574";
		DbPubTable pubTable = dbPubTableService.getPubTableById(id);
		DbPubTableDto tableDto = CommonUtil.po2VO(pubTable, DbPubTableDto.class);

		String modelId = tableDto.getModelId();
		DbModel model = dbModelService.getModelById(modelId);
		DbModelDto modelDto = CommonUtil.po2VO(model, DbModelDto.class);
		modelDto.setPubId(id);
		modelDto.setOrgName(dbOrgService.getOrgNameByOrgId(pubTable.getPubOrgId()));
		List<DbModelDetail> details = dbModelService.getDbModelDetail(modelId);
		List<DbModelDetailDto> detailList = CommonUtil.listPo2VO(details, com.microcore.common.dto.DbModelDetailDto.class);
		modelDto.setModelDetailDtoList(detailList);
		// 生成标签XML字符串
		ResultVo<?> resultVo = policyTemplate.generateLabelXml(modelDto);
		if (resultVo == null || resultVo.getStatus() != 200) {
			return ResultVo.fail("no");
		}

		return ResultVo.ok(resultVo.getData());
	}

	@Test
	public void tesGenXml() {
		ResultVo resultVo = testGenXml();
		log.info("", resultVo.getData());
	}

}