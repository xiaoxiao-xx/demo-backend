package com.rainyhon.backend.controller;

import com.rainyhon.common.service.OperHisService;
import com.rainyhon.common.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("operHis")
public class OperHisController {

    @Autowired
    private OperHisService operHisService;

    @GetMapping("query")
    public ResultVo query(@RequestParam String operTarget) {
        return ResultVo.ok(operHisService.getPsmOperHis(operTarget));
    }
}
