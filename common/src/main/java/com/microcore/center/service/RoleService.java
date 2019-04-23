package com.microcore.center.service;

import com.github.pagehelper.PageInfo;
import com.microcore.center.model.Role;
import com.microcore.center.vo.RoleVo;

import java.util.List;

public interface RoleService {

	void addRole(Role Role);

	void deleteRoleById(String id);

	void batchDelete(List<String> idList);

	void updateRole(Role role);

	Role getRoleById(String id);

	PageInfo<RoleVo> getRoleList(Integer pageIndex, Integer pageSize);

}
