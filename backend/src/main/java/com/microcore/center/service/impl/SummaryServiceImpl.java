package com.microcore.center.service.impl;

import com.microcore.center.service.CommonService;
import com.microcore.center.service.SummaryService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.vo.DetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class SummaryServiceImpl implements SummaryService {

	private final int summaryTaskInterval = 60000;

	@Autowired
	private CommonService commonService;

	@Override
	public List<DetailVo> getSummary() {
		String sql = "SELECT * \n" +
				"FROM\n" +
				"\tpsm_detail \n" +
				"WHERE\n" +
				"\t1 = 1 \n" +
				"\tAND psm_detail.time > DATE_SUB( NOW( ), INTERVAL #{intervalTime} SECOND ) \n" +
				"GROUP BY\n" +
				"\tarea_id,\n" +
				"\tuser_id\n";

		Map<String, Object> params = new HashMap<>(3);
		params.put("sql", sql);
		params.put("intervalTime", summaryTaskInterval / 1000);
		List<Map<String, Object>> list = commonService.executeSelectSQL(params);

		return CommonUtil.map2PO(list, DetailVo.class);
	}

	/**
	 * 返回一个区域的人的列表
	 */
	@Override
	public List<DetailVo> getDetailList(String areaId, Integer pageIndex, Integer pageSize) {
		String sql = "SELECT * \n" +
				"FROM\n" +
				"\tpsm_detail \n" +
				"WHERE psm_detail.time > DATE_SUB( NOW( ), INTERVAL #{intervalTime} SECOND ) \n" +
				"\tAND area_id = #{areaId} \n" +
				"\tgroup by user_id";

		Map<String, Object> params = new HashMap<>(3);
		params.put("sql", sql);
		params.put("areaId", areaId);
		params.put("intervalTime", summaryTaskInterval / 1000);
		List<Map<String, Object>> list = commonService.executeSelectSQL(params);

		return CommonUtil.map2PO(list, DetailVo.class);
	}

}
