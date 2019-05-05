package com.rainyhon.common.service;

import com.rainyhon.common.mapper.DeptInfoMapper;
import com.rainyhon.common.model.DeptInfo;
import com.rainyhon.common.model.DeptInfoExample;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.StringUtil;
import com.rainyhon.common.vo.DepartmentVo;
import com.rainyhon.common.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentService {

	@Autowired
	private DeptInfoMapper deptInfoMapper;

	public ResultVo add(DepartmentVo departmentVo) {
		departmentVo.setDeptId(CommonUtil.getUUID());
		deptInfoMapper.insertSelective(departmentVo);
		return ResultVo.ok();
	}

	public ResultVo update(DepartmentVo departmentVo) {
		deptInfoMapper.updateByPrimaryKeySelective(departmentVo);
		return ResultVo.ok();
	}

	public ResultVo delete(String id) {
		String[] ids = id.split(",");
		for (String i : ids) {
			deptInfoMapper.deleteByPrimaryKey(i);
		}

		return ResultVo.ok();
	}

	public ResultVo getDeptList(String name) {
		DeptInfoExample example = new DeptInfoExample();
		DeptInfoExample.Criteria criteria = example.createCriteria();
		if (StringUtil.isNotEmpty(name)) {
			criteria.andDeptNameLike("%" + name.trim() + "%");
		}
		return ResultVo.ok(deptInfoMapper.selectByExample(example));
	}

	public String getDepartmentName(String id) {
		DeptInfo deptInfo = getDepartment(id);
		if (deptInfo != null) {
			return deptInfo.getDeptName();
		}
		return null;
	}

	public DeptInfo getDepartment(String id) {
		return deptInfoMapper.selectByPrimaryKey(id);
	}

	public List<DepartmentVo> getDeptTree() {
		DeptInfoExample example = new DeptInfoExample();
		DeptInfoExample.Criteria criteria = example.createCriteria();
		criteria.andDeptLevEqualTo(1);
		List<DeptInfo> list = deptInfoMapper.selectByExample(example);
		List<DepartmentVo> listVo = CommonUtil.listPo2VO(list, DepartmentVo.class);
		for (DepartmentVo departmentVo : listVo) {
			departmentVo.setChildren(getChildrenDept(departmentVo.getDeptId()));
		}
		return listVo;
	}

	public List<DepartmentVo> getChildrenDept(String deptId) {
		DeptInfoExample example = new DeptInfoExample();
		DeptInfoExample.Criteria criteria = example.createCriteria();
		criteria.andParentDeptidEqualTo(deptId);
		List<DeptInfo> list = deptInfoMapper.selectByExample(example);
		return CommonUtil.listPo2VO(list, DepartmentVo.class);
	}

}


