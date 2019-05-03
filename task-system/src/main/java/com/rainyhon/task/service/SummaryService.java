package com.rainyhon.task.service;

import com.microcore.center.mapper.PsmDetailMapper;
import com.microcore.center.mapper.PsmSummaryMapper;
import com.microcore.center.model.PsmDetail;
import com.microcore.center.model.PsmSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class SummaryService {

	@Autowired
	private PsmSummaryMapper summaryMapper;

	@Autowired
	private PsmDetailMapper detailMapper;

	public void addSummary(PsmSummary summary) {
		summaryMapper.insert(summary);
	}

	public void addDetail(PsmDetail detail) {
		detailMapper.insert(detail);
	}

}

