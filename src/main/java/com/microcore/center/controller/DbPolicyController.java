package com.microcore.center.controller;

import com.microcore.center.dto.DbExtTemplateDto2;
import com.microcore.center.dto.DbPolicyItemDto;
import com.microcore.center.mapper.DbEncryptionTypeMapper;
import com.microcore.center.mapper.DbExtTemplateMapper;
import com.microcore.center.mapper.DbPolicyEncryptMapper;
import com.microcore.center.mapper.DbPolicyTemplateMapper;
import com.microcore.center.model.*;
import com.microcore.center.service.DbParamsService;
import com.microcore.center.service.DbPolicyItemService;
import com.microcore.center.vo.DbPolicyItemVo;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("dbPolicy")
public class DbPolicyController {

	@Autowired
	private DbPolicyItemService dbPolicyItemService;

	@Autowired
	private DbPolicyEncryptMapper dbPolicyEncryptMapper;

	@Autowired
	private DbPolicyTemplateMapper dbPolicyTemplateMapper;

	@Autowired
	private DbEncryptionTypeMapper dbEncryptionTypeMapper;

	@Autowired
	private DbParamsService dbParamsService;

	@Autowired
	private DbExtTemplateMapper dbExtTemplateMapper;

	@PostMapping("addPolicy")
	public ResultVo<?> addPolicy(@RequestBody DbPolicyItemVo dto) {
		dbPolicyItemService.addPolicy(dto);
		return ResultVo.ok();
	}

	@GetMapping("getPolicyItemListSimple")
	public ResultVo<List<DbPolicyItemDto>> getPolicyItemListSimple() {
		List<DbPolicyItemDto> policyItemList = dbPolicyItemService.getPolicyItemList();
		return ResultVo.ok(policyItemList);
	}

	@GetMapping("getExtTemplateListByPolicyId")
	public ResultVo<List<DbExtTemplateDto2>> getExtTemplateListByPolicyId(@RequestParam(value = "id") String id) {
		DbPolicyTemplateExample example = new DbPolicyTemplateExample();
		DbPolicyTemplateExample.Criteria criteria = example.createCriteria();
		criteria.andPolicyItemIdEqualTo(id);
		List<DbPolicyTemplate> dbPolicyTemplates = dbPolicyTemplateMapper.selectByExample(example);

		List<DbExtTemplateDto2> list = dbPolicyTemplates.stream()
				.map(x -> {
					DbExtTemplate dbExtTemplate = dbExtTemplateMapper.selectByPrimaryKey(x.getExtTemplateId());
					DbExtTemplateDto2 dto = CommonUtil.po2VO(dbExtTemplate, DbExtTemplateDto2.class);
					dto.setSequenceNumber(x.getSequenceNumber());
					dto.setRequired(x.getRequired());
					return dto;
				})
				.filter(x -> "1".equals(x.getVisiable()))
				.collect(Collectors.toList());

		return ResultVo.ok(list);
	}

	@GetMapping("getPolicyItemList")
	public ResultVo<List<DbPolicyItemDto>> getPolicyItemList() {
		List<DbPolicyItemDto> policyItemList = dbPolicyItemService.getPolicyItemList();
		policyItemList.forEach(x -> {
			DbPolicyEncryptExample encryptExample = new DbPolicyEncryptExample();
			DbPolicyEncryptExample.Criteria criteria = encryptExample.createCriteria();
			criteria.andPolicyItemIdEqualTo(x.getId());
			List<DbPolicyEncrypt> dbPolicyEncrypts = dbPolicyEncryptMapper.selectByExample(encryptExample);
			dbPolicyEncrypts.forEach(x1 -> {
				String encryptTypeId = x1.getEncryptTypeId();
				DbEncryptionType dbPolicyEncrypt = dbEncryptionTypeMapper.selectByPrimaryKey(encryptTypeId);
				if (dbPolicyEncrypt != null) {
					x1.setEncryptTypeId(dbPolicyEncrypt.getProtectionWay());
				}

				String value = dbParamsService.getParamsValueByTypeAndKey("sen_grade",
						x1.getSecurityLevel());
				x1.setSecurityLevel(value);
			});
			x.setPolicyEncryptList(dbPolicyEncrypts);

			DbPolicyTemplateExample dbPolicyTemplateExample = new DbPolicyTemplateExample();
			DbPolicyTemplateExample.Criteria criteria1 = dbPolicyTemplateExample.createCriteria();
			criteria1.andPolicyItemIdEqualTo(x.getId());
			List<DbPolicyTemplate> dbPolicyTemplates = dbPolicyTemplateMapper.selectByExample(dbPolicyTemplateExample);
			dbPolicyTemplates.forEach(x2 -> {
				String extTemplateId = x2.getExtTemplateId();
				DbExtTemplate dbExtTemplate = dbExtTemplateMapper.selectByPrimaryKey(extTemplateId);
				x2.setExtTemplateId(dbExtTemplate.getExtPolicyCname());
			});
			x.setPolicyTemplateList(dbPolicyTemplates);
		});
		return ResultVo.ok(policyItemList);
	}

	@GetMapping("getPolicyItemById")
	public ResultVo<DbPolicyItemDto> getPolicyItemById(@RequestParam String id) {
		DbPolicyItem item = dbPolicyItemService.getPolicyItemById(id);
		DbPolicyItemDto x = CommonUtil.po2VO(item, DbPolicyItemDto.class);

		DbPolicyEncryptExample encryptExample = new DbPolicyEncryptExample();
		DbPolicyEncryptExample.Criteria criteria = encryptExample.createCriteria();
		criteria.andPolicyItemIdEqualTo(x.getId());
		List<DbPolicyEncrypt> dbPolicyEncrypts = dbPolicyEncryptMapper.selectByExample(encryptExample);
		dbPolicyEncrypts.forEach(x1 -> {
			String encryptTypeId = x1.getEncryptTypeId();
			DbEncryptionType dbPolicyEncrypt = dbEncryptionTypeMapper.selectByPrimaryKey(encryptTypeId);
			x1.setEncryptTypeId(dbPolicyEncrypt.getProtectionWay());

			String value = dbParamsService.getParamsValueByTypeAndKey("sen_grade", x1.getSecurityLevel());
			x1.setSecurityLevel(value);
		});
		x.setPolicyEncryptList(dbPolicyEncrypts);

		DbPolicyTemplateExample dbPolicyTemplateExample = new DbPolicyTemplateExample();
		DbPolicyTemplateExample.Criteria criteria1 = dbPolicyTemplateExample.createCriteria();
		criteria1.andPolicyItemIdEqualTo(x.getId());
		List<DbPolicyTemplate> dbPolicyTemplates = dbPolicyTemplateMapper.selectByExample(dbPolicyTemplateExample);
		dbPolicyTemplates.forEach(x2 -> {
			String extTemplateId = x2.getExtTemplateId();
			DbExtTemplate dbExtTemplate = dbExtTemplateMapper.selectByPrimaryKey(extTemplateId);
			x2.setExtTemplateId(dbExtTemplate.getExtPolicyCname());
		});
		x.setPolicyTemplateList(dbPolicyTemplates);

		return ResultVo.ok(x);
	}

	@GetMapping("deletePolicyItem")
	public ResultVo<?> deletePolicyItem(@RequestParam String id) {
		dbPolicyItemService.deletePolicy(id);
		return ResultVo.ok();
	}

}

