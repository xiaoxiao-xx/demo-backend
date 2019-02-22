package com.microcore.center.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.constant.Constants;
import com.microcore.center.mapper.PsmPersonInfoMapper;
import com.microcore.center.model.PsmPersonInfo;
import com.microcore.center.model.PsmPersonInfoExample;
import com.microcore.center.service.DepartmentService;
import com.microcore.center.service.OperHisService;
import com.microcore.center.service.PersonService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.util.StringUtil;
import com.microcore.center.vo.PersonInfoVo;
import com.microcore.center.vo.ResultVo;



@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PsmPersonInfoMapper psmPersonInfoMapper;

    @Autowired
    private DepartmentService departmentService ;
    @Autowired
    private OperHisService operHisService ;
    
    @Override
    public ResultVo add(PersonInfoVo personInfoVo) {
        personInfoVo.setPersonId(CommonUtil.getUUID());
        psmPersonInfoMapper.insertSelective(personInfoVo);
        operHisService.add(personInfoVo.getPersonId(), Constants.OPER_HIS_ADD);
        return ResultVo.ok();
    }


    @Override
    public ResultVo update(PersonInfoVo personInfoVo) {
        psmPersonInfoMapper.updateByPrimaryKeySelective(personInfoVo);
        operHisService.add(personInfoVo.getPersonId(), Constants.OPER_HIS_UPD);
        return ResultVo.ok();
    }

    @Override
    public ResultVo delete(String id) {
        String[] ids = id.split(",");
		for (String i : ids) {
			psmPersonInfoMapper.deleteByPrimaryKey(i);
			operHisService.add(i, Constants.OPER_HIS_DEL);
		}
        return ResultVo.ok();
    }

    @Override
    public ResultVo getPersonList(String name, String deptId, Integer pageIndex, Integer pageSize) {
        PsmPersonInfoExample example = new PsmPersonInfoExample();
        PsmPersonInfoExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(name)) {
            criteria.andNameLike("%" + name.trim() + "%");
        }
        if (StringUtils.isNotEmpty(deptId)) {
            criteria.andDeptIdEqualTo(deptId);
        }
        List<PersonInfoVo> listPersonInfoVo = new ArrayList<>();
        PageInfo<PsmPersonInfo> psmPersonInfoPage = PageHelper.startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> psmPersonInfoMapper.selectByExample(example));
        for (PsmPersonInfo psmPersonInfo : psmPersonInfoPage.getList()) {
        	String deptName = departmentService.getDepartmentName(psmPersonInfo.getDeptId());
        	PersonInfoVo personInfoVo = CommonUtil.po2VO(psmPersonInfo, PersonInfoVo.class);
        	personInfoVo.setDeptName(deptName);
        	listPersonInfoVo.add(personInfoVo);
		}
        PageInfo<PersonInfoVo> pageInfo =  new PageInfo(listPersonInfoVo) ;
        pageInfo.setTotal(psmPersonInfoPage.getTotal());
        return ResultVo.ok(pageInfo);
    }

    @Override
    public ResultVo importantCare(PersonInfoVo personInfoVo) {
        personInfoVo.setCareStatus("YES");
        psmPersonInfoMapper.updateByPrimaryKeySelective(personInfoVo);
        return ResultVo.ok();
    }

    @Override
    public ResultVo imageAcquisition(PersonInfoVo personInfoVo) {
        psmPersonInfoMapper.updateByPrimaryKeySelective(personInfoVo);
        return ResultVo.ok();
    }


	@Override
	public ResultVo list() {
		PsmPersonInfoExample example = new PsmPersonInfoExample();
        PsmPersonInfoExample.Criteria criteria = example.createCriteria();
		return ResultVo.ok(psmPersonInfoMapper.selectByExample(example));
	}


}
