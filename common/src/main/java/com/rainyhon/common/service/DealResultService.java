package com.rainyhon.common.service;

import com.github.pagehelper.PageInfo;
import com.rainyhon.common.vo.PsmDealResVo;
import com.rainyhon.common.vo.ResultVo;

/**
 * 素材处理结果服务
 */
public interface DealResultService {

    PageInfo<PsmDealResVo> getDealResultList(String alarmType,String dealState,
                                             Integer pageIndex, Integer pageSize);

    ResultVo delete(String id);

    ResultVo update(PsmDealResVo vo);

    ResultVo add(PsmDealResVo vo);
    
    ResultVo deal(PsmDealResVo dealResVo);
    
}

