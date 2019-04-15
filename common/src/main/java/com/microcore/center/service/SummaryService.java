package com.microcore.center.service;

import com.microcore.center.service.impl.SummaryServiceImpl;
import com.microcore.center.vo.DetailVo;

import java.util.List;

public interface SummaryService {

	List getSummary();

	List<SummaryServiceImpl.AreaCount> getSummaryRedis();

	List<DetailVo> getDetailList(String areaId);

	List<DetailVo> getDetailListRedis(String areaId);

}
