package com.rainyhon.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.mapper.InOutRecordMapper;
import com.microcore.center.model.InOutRecord;
import com.microcore.center.model.InOutRecordExample;
import com.rainyhon.common.constant.AreaDef;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.vo.InOutRecordVo;
import com.rainyhon.common.vo.ResultVo;
import com.rainyhon.common.vo.TrackInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class TrackService {

	private final CommonService commonService;

	@Autowired
	public TrackService(CommonService commonService) {
		this.commonService = commonService;
	}

	/**
	 * Get Track info
	 *
	 * @param userId user's id
	 * @return Track info list
	 */
	public ResultVo getTrackInfo(String userId) {
		String sql = "SELECT DATE_FORMAT( m.create_time, '%H:%i' ) time, m.area_id, m.create_time FROM psm_face f \n" +
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


	@Autowired
	private InOutRecordMapper inOutRecordMapper;

	@Autowired
	private PersonService personService;

	public ResultVo<?> getInOutTrack(String userId) {
		InOutRecordExample example = new InOutRecordExample();
		example.setOrderByClause("time desc");
		InOutRecordExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<InOutRecord> list = inOutRecordMapper.selectByExample(example);
		if (list == null) {
			list = new ArrayList<>();
		}

		List<InOutRecord> recordList = list.subList(0, 10);
		List<InOutRecordVo> voList = CommonUtil.listPo2VO(recordList, InOutRecordVo.class);
		voList.forEach(vo -> {
			vo.setAreaName(AreaDef.getAreaNameById(vo.getAreaId()));
			vo.setPersonName(personService.getPsmPersonInfoName(vo.getUserId()));
		});

		return ResultVo.ok(voList);
	}

	public ResultVo getInOutTrackList(Integer pageIndex, Integer pageSize) {
		InOutRecordExample example = new InOutRecordExample();
		example.setOrderByClause("time desc");
		InOutRecordExample.Criteria criteria = example.createCriteria();

		PageInfo<InOutRecord> pageInfo = PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(()
				-> inOutRecordMapper.selectByExample(example));

		List<InOutRecord> list = pageInfo.getList();
		if (list == null) {
			list = new ArrayList<>();
		}
		List<InOutRecordVo> voList = CommonUtil.listPo2VO(list, InOutRecordVo.class);
		voList.forEach(vo -> {
			vo.setAreaName(AreaDef.getAreaNameById(vo.getAreaId()));
			vo.setPersonName(personService.getPsmPersonInfoName(vo.getUserId()));
		});

		PageInfo<InOutRecordVo> voPageInfo = CommonUtil.po2VO(pageInfo, PageInfo.class);
		voPageInfo.setList(voList);
		return ResultVo.ok(voPageInfo);
	}

}
