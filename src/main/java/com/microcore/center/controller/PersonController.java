package com.microcore.center.controller;

import com.microcore.center.mapper.PsmPersonInfoMapper;
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

    @GetMapping("getPersonlist")
    public ResultVo getPersonlist(@RequestParam String name){
        if (StringUtil.isNotEmpty(name)) {


        }

    }
}
