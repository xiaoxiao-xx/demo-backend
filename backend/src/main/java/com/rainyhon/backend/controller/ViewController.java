package com.rainyhon.backend.controller;

import com.rainyhon.common.vo.ViewAddVo;
import com.rainyhon.common.vo.ViewModifyVo;
import com.rainyhon.common.vo.ViewQueryVo;
import com.rainyhon.common.service.DynamicQueryService;
import com.rainyhon.common.service.ViewService;
import com.rainyhon.common.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ViewController")
@Api("自定义视图")
public class ViewController {

    @Autowired
    private ViewService viewService;

    @Autowired
    private DynamicQueryService dynamicQueryService;

    @GetMapping("getColumnByViewName")
    @ApiOperation("获取指定名称的视图字段")
    public ResultVo getColumnByViewName(String name) {
        return viewService.getColumnByViewName(name);
    }

    @GetMapping("getAllViewName")
    @ApiOperation("获取所有视图名称")
    public ResultVo getAllViewName() {
        return viewService.getAllViewName();
    }

    @GetMapping("getConditions")
    @ApiOperation("获取所有条件")
    public ResultVo getConditions() {
        return viewService.getAllCondtions();
    }

    @PostMapping("query")
    @ApiOperation("动态查询")
    public ResultVo query(@RequestBody ViewQueryVo vo) {
        return viewService.query(vo);
    }

    @GetMapping("details")
    @ApiOperation("详情")
    public ResultVo queryById(String id) {
        return viewService.details(id);
    }

    @GetMapping("page")
    @ApiOperation("分页查询")
    public ResultVo page(String viewDisplayName, Integer pageIndex, Integer pageSize) {
        return dynamicQueryService.page(viewDisplayName, pageIndex, pageSize);
    }

    @PostMapping("add")
    @ApiOperation("新增")
    public ResultVo add(@RequestBody ViewAddVo vo) {
        return viewService.add(vo);
    }

    @PutMapping("modify")
    @ApiOperation("修改")
    public ResultVo modify(@RequestBody ViewModifyVo vo) {
        return viewService.modify(vo);
    }

    @DeleteMapping("delete")
    @ApiOperation("删除")
    public ResultVo delete(@RequestBody String[] ids) {
        return viewService.delete(ids);
    }
}
