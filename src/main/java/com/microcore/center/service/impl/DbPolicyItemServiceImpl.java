package com.microcore.center.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.dto.DbPolicyItemDto;
import com.microcore.center.mapper.DbPolicyEncryptMapper;
import com.microcore.center.mapper.DbPolicyItemMapper;
import com.microcore.center.mapper.DbPolicyTemplateMapper;
import com.microcore.center.model.*;
import com.microcore.center.service.DbPolicyItemService;
import com.microcore.center.vo.DbPolicyItemVo;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.EntityUtils;
import com.microcore.common.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 *
 */
@Service
@Transactional
public class DbPolicyItemServiceImpl implements DbPolicyItemService {

	@Autowired
	private DbPolicyItemMapper dbPolicyItemMapper;

	@Autowired
	private DbPolicyEncryptMapper dbPolicyEncryptMapper;

	@Autowired
	private DbPolicyTemplateMapper dbPolicyTemplateMapper;

	@Override
	public void addPolicy(DbPolicyItemVo dto) {
		DbPolicyItem item = CommonUtil.po2VO(dto, DbPolicyItem.class);
		String itemId = CommonUtil.getUUID();
		item.setId(itemId);
		EntityUtils.setCreateAndUpdateInfo(item);
		dbPolicyItemMapper.insert(item);

		List<DbPolicyEncrypt> policyEncryptList = dto.getPolicyEncryptList();
		policyEncryptList.forEach(x -> {
			x.setId(CommonUtil.getUUID());
			x.setPolicyItemId(itemId);
			dbPolicyEncryptMapper.insert(x);
		});

		List<DbPolicyTemplate> policyTemplateList = dto.getPolicyTemplateList();
		policyTemplateList.forEach(x -> {
			x.setPolicyItemId(itemId);
			dbPolicyTemplateMapper.insert(x);
		});
	}

	@Override
	public List<DbPolicyItemDto> getPolicyItemList() {
		DbPolicyItemExample example = new DbPolicyItemExample();
		DbPolicyItemExample.Criteria criteria = example.createCriteria();
		criteria.andCrtOrgIdEqualTo(CommonUtil.getOrgId());
		List<DbPolicyItem> dbPolicyItems = dbPolicyItemMapper.selectByExample(example);
		return CommonUtil.listPo2VO(dbPolicyItems, DbPolicyItemDto.class);
	}

	@Override
	public void deletePolicy(String id) {
		dbPolicyItemMapper.deleteByPrimaryKey(id);

		DbPolicyTemplateExample example = new DbPolicyTemplateExample();
		DbPolicyTemplateExample.Criteria criteria = example.createCriteria();
		criteria.andPolicyItemIdEqualTo(id);
		dbPolicyTemplateMapper.deleteByExample(example);

		DbPolicyEncryptExample encryptExample = new DbPolicyEncryptExample();
		DbPolicyEncryptExample.Criteria criteria1 = encryptExample.createCriteria();
		criteria1.andPolicyItemIdEqualTo(id);
		dbPolicyEncryptMapper.deleteByExample(encryptExample);
	}

	@Override
	public DbPolicyItem getPolicyItemById(String id) {
		return dbPolicyItemMapper.selectByPrimaryKey(id);
	}

	@Override
	public String getPolicyItemNameById(String id) {
		DbPolicyItem policyItem = Optional.ofNullable(getPolicyItemById(id)).orElse(new DbPolicyItem());
		return Optional.ofNullable(policyItem.getName()).orElse("");
	}

}
