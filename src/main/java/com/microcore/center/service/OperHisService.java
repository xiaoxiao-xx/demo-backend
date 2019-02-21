package com.microcore.center.service;

import java.util.List;

import com.microcore.center.model.PsmOperHis;
import com.microcore.center.vo.PsmOperHisVo;

public interface OperHisService {
	
	public void add(String operTarget, String operType);

	public void add(PsmOperHis psmOperHis);

	public List<PsmOperHisVo> getPsmOperHis(String operTarget);

}
