package com.microcore.center.service;

import com.github.pagehelper.PageInfo;
import com.microcore.center.vo.AlarmPolicyVo;
import com.microcore.center.vo.AlarmPolicyOpt;
import com.microcore.center.vo.ResultVo;

public interface AlarmPolicyService {

	PageInfo<AlarmPolicyVo> query(String alarmType, String strategy,
	                              Integer pageIndex, Integer pageSize);

	ResultVo add(AlarmPolicyVo alarmPolicyVo);

	ResultVo update(AlarmPolicyVo alarmPolicyVo);

	ResultVo delete(String id);
	
	ResultVo startStop(AlarmPolicyOpt alarmPolicyOpt);

}
