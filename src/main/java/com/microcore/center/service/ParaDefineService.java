package com.microcore.center.service;

import java.util.List;

import com.microcore.center.model.PsmParaDefine;

public interface ParaDefineService {

	public List<PsmParaDefine> getPsmParaDefineByType(String type);
	
	public PsmParaDefine getPsmParaDefineByTypeAnd(String type,String code);
	
	public String getValueByTypeAnd(String type,String code);
	
}
