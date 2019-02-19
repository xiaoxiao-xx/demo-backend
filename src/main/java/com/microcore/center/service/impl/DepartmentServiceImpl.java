package com.microcore.center.service.impl;

import com.microcore.center.mapper.PsmDeptInfoMapper;
import com.microcore.center.model.PsmDeptInfoExample;
import com.microcore.center.service.DepartmentService;
import com.microcore.center.util.StringUtil;
import com.microcore.center.vo.DepartmentVo;
import com.microcore.center.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private PsmDeptInfoMapper psmDeptInfoMapper;

    @Override
    public ResultVo add(DepartmentVo departmentVo) {
        psmDeptInfoMapper.insertSelective(departmentVo);
        return ResultVo.ok();
    }

    @Override
    public ResultVo update(DepartmentVo departmentVo) {
        psmDeptInfoMapper.updateByPrimaryKeySelective(departmentVo);
        return ResultVo.ok();
    }

    @Override
    public ResultVo delete(String id) {
        psmDeptInfoMapper.deleteByPrimaryKey(id);
        return ResultVo.ok();
    }

    @Override
    public ResultVo getDeptList(String name) {
        PsmDeptInfoExample example = new PsmDeptInfoExample();
        PsmDeptInfoExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(name)) {
            criteria.andDeptNameLike("%" + name.trim() + "%");
        }
        return ResultVo.ok(psmDeptInfoMapper.selectByExample(example));
    }
}
