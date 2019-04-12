package com.microcore.center.service;

import com.microcore.center.model.PsmDetail;
import com.microcore.center.model.PsmSummary;

public interface SummaryService {

	void addSummary(PsmSummary summary);

	void addDetail(PsmDetail detail);

}
