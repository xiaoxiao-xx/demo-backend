package com.microcore.center.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.mapper.PsmPersonInfoMapper;
import com.microcore.center.model.PsmPersonInfo;
import com.microcore.center.model.PsmPersonInfoExample;
import com.microcore.center.service.DepartmentService;
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
    private HttpServletRequest request;

    @Autowired
    private DepartmentService departmentService ;
    
    @Override
    public ResultVo add(PersonInfoVo personInfoVo) {
        upLoad();
        personInfoVo.setPersonId(CommonUtil.getUUID());
        psmPersonInfoMapper.insertSelective(personInfoVo);
        return ResultVo.ok();
    }

    private void upLoad() {
        /*MultipartFile file = ((MultipartHttpServletRequest) request).getFile("file");
        if (file.isEmpty()) {
            return;
        }
        String path = System.getProperty("user.dir");
        String filePath = path + "/photo/";
            String fileName = file.getOriginalFilename();
            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }*/
    }

    @Override
    public ResultVo update(PersonInfoVo personInfoVo) {
        psmPersonInfoMapper.updateByPrimaryKeySelective(personInfoVo);
        return ResultVo.ok();
    }

    @Override
    public ResultVo delete(String id) {
        psmPersonInfoMapper.deleteByPrimaryKey(id);
        return ResultVo.ok();
    }

    @Override
    public ResultVo getPersonList(String name,Integer pageIndex, Integer pageSize) {
        PsmPersonInfoExample example = new PsmPersonInfoExample();
        PsmPersonInfoExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(name)) {
            criteria.andNameLike("%" + name.trim() + "%");
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
        return ResultVo.ok(new PageInfo(listPersonInfoVo));
    }

    @Override
    public ResultVo importantCare(PersonInfoVo personInfoVo) {
        personInfoVo.setCareStatus("YES");
        psmPersonInfoMapper.updateByPrimaryKeySelective(personInfoVo);
        return ResultVo.ok();
    }

    @Override
    public ResultVo imageAcquisition(PersonInfoVo personInfoVo) {
        upLoad();
        psmPersonInfoMapper.updateByPrimaryKeySelective(personInfoVo);
        return ResultVo.ok();
    }

}
