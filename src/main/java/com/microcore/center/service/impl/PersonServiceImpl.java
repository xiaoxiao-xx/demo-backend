package com.microcore.center.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.mapper.PsmPersonInfoMapper;
import com.microcore.center.model.PsmPersonInfoExample;
import com.microcore.center.service.PersonService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.util.StringUtil;
import com.microcore.center.vo.PersonInfoVo;
import com.microcore.center.vo.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PsmPersonInfoMapper psmPersonInfoMapper;

    @Autowired
    private HttpServletRequest request;

    @Override
    public ResultVo add(PersonInfoVo personInfoVo) {
        upLoad();
        personInfoVo.setPersonId(CommonUtil.getUUID());
        psmPersonInfoMapper.insertSelective(personInfoVo);
        return ResultVo.ok();
    }

    private void upLoad() {
        MultipartFile file = ((MultipartHttpServletRequest) request).getFile("file");
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
            }
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
    public ResultVo getPersonList(String name, String deptId, Integer pageIndex, Integer pageSize) {
        PsmPersonInfoExample example = new PsmPersonInfoExample();
        PsmPersonInfoExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(name)) {
            criteria.andNameLike("%" + name.trim() + "%");
        }
        if (StringUtils.isNotEmpty(deptId)) {
            criteria.andDeptIdEqualTo(deptId);
        }
        PageInfo<Object> pageInfo = PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> psmPersonInfoMapper.selectByExample(example));
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
        upLoad();
        psmPersonInfoMapper.updateByPrimaryKeySelective(personInfoVo);
        return ResultVo.ok();
    }

}
