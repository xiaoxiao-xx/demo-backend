package com.microcore.center.service.impl;

import com.microcore.center.service.CommonService;
import com.microcore.center.service.TrackService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.vo.ResultVo;
import com.microcore.center.vo.TrackInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class TrackServiceImpl implements TrackService {

	private final CommonService commonService;

	@Autowired
	public TrackServiceImpl(CommonService commonService) {
		this.commonService = commonService;
	}

	/**
	 * Get Track info
	 *
	 * @param userId user's id
	 * @return Track info list
	 */
	@Override
	public ResultVo getTrackInfo(String userId) {
		String sql = "SELECT f.*, m.area_id, m.create_time capture_time FROM psm_face f \n" +
				"LEFT JOIN psm_material m ON f.material_id = m.id \n" +
				"GROUP BY m.area_id, f.user_id, DATE_FORMAT(m.create_time, '%Y-%m-%d %H-%i') \n" +
				"HAVING user_id = #{userId} AND DATE_FORMAT(NOW( ), '%Y-%m-%d') = DATE_FORMAT(m.create_time, '%Y-%m-%d') \n" +
				"ORDER BY m.create_time ASC";

		Map<String, Object> params = new HashMap<>(2);
		params.put("sql", sql);
		params.put("userId", userId);
		List<Map<String, Object>> list = commonService.executeSelectSQL(params);
		List<TrackInfo> infoList = CommonUtil.map2PO(list, TrackInfo.class);
		return ResultVo.ok(infoList);
	}

}
