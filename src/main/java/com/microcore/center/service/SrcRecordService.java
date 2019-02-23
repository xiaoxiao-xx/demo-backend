package com.microcore.center.service;

import java.util.List;

import com.microcore.center.model.PsmSrcRecord;

public interface SrcRecordService {
	public void add(PsmSrcRecord srcRecord);
	public void update(PsmSrcRecord srcRecord);
	public List<PsmSrcRecord> getPsmSrcRecord(String srcState);
	
}
