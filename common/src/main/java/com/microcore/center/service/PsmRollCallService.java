package com.microcore.center.service;

import java.util.Date;

import com.github.pagehelper.PageInfo;
import com.microcore.center.vo.PsmRollCallVo;

public interface PsmRollCallService {

	PageInfo<PsmRollCallVo> query(String team, Date callTime, Integer pageIndex, Integer pageSize);

}
