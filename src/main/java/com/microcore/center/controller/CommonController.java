package com.microcore.center.controller;

import com.microcore.center.vo.ResultVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("userController")
public class CommonController {

    @GetMapping("getUserInfo")
    public ResultVo getUserInfo(@RequestParam String name) {
        return ResultVo.ok("asdfasdf");
    }
}
