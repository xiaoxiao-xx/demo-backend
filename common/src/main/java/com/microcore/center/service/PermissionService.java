package com.microcore.center.service;

import com.github.pagehelper.PageInfo;
import com.microcore.center.model.Permission;
import com.microcore.center.vo.PermissionVo;

import java.util.List;

public interface PermissionService {

	void addPermission(Permission permission);

	void deletePermissionById(String id);

	void batchDelete(List<String> idList);

	void updatePermission(Permission permission);

	Permission getPermissionById(String id);

	PageInfo<PermissionVo> getPermissionList(Integer pageIndex, Integer pageSize);

}
