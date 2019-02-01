package com.microcore.center.service;

import com.microcore.center.model.DbParams;
import com.microcore.common.util.ResultVo;

import java.util.List;

public interface DbParamsService {

	List<DbParams> getTypeOrMode(String paramsType);

	List<DbParams> getParamListByTypeAndKey(String paramsType, String paramsKey);

	String getParamsValueByTypeAndKey(String paramsType, String paramsKey);
	
	ResultVo addParams(List<DbParams> params);

	ResultVo openOrCloseMasterKey(String status);
}
