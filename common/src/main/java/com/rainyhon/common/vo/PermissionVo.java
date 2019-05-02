package com.rainyhon.common.vo;

import com.microcore.center.model.Permission;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class PermissionVo extends Permission {

	List<String> resourceList;

}
