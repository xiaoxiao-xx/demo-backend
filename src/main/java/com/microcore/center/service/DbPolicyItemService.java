package com.microcore.center.service;

import com.github.pagehelper.PageInfo;
import com.microcore.center.dto.DbPolicyItemDto;
import com.microcore.center.model.DbPolicyItem;
import com.microcore.center.vo.DbPolicyItemVo;

import java.util.List;

/**
 *
 */
public interface DbPolicyItemService {

	void addPolicy(DbPolicyItemVo dto);

	List<DbPolicyItemDto> getPolicyItemList();

	void deletePolicy(String id);

	DbPolicyItem getPolicyItemById(String id);

	String getPolicyItemNameById(String id);

}

