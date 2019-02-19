package com.microcore.center.controller;

import com.microcore.center.mapper.PsmPersonInfoMapper;
import com.microcore.center.model.PsmPersonInfoExample;
import com.microcore.center.util.StringUtil;
import com.microcore.center.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("personController")
public class PersonController {

    @Autowired
    private PsmPersonInfoMapper psmPersonInfoMapper;

    @GetMapping("getPersonList")
    public ResultVo getPersonList(@RequestParam String name){
        PsmPersonInfoExample example = new PsmPersonInfoExample();
        PsmPersonInfoExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(name)) {
            criteria.andNameLike("%" + name.trim() + "%");
        }
        return ResultVo.ok(psmPersonInfoMapper.selectByExample(example));
    }
}
