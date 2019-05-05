package com.rainyhon.common.vo;

import com.rainyhon.common.model.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class RoleVo extends Role {

	List<String> permissionList;

	List<PermissionVo> permissionVoList;

	/**
	 * 数据范围 (ALL_ORGS, CURRENT_ORG)
	 */
	String dataScope;

}
