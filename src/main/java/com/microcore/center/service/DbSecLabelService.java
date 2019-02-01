package com.microcore.center.service;

import com.microcore.common.util.ResultVo;

/**
 *
 */
public interface DbSecLabelService {

	ResultVo getSecLabelList(String orgId, Integer pageIndex, Integer pageSize);

	ResultVo getSecLabelDetailedInfo(String labelId);

}

