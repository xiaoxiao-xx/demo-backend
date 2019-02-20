package com.microcore.center.controller;

import com.github.pagehelper.PageInfo;
import com.microcore.center.service.DealResultDetailService;
import com.microcore.center.service.DealResultService;
import com.microcore.center.vo.PsmDealResVo;
import com.microcore.center.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 告警处理结果
 */
@RestController
@RequestMapping("alarmDealResultController")
public class AlarmDealResultController {

    @Autowired
    private DealResultService dealResultService;

    @Autowired
    private DealResultDetailService dealResultDetailService;

    @ApiOperation(value = "查询告警处理信息", notes = "查询告警处理信息")
    @GetMapping("getDealResultList")
    public ResultVo<PageInfo<PsmDealResVo>> query(@RequestParam(name = "alarmType", required = false) String alarmType,
                                                  @RequestParam(name = "pageIndex") Integer pageIndex,
                                                  @RequestParam(name = "pageSize") Integer pageSize) {
        return ResultVo.ok(dealResultService.getDealResultList(alarmType, pageIndex, pageSize));
    }

    @ApiOperation(value = "告警处理结果新增", notes = "告警处理结果新增")
    @PostMapping("addDealResult")
    public ResultVo addDealResult(@RequestBody PsmDealResVo vo) {
        return dealResultService.add(vo);
    }

    @ApiOperation(value = "告警处理结果修改", notes = "告警处理结果修改")
    @PostMapping("updateDealResult")
    public ResultVo update(@RequestBody PsmDealResVo vo) {
        return dealResultService.update(vo);
    }

    @ApiOperation(value = "告警处理结果删除", notes = "告警处理结果删除")
    @PostMapping("deleteDealResult")
    public ResultVo delete(@RequestBody String id) {
        return dealResultService.delete(id);
    }

}
