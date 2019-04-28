package com.rainyhon.common.service;

import com.rainyhon.common.model.RollCallResult;

import java.util.List;

public interface RollCallService {

	List<RollCallResult> getRollCallResultList(String detailId, String personId);

	void updateRollCall(RollCallResult result);

}
