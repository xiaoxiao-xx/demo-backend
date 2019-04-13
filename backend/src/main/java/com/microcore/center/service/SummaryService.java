package com.microcore.center.service;

import com.microcore.center.vo.DetailVo;

import java.util.List;

public interface SummaryService {

	List<DetailVo> getSummary();

	List<DetailVo> getDetailList(String areaId, Integer pageIndex, Integer pageSize);

}
