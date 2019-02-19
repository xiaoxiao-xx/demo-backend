package com.microcore.center.service;

import com.microcore.center.vo.DepartmentVo;
import com.microcore.center.vo.ResultVo;

public interface DepartmentService {
    ResultVo add(DepartmentVo departmentVo);

    ResultVo update(DepartmentVo departmentVo);

    ResultVo delete(String id);

    ResultVo getDeptList(String name);
}
