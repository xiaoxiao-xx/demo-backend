package com.microcore.center.service;

import com.microcore.center.vo.DetailVo;
import com.microcore.center.vo.FaceSummaryVo;
import com.microcore.center.vo.SummaryVo;

import java.util.List;

public interface SummaryService {

	List<SummaryVo> getSummary(Integer pageIndex, Integer pageSize);


	List<DetailVo> getDetailList(String areaId, Integer pageIndex, Integer pageSize);
}
