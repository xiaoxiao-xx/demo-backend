package com.microcore.center.controller;

import com.microcore.center.service.PsmUserService;
import com.microcore.center.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private PsmUserService psmUserService;

    @GetMapping("getUserListByTeamId")
    public ResultVo getUserListByTeamId(@RequestParam String id) {
        return ResultVo.ok(psmUserService.getUserListByOrgId(id));
    }

}
