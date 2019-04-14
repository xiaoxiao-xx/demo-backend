package com.microcore.center.service;

import java.util.List;

import com.microcore.center.model.PsmDeptInfo;
import com.microcore.center.vo.DepartmentVo;
import com.microcore.center.vo.ResultVo;

public interface DepartmentService {

    ResultVo add(DepartmentVo departmentVo);

    ResultVo update(DepartmentVo departmentVo);

    ResultVo delete(String id);

    ResultVo getDeptList(String name);

    String getDepartmentName(String id);

    PsmDeptInfo getDepartment(String id);

    List<DepartmentVo> getDeptTree();

}
