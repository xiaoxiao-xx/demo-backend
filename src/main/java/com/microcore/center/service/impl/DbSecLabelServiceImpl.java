package com.microcore.center.service.impl;

import com.github.pagehelper.PageInfo;
import com.microcore.center.client.PolicyTemplate;
import com.microcore.center.service.DbOrgService;
import com.microcore.center.service.DbSecLabelService;
import com.microcore.common.dto.DbSecLabelDto;
import com.microcore.common.dto.SecLabelColumn;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.ResultVo;
import com.microcore.common.vo.SecLabelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author
 */
@Service
@Transactional
public class DbSecLabelServiceImpl implements DbSecLabelService {

	private final PolicyTemplate policyTemplate;

	private final DbOrgService dbOrgService;

	private final UserService userService;

	@Autowired
	public DbSecLabelServiceImpl(PolicyTemplate policyTemplate, DbOrgService dbOrgService, UserService userService) {
		this.policyTemplate = policyTemplate;
		this.dbOrgService = dbOrgService;
		this.userService = userService;
	}

	@Override
	public ResultVo<?> getSecLabelList(String orgId, Integer pageIndex, Integer pageSize) {
		ResultVo<?> vo = policyTemplate.getSecLabelList(new SecLabelVo(orgId, pageIndex, pageSize));
		Map<String, Object> data = (Map<String, Object>) vo.getData();
		PageInfo<?> dtos = CommonUtil.map2POx(data, PageInfo.class);
		List<Map<String, Object>> list = (List<Map<String, Object>>) dtos.getList();
		List<DbSecLabelDto> dtoList = CommonUtil.map2PO(list, DbSecLabelDto.class, false);
		if (dtoList != null) {
			dtoList.forEach(dto -> {
				dto.setPubOrgName(dbOrgService.getOrgNameByOrgId(dto.getPubOrgName()));
				dto.setPubUserName(userService.getUserNameById(dto.getPubUserName()));
			});
		}

		((PageInfo<DbSecLabelDto>) dtos).setList(dtoList);

		return ResultVo.ok(dtos);
	}

	@Override
	public ResultVo getSecLabelDetailedInfo(String labelId) {
		ResultVo<?> vo = policyTemplate.getSecLabelDetailedInfo(labelId);
		List<Map<String, Object>> data = (List<Map<String, Object>>) vo.getData();
		List<SecLabelColumn> labelColumnList = CommonUtil.map2PO(data, SecLabelColumn.class, false);
		if (labelColumnList != null) {
			labelColumnList.forEach(secLabelColumn -> {
				String authScopes = secLabelColumn.getAuthScopes();
				String chineseAuthScopes = Arrays.stream(authScopes.split(","))
						.map(dbOrgService::getOrgNameByOrgId)
						.collect(Collectors.joining(","));
				secLabelColumn.setAuthScopes(chineseAuthScopes);
			});
		}

		return ResultVo.ok(labelColumnList);
	}

}
