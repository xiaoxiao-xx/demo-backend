package com.rainyhon.common.service;

import java.util.List;

import com.microcore.center.model.PsmDeptInfo;
import com.rainyhon.common.vo.DepartmentVo;
import com.rainyhon.common.vo.ResultVo;

public interface DepartmentService {

    ResultVo add(DepartmentVo departmentVo);

    ResultVo update(DepartmentVo departmentVo);

    ResultVo delete(String id);

    ResultVo getDeptList(String name);

    String getDepartmentName(String id);

    PsmDeptInfo getDepartment(String id);

    List<DepartmentVo> getDeptTree();

}
