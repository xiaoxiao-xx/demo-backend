package com.rainyhon.common.service;

import com.github.pagehelper.PageInfo;
import com.rainyhon.common.vo.AlarmPolicyVo;
import com.rainyhon.common.vo.AlarmPolicyOpt;
import com.rainyhon.common.vo.ResultVo;

public interface AlarmPolicyService {

	PageInfo<AlarmPolicyVo> query(String alarmType, String strategy,
	                              Integer pageIndex, Integer pageSize);

	ResultVo add(AlarmPolicyVo alarmPolicyVo);

	ResultVo update(AlarmPolicyVo alarmPolicyVo);

	ResultVo delete(String id);
	
	ResultVo startStop(AlarmPolicyOpt alarmPolicyOpt);

}
