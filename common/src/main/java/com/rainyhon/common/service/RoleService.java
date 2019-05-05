package com.rainyhon.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rainyhon.common.constant.Constants;
import com.rainyhon.common.mapper.RoleMapper;
import com.rainyhon.common.mapper.RolePermissionRelationMapper;
import com.rainyhon.common.mapper.UserRoleRelationMapper;
import com.rainyhon.common.model.*;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.EntityUtils;
import com.rainyhon.common.vo.PermissionVo;
import com.rainyhon.common.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.rainyhon.common.constant.Constants.DATA_SCOPE_ALL_ORGS;
import static com.rainyhon.common.constant.Constants.DATA_SCOPE_CURRENT_ORG;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private RolePermissionRelationMapper rolePermissionRelationMapper;

	public void addRole(RoleVo vo) {
		String roleId = CommonUtil.getUUID();
		vo.setId(roleId);
		EntityUtils.setCreateAndUpdateInfo(vo);

		List<String> permissionList = vo.getPermissionList();
		String dataScope = vo.getDataScope();
		if (DATA_SCOPE_ALL_ORGS.equals(dataScope)) {
			permissionList.add("0");
		} else if (DATA_SCOPE_CURRENT_ORG.equals(dataScope)) {
			permissionList.add("1");
		}

		if (CommonUtil.isNotEmpty(permissionList)) {
			permissionList.forEach(permissionId -> {
				RolePermissionRelation relation = new RolePermissionRelation();
				relation.setId(CommonUtil.getUUID());
				relation.setRoleId(roleId);
				relation.setPermissionId(permissionId);
				rolePermissionRelationMapper.insert(relation);
			});
		}

		roleMapper.insert(vo);
	}

	public void deleteRoleById(String id) {
		Role role = new Role();
		role.setId(id);
		role.setDelStatus(Constants.DELETE_STATUS_NO);
		roleMapper.updateByPrimaryKeySelective(role);
	}

	public void batchDelete(List<String> idList) {
		if (CommonUtil.isNotEmpty(idList)) {
			idList.forEach(id -> {
				roleMapper.deleteByPrimaryKey(id);
			});
		}
	}

	public void updateRole(Role role) {
		roleMapper.updateByPrimaryKeySelective(role);
	}

	public Role getRoleById(String id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	@Autowired
	private PermissionService permissionService;

	public RoleVo getRoleDetailById(String id) {
		Role role = getRoleById(id);
		RoleVo roleVo = CommonUtil.po2VO(role, RoleVo.class);

		List<PermissionVo> permissionVoList = permissionService.getPermissionsByRoleId(id);
		roleVo.setPermissionVoList(permissionVoList);
		return roleVo;
	}

	public PageInfo<RoleVo> getRoleList(Integer pageIndex, Integer pageSize) {
		RoleExample example = new RoleExample();
		RoleExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(Constants.DELETE_STATUS_NO);

		PageInfo<Role> pageInfo = PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(()
				-> roleMapper.selectByExample(example));

		List<RoleVo> voList = CommonUtil.listPo2VO(pageInfo.getList(), RoleVo.class);
		PageInfo<RoleVo> voPageInfo = CommonUtil.po2VO(pageInfo, PageInfo.class);
		voPageInfo.setList(voList);
		return voPageInfo;
	}

	public List<RoleVo> getAllRoles() {
		RoleExample example = new RoleExample();
		RoleExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(Constants.DELETE_STATUS_NO);
		List<Role> list = roleMapper.selectByExample(example);
		List<RoleVo> voList = CommonUtil.listPo2VO(list, RoleVo.class);
		return voList;
	}

	@Autowired
	private UserRoleRelationMapper userRoleRelationMapper;

	public List<Role> getRoleListByUserId(String userId) {
		UserRoleRelationExample example = new UserRoleRelationExample();
		UserRoleRelationExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<UserRoleRelation> relationList = userRoleRelationMapper.selectByExample(example);
		if (relationList == null) {
			relationList = new ArrayList<>();
		}

		List<Role> roleList = new ArrayList<>();
		relationList.forEach(relation -> {
			Role role = roleMapper.selectByPrimaryKey(relation.getRoleId());
			roleList.add(role);
		});

		return roleList;
	}

}
