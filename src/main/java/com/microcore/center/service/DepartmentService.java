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
    
    
    public String getDepartmentName(String id);
    public PsmDeptInfo getDepartment(String id);
    public List<DepartmentVo> getDeptTree();
}
