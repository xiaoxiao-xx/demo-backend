package com.rainyhon.common.service;

import java.util.List;

import com.microcore.center.model.PsmSrcRecord;

public interface SrcRecordService {

	void add(PsmSrcRecord srcRecord);

	void update(PsmSrcRecord srcRecord);

	List<PsmSrcRecord> getPsmSrcRecord(String srcState);
	
}
