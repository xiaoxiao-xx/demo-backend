package com.microcore.center.service;

import com.github.pagehelper.PageInfo;
import com.microcore.center.vo.PsmDealResDetailVo;
import com.microcore.center.vo.ResultVo;

/**
 * 素材处理结果明细服务
 */
public interface DealResultDetailService {

    PageInfo<PsmDealResDetailVo> getDealResultDetailList(String alarmType, Integer pageIndex, Integer pageSize);

    ResultVo delete(String id);

    ResultVo update(PsmDealResDetailVo vo);

    ResultVo add(PsmDealResDetailVo vo);

}

