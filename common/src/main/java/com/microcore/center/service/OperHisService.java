package com.microcore.center.service;

import java.util.List;

import com.microcore.center.model.PsmOperHis;
import com.microcore.center.vo.PsmOperHisVo;

public interface OperHisService {
	
	void add(String operTarget, String operType);

	void add(PsmOperHis psmOperHis);

	List<PsmOperHisVo> getPsmOperHis(String operTarget);

}
