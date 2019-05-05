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
	private DeptInfoMapper psmDeptInfoMapper;

	public ResultVo add(DepartmentVo departmentVo) {
		departmentVo.setDeptId(CommonUtil.getUUID());
		psmDeptInfoMapper.insertSelective(departmentVo);
		return ResultVo.ok();
	}

	public ResultVo update(DepartmentVo departmentVo) {
		psmDeptInfoMapper.updateByPrimaryKeySelective(departmentVo);
		return ResultVo.ok();
	}

	public ResultVo delete(String id) {
		String[] ids = id.split(",");
		for (String i : ids) {
			psmDeptInfoMapper.deleteByPrimaryKey(i);
		}

		return ResultVo.ok();
	}

	public ResultVo getDeptList(String name) {
		DeptInfoExample example = new DeptInfoExample();
		DeptInfoExample.Criteria criteria = example.createCriteria();
		if (StringUtil.isNotEmpty(name)) {
			criteria.andDeptNameLike("%" + name.trim() + "%");
		}
		return ResultVo.ok(psmDeptInfoMapper.selectByExample(example));
	}

	public String getDepartmentName(String id) {
		DeptInfo psmDeptInfo = getDepartment(id);
		if (psmDeptInfo != null) {
			return psmDeptInfo.getDeptName();
		}
		return null;
	}

	public DeptInfo getDepartment(String id) {
		return psmDeptInfoMapper.selectByPrimaryKey(id);
	}

	public List<DepartmentVo> getDeptTree() {
		DeptInfoExample example = new DeptInfoExample();
		DeptInfoExample.Criteria criteria = example.createCriteria();
		criteria.andDeptLevEqualTo(1);
		List<DeptInfo> list = psmDeptInfoMapper.selectByExample(example);
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
		List<DeptInfo> list = psmDeptInfoMapper.selectByExample(example);
		return CommonUtil.listPo2VO(list, DepartmentVo.class);
	}

}


