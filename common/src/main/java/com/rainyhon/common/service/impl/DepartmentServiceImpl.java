package com.rainyhon.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microcore.center.mapper.PsmDeptInfoMapper;
import com.microcore.center.model.PsmDeptInfo;
import com.microcore.center.model.PsmDeptInfoExample;
import com.rainyhon.common.service.DepartmentService;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.StringUtil;
import com.rainyhon.common.vo.DepartmentVo;
import com.rainyhon.common.vo.ResultVo;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private PsmDeptInfoMapper psmDeptInfoMapper;

	@Override
	public ResultVo add(DepartmentVo departmentVo) {
		departmentVo.setDeptId(CommonUtil.getUUID());
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
		String[] ids = id.split(",");
		for (String i : ids) {
			psmDeptInfoMapper.deleteByPrimaryKey(i);
		}

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

	@Override
	public String getDepartmentName(String id) {
		PsmDeptInfo psmDeptInfo = getDepartment(id);
		if (psmDeptInfo != null) {
			return psmDeptInfo.getDeptName();
		}
		return null;
	}

	@Override
	public PsmDeptInfo getDepartment(String id) {
		return psmDeptInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<DepartmentVo> getDeptTree() {
		PsmDeptInfoExample example = new PsmDeptInfoExample();
		PsmDeptInfoExample.Criteria criteria = example.createCriteria();
		criteria.andDeptLevEqualTo(1);
		List<PsmDeptInfo> list = psmDeptInfoMapper.selectByExample(example);
		List<DepartmentVo> listVo = CommonUtil.listPo2VO(list, DepartmentVo.class);
		for (DepartmentVo departmentVo : listVo) {
			departmentVo.setChildren(getChildrenDept(departmentVo.getDeptId()));
		}
		return listVo;
	}

	public List<DepartmentVo> getChildrenDept(String deptId) {
		PsmDeptInfoExample example = new PsmDeptInfoExample();
		PsmDeptInfoExample.Criteria criteria = example.createCriteria();
		criteria.andParentDeptidEqualTo(deptId);
		List<PsmDeptInfo> list = psmDeptInfoMapper.selectByExample(example);
		return CommonUtil.listPo2VO(list, DepartmentVo.class);
	}

}
