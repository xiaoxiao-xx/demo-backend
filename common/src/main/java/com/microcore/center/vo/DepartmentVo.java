package com.microcore.center.vo;

import java.util.List;

import com.microcore.center.model.PsmDeptInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DepartmentVo extends PsmDeptInfo {
	private List<DepartmentVo> children ;
}
