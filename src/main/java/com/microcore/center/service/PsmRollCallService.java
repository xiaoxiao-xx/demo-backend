package com.microcore.center.service;

import java.util.Date;

import com.github.pagehelper.PageInfo;
import com.microcore.center.model.PsmRollCall;

public interface PsmRollCallService {
	public PageInfo<PsmRollCall> query(String team, Date callTime, Integer pageIndex, Integer pageSize);
}
