package com.rainyhon.common.service;

import com.github.pagehelper.PageInfo;
import com.rainyhon.common.model.RollCallResult;
import com.rainyhon.common.vo.RollCallResultVo;

import java.util.List;

public interface RollCallService {

	PageInfo<RollCallResultVo> getRollCallResultList(String orgId, String personId, Integer pageIndex, Integer pageSize);

	List<RollCallResult> getRollCallResultList(String detailId, String personId);

	void updateRollCall(RollCallResult result);

}
