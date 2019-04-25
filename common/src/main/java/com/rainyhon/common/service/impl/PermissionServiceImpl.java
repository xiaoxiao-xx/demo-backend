package com.rainyhon.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rainyhon.common.constant.Constants;
import com.microcore.center.mapper.PermissionMapper;
import com.microcore.center.model.Permission;
import com.microcore.center.model.PermissionExample;
import com.rainyhon.common.service.PermissionService;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.EntityUtils;
import com.rainyhon.common.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public void addPermission(Permission permission) {
		permission.setId(CommonUtil.getUUID());
		EntityUtils.setCreateAndUpdateInfo(permission);
		permissionMapper.insert(permission);
	}

	@Override
	public void deletePermissionById(String id) {
		Permission permission = new Permission();
		permission.setId(id);
		permission.setDelStatus(Constants.DELETE_STATUS_NO);
		permissionMapper.updateByPrimaryKeySelective(permission);
	}

	@Override
	public void batchDelete(List<String> idList) {
		if (CommonUtil.isNotEmpty(idList)) {
			idList.forEach(id -> {
				permissionMapper.deleteByPrimaryKey(id);
			});
		}
	}

	@Override
	public void updatePermission(Permission permission) {
		permissionMapper.updateByPrimaryKeySelective(permission);
	}

	@Override
	public Permission getPermissionById(String id) {
		return permissionMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<PermissionVo> getPermissionList(Integer pageIndex, Integer pageSize) {
		PermissionExample example = new PermissionExample();
		PermissionExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(Constants.DELETE_STATUS_NO);

		PageInfo<Permission> pageInfo = PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(()
				-> permissionMapper.selectByExample(example));

		List<PermissionVo> voList = CommonUtil.listPo2VO(pageInfo.getList(), PermissionVo.class);
		PageInfo<PermissionVo> voPageInfo = CommonUtil.po2VO(pageInfo, PageInfo.class);
		voPageInfo.setList(voList);
		return voPageInfo;
	}

}
