package com.microcore.center.service;

import com.github.pagehelper.PageInfo;
import com.microcore.center.vo.PsmDealResVo;
import com.microcore.center.vo.ResultVo;

/**
 * 告警处理结果服务
 */
public interface DealResultService {

    PageInfo<PsmDealResVo> getDealResultList(String alarmType, Integer pageIndex, Integer pageSize);

    ResultVo delete(String id);

    ResultVo update(PsmDealResVo vo);

    ResultVo add(PsmDealResVo vo);

}

