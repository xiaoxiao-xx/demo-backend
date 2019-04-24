package com.rainyhon.backend.controller;

import com.github.pagehelper.PageInfo;
import com.microcore.center.service.DealResultDetailService;
import com.microcore.center.service.DealResultService;
import com.microcore.center.vo.PsmDealResVo;
import com.microcore.center.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 素材处理结果
 */
@RestController
@RequestMapping("alarmDealResultController")
public class AlarmDealResultController {

    @Autowired
    private DealResultService dealResultService;

    @Autowired
    private DealResultDetailService dealResultDetailService;

    @ApiOperation(value = "查询素材处理信息", notes = "查询素材处理信息")
    @GetMapping("query")
    public ResultVo<PageInfo<PsmDealResVo>> query(@RequestParam(name = "alarmType", required = false) String alarmType,
    											  @RequestParam(name = "dealState", required = false) String dealState,
                                                  @RequestParam(name = "pageIndex") Integer pageIndex,
                                                  @RequestParam(name = "pageSize") Integer pageSize) {
        return ResultVo.ok(dealResultService.getDealResultList(alarmType,dealState, pageIndex, pageSize));
    }

    @ApiOperation(value = "素材处理结果新增", notes = "素材处理结果新增")
    @PostMapping("add")
    public ResultVo add(@RequestBody PsmDealResVo vo) {
        return dealResultService.add(vo);
    }

    @ApiOperation(value = "素材处理结果修改", notes = "素材处理结果修改")
    @PostMapping("update")
    public ResultVo update(@RequestBody PsmDealResVo vo) {
        return dealResultService.update(vo);
    }

    @ApiOperation(value = "素材处理结果删除", notes = "素材处理结果删除")
    @PostMapping("delete")
    public ResultVo delete(@RequestBody String id) {
        return dealResultService.delete(id);
    }

    @ApiOperation(value = "素材处理结果处理", notes = "素材处理结果处理")
    @PostMapping("deal")
    public ResultVo deal(@RequestBody PsmDealResVo dealResVo) {
        return dealResultService.deal(dealResVo);
    }

}
