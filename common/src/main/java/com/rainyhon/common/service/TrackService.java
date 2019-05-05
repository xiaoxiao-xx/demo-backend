package com.rainyhon.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rainyhon.common.mapper.InOutRecordMapper;
import com.rainyhon.common.model.InOutRecord;
import com.rainyhon.common.model.InOutRecordExample;
import com.rainyhon.common.constant.AreaDef;
import com.rainyhon.common.model.PersonInfo;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.vo.InOutRecordVo;
import com.rainyhon.common.vo.ResultVo;
import com.rainyhon.common.vo.TrackInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class TrackService {

	private final CommonService commonService;

	@Autowired
	public TrackService(CommonService commonService) {
		this.commonService = commonService;
	}

	/**
	 * 查询人员轨迹信息
	 * 作废接口
	 * 不再使用 summary 表及 detail 表
	 *
	 * @param userId user's id
	 * @return Track info list
	 */
	public ResultVo getTrackInfo(String userId) {
		String sql = "SELECT DATE_FORMAT( m.create_time, '%H:%i' ) time, m.area_id, m.create_time FROM face f \n" +
				"LEFT JOIN material m ON f.material_id = m.id \n" +
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

	public ResultVo getTrackInfo2(String userId, Date time) {
		String sql = "SELECT DATE_FORMAT(in_time, '%H:%i') time, area_id \n" +
				"FROM in_out_record \n" +
				"WHERE 1 = 1 \n" +
				"AND user_id = #{userId} \n" +
				"AND DATE_FORMAT(#{inOutTime}, '%Y-%m-%d') = DATE_FORMAT(in_time, '%Y-%m-%d') \n" +
				"ORDER BY in_time ASC";

		Map<String, Object> params = new HashMap<>(2);
		params.put("sql", sql);
		params.put("userId", userId);
		if (time == null) {
			params.put("inOutTime", new Date());
		} else {
			params.put("inOutTime", time);
		}

		List<Map<String, Object>> list = commonService.executeSelectSQL(params);
		List<TrackInfo> infoList = CommonUtil.map2PO(list, TrackInfo.class);
		infoList.forEach(info -> info.setAreaName(AreaDef.getAreaNameById(info.getAreaId())));

		return ResultVo.ok(infoList);
	}

	@Autowired
	private InOutRecordMapper inOutRecordMapper;

	@Autowired
	private PersonInfoService personInfoService;

	/**
	 * 查询用户的进出记录
	 *
	 * @param userId
	 * @return
	 */
	public ResultVo<?> getInOutTrack(String userId) {
		InOutRecordExample example = new InOutRecordExample();
		example.setOrderByClause("in_time desc");
		InOutRecordExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<InOutRecord> list = inOutRecordMapper.selectByExample(example);
		if (list == null) {
			list = new ArrayList<>();
		}

		List<InOutRecord> recordList = list;
		if (list.size() > 10) {
			recordList = list.subList(0, 10);
		}
		List<InOutRecordVo> voList = CommonUtil.listPo2VO(recordList, InOutRecordVo.class);
		voList.forEach(vo -> {
			vo.setAreaName(AreaDef.getAreaNameById(vo.getAreaId()));
			vo.setPersonName(personInfoService.getPersonInfoName(vo.getUserId()));
		});

		return ResultVo.ok(voList);
	}

	@Autowired
	private OrgService orgService;

	/**
	 * 查询人员进出记录
	 *
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public ResultVo getInOutTrackList(String areaId, Integer pageIndex, Integer pageSize) {
		InOutRecordExample example = new InOutRecordExample();
		example.setOrderByClause("in_time desc");
		InOutRecordExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(areaId)) {
			criteria.andAreaIdEqualTo(areaId);
		}

		PageInfo<InOutRecord> pageInfo = PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(()
				-> inOutRecordMapper.selectByExample(example));

		List<InOutRecord> list = pageInfo.getList();
		if (list == null) {
			list = new ArrayList<>();
		}
		List<InOutRecordVo> voList = CommonUtil.listPo2VO(list, InOutRecordVo.class);
		voList.forEach(vo -> {
			vo.setAreaName(AreaDef.getAreaNameById(vo.getAreaId()));
			vo.setPersonName(personInfoService.getPersonInfoName(vo.getUserId()));

			String userId = vo.getUserId();
			PersonInfo personInfo = personInfoService.getPersonInfo(userId);
			String orgId = personInfo.getOrgId();
			vo.setOrgName(orgService.getOrgNameById(orgId));
		});

		PageInfo<InOutRecordVo> voPageInfo = CommonUtil.po2VO(pageInfo, PageInfo.class);
		voPageInfo.setList(voList);
		return ResultVo.ok(voPageInfo);
	}

	public ResultVo getPieChart(String userId, Date time) {
		String sql = "SELECT area_id, count(area_id) count\n" +
				"FROM in_out_record \n" +
				"WHERE 1 = 1 AND user_id = #{userId} AND DATE_FORMAT( #{inOutTime}, '%Y-%m-%d') = DATE_FORMAT(in_time, '%Y-%m-%d') \n" +
				"GROUP BY area_id \n" +
				"ORDER BY in_time ASC";

		Map<String, Object> params = new HashMap<>(2);
		params.put("sql", sql);
		params.put("userId", userId);
		if (time == null) {
			params.put("inOutTime", new Date());
		} else {
			params.put("inOutTime", time);
		}

		List<Map<String, Object>> list = commonService.executeSelectSQL(params);
		List<TrackInfo> infoList = CommonUtil.map2PO(list, TrackInfo.class);
		infoList.forEach(info -> info.setAreaName(AreaDef.getAreaNameById(info.getAreaId())));

		return ResultVo.ok(infoList);
	}

}
