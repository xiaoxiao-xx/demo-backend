package com.rainyhon.common.service;

import java.util.Date;

import com.github.pagehelper.PageInfo;
import com.rainyhon.common.vo.PsmRollCallVo;

public interface PsmRollCallService {

	PageInfo<PsmRollCallVo> query(String team, Date callTime, Integer pageIndex, Integer pageSize);

}
