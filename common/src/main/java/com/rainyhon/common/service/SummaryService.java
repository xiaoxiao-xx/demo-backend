package com.rainyhon.common.service;

import com.rainyhon.common.service.impl.SummaryServiceImpl;
import com.rainyhon.common.vo.DetailVo;

import java.util.List;

public interface SummaryService {

	List getSummary();

	List<SummaryServiceImpl.AreaCount> getSummaryRedis();

	List<DetailVo> getDetailList(String areaId);

	List<DetailVo> getDetailListRedis(String areaId);

}
