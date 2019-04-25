package com.rainyhon.backend.controller;

import com.rainyhon.common.service.DepartmentService;
import com.rainyhon.common.vo.DepartmentVo;
import com.rainyhon.common.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("departmentController")
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("add")
    public ResultVo add(@RequestBody DepartmentVo departmentVo) {
        return departmentService.add(departmentVo);
    }

    @PostMapping("update")
    public ResultVo update(@RequestBody DepartmentVo departmentVo) {
        return departmentService.update(departmentVo);
    }

    @PostMapping("delete")
    public ResultVo delete(@RequestBody String id) {
        return departmentService.delete(id);
    }

    @GetMapping("getDeptList")
    public ResultVo getDeptList(@RequestParam String name){
        return departmentService.getDeptList(name);
    }
    
    @GetMapping("getDeptTree")
    public ResultVo getDeptTree(){
        return ResultVo.ok(departmentService.getDeptTree());
    }
    
}
