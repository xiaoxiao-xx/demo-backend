package com.rainyhon.common.vo;

import java.util.List;

import com.rainyhon.common.model.DeptInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DepartmentVo extends DeptInfo {
	private List<DepartmentVo> children ;
}
