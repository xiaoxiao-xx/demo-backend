package com.microcore.center.service;

import com.microcore.center.vo.DetailVo;
import com.microcore.center.vo.SummaryVo;

import java.util.List;

public interface SummaryService {

	List<SummaryVo> getSummary(Integer pageIndex, Integer pageSize);

	List<DetailVo> getDetailList(Integer pageIndex, Integer pageSize);

}
