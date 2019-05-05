package com.rainyhon.common.vo;

import com.rainyhon.common.model.Permission;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class PermissionVo extends Permission {

	List<String> resourceList;

}
