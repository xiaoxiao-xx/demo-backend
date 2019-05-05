package com.rainyhon.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rainyhon.common.constant.Constants;
import com.rainyhon.common.mapper.PermissionMapper;
import com.rainyhon.common.mapper.PermissionResourceRelationMapper;
import com.rainyhon.common.mapper.RolePermissionRelationMapper;
import com.rainyhon.common.model.*;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.EntityUtils;
import com.rainyhon.common.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;

	@Autowired
	private PermissionResourceRelationMapper permissionResourceRelationMapper;

	public void addPermission(PermissionVo permission) {
		String permissionId = CommonUtil.getUUID();
		permission.setId(permissionId);
		EntityUtils.setCreateAndUpdateInfo(permission);
		List<String> resourceList = permission.getResourceList();
		if (CommonUtil.isNotEmpty(resourceList)) {
			resourceList.forEach(resourceId -> {
				PermissionResourceRelation relation = new PermissionResourceRelation();
				relation.setId(CommonUtil.getUUID());
				relation.setPermissionId(permissionId);
				relation.setResourceId(resourceId);
				permissionResourceRelationMapper.insert(relation);
			});
		}

		permissionMapper.insert(permission);
	}

	public void deletePermissionById(String id) {
		Permission permission = new Permission();
		permission.setId(id);
		permission.setDelStatus(Constants.DELETE_STATUS_NO);
		permissionMapper.updateByPrimaryKeySelective(permission);
	}

	public void batchDelete(List<String> idList) {
		if (CommonUtil.isNotEmpty(idList)) {
			idList.forEach(id -> {
				permissionMapper.deleteByPrimaryKey(id);
			});
		}
	}

	public void updatePermission(Permission permission) {
		permissionMapper.updateByPrimaryKeySelective(permission);
	}

	public Permission getPermissionById(String id) {
		return permissionMapper.selectByPrimaryKey(id);
	}

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

	public List<PermissionVo> getAllPermissions() {
		PermissionExample example = new PermissionExample();
		PermissionExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(Constants.DELETE_STATUS_NO);
		List<Permission> list = permissionMapper.selectByExample(example);
		List<PermissionVo> voList = CommonUtil.listPo2VO(list, PermissionVo.class);
		return voList;
	}

	@Autowired
	private RolePermissionRelationMapper rolePermissionRelationMapper;

	public List<PermissionVo> getPermissionsByRoleId(String id) {
		RolePermissionRelationExample example = new RolePermissionRelationExample();
		RolePermissionRelationExample.Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(id);
		List<RolePermissionRelation> list = rolePermissionRelationMapper.selectByExample(example);
		List<PermissionVo> voList = new ArrayList<>();
		list.forEach(relation -> {
			Permission permission = getPermissionById(relation.getPermissionId());
			PermissionVo permissionVo = CommonUtil.po2VO(permission, PermissionVo.class);
			voList.add(permissionVo);
		});

		return voList;
	}

	public PermissionVo getPermissionDetailById() {

		return null;
	}

}
