package com.microcore.center.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.constant.Constants;
import com.microcore.center.mapper.RoleMapper;
import com.microcore.center.model.Role;
import com.microcore.center.model.RoleExample;
import com.microcore.center.service.RoleService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.util.EntityUtils;
import com.microcore.center.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public void addRole(Role role) {
		role.setId(CommonUtil.getUUID());
		EntityUtils.setCreateAndUpdateInfo(role);
		roleMapper.insert(role);
	}

	@Override
	public void deleteRoleById(String id) {
		Role role = new Role();
		role.setId(id);
		role.setDelStatus(Constants.DELETE_STATUS_NO);
		roleMapper.updateByPrimaryKeySelective(role);
	}

	@Override
	public void batchDelete(List<String> idList) {
		if (CommonUtil.isNotEmpty(idList)) {
			idList.forEach(id -> {
				roleMapper.deleteByPrimaryKey(id);
			});
		}
	}

	@Override
	public void updateRole(Role role) {
		roleMapper.updateByPrimaryKeySelective(role);
	}

	@Override
	public Role getRoleById(String id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
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

}
