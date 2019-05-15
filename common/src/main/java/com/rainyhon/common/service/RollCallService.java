package com.rainyhon.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rainyhon.common.constant.AreaDef;
import com.rainyhon.common.constant.Constants;
import com.rainyhon.common.mapper.RollCallResultMapper;
import com.rainyhon.common.mapper.ScheduleDetailMapper;
import com.rainyhon.common.model.RollCallResult;
import com.rainyhon.common.model.RollCallResultExample;
import com.rainyhon.common.model.ScheduleDetail;
import com.rainyhon.common.model.ScheduleDetailExample;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.EntityUtils;
import com.rainyhon.common.vo.RollCallInfo;
import com.rainyhon.common.vo.RollCallResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.rainyhon.common.constant.Constants.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class RollCallService {

	@Autowired
	private RollCallResultMapper rollCallResultMapper;

	@Autowired
	private ScheduleDetailMapper scheduleDetailMapper;

	@Autowired
	private OrgService orgService;

	@Autowired
	private PersonInfoService personInfoService;

	@Autowired
	private CommonService commonService;

	public PageInfo<RollCallResultVo> getRollCallResultList(String orgId, String personId,
	                                                        Integer pageIndex, Integer pageSize) {

		RollCallResultExample example = new RollCallResultExample();
		RollCallResultExample.Criteria criteria = example.createCriteria();

		if (StringUtils.isNotBlank(orgId)) {
			criteria.andOrgIdEqualTo(orgId.trim());
		}

		if (StringUtils.isNotBlank(personId)) {
			criteria.andPersonIdEqualTo(personId.trim());
		}

		PageInfo<RollCallResult> pageInfo = PageHelper.startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> rollCallResultMapper.selectByExample(example));

		PageInfo<RollCallResultVo> voPageInfo = CommonUtil.po2VO(pageInfo, PageInfo.class);
		List<RollCallResultVo> voList = CommonUtil.listPo2VO(pageInfo.getList(), RollCallResultVo.class);
		voPageInfo.setList(voList);

		return voPageInfo;
	}

	public List<RollCallResult> getRollCallResultList(String detailId, String personId) {
		RollCallResultExample example = new RollCallResultExample();
		RollCallResultExample.Criteria criteria = example.createCriteria();
		criteria.andDetailIdEqualTo(detailId);
		criteria.andPersonIdEqualTo(personId);
		return rollCallResultMapper.selectByExample(example);
	}

	public PageInfo<RollCallInfo> getRollCall(Integer pageIndex, Integer pageSize) {
		ScheduleDetailExample example = new ScheduleDetailExample();
		example.setOrderByClause("crt_tm desc");
		ScheduleDetailExample.Criteria criteria = example.createCriteria();
		criteria.andTypeEqualTo(SCHEDULE_DETAIL_TYPE_ROLL_CALL);

		PageInfo<ScheduleDetail> pageInfo = PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(()
				-> scheduleDetailMapper.selectByExample(example));
		List<ScheduleDetail> list = pageInfo.getList();
		List<RollCallInfo> infoList = CommonUtil.listPo2VO(list, RollCallInfo.class);
		infoList.forEach(info -> {
			info.setOrgName(orgService.getOrgNameById(info.getObjectId()));
			info.setTeacherName(personInfoService.getPersonInfoName(info.getTeacher()));
			info.setRealRollCallCount(getRealRollCallCount(info.getId()));
			info.setAddressName(AreaDef.getAreaNameById(info.getAddress()));
			info.setRollCallStatus(getRollCallStatus(info.getId()));
		});

		PageInfo<RollCallInfo> rollCallInfoPageInfo = CommonUtil.po2VO(pageInfo, PageInfo.class);
		rollCallInfoPageInfo.setList(infoList);

		return rollCallInfoPageInfo;
	}

	private ScheduleDetail getRollCallById(String id) {
		return scheduleDetailMapper.selectByPrimaryKey(id);
	}

	private String getRollCallStatus(String id) {
		ScheduleDetail scheduleDetail = getRollCallById(id);

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss SSS");
		String s = sdf.format(new Date());
		Date date = new Date();
		try {
			date = sdf.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (scheduleDetail.getEndTime().getTime() < date.getTime()) {
			return "结束";
		} else {
			return "进行中";
		}
	}

	private Integer getRealRollCallCount(String detailId) {
		String sql = "from roll_call_result where detail_id = #{detailId} and result = '3'";

		Map<String, Object> params = new HashMap<>(3);
		params.put("sql", sql);
		params.put("detailId", detailId);
		Long count = commonService.executeGetCount(params);

		return count.intValue();
	}

	public List<RollCallResultVo> getRollCallDetailById(String detailId) {
		RollCallResultExample example = new RollCallResultExample();
		RollCallResultExample.Criteria criteria = example.createCriteria();
		criteria.andDetailIdEqualTo(detailId);
		criteria.andDelStatusEqualTo(DELETE_STATUS_NO);
		List<RollCallResult> callResultList = rollCallResultMapper.selectByExample(example);
		List<RollCallResultVo> callResultVoList = CommonUtil.listPo2VO(callResultList, RollCallResultVo.class);
		callResultVoList.forEach(vo -> {
			vo.setPersonName(personInfoService.getPersonInfoName(vo.getPersonId()));
			vo.setResultStr(getAttendanceString(vo.getResult()));
			vo.setOrgName(orgService.getOrgNameById(vo.getOrgId()));
		});

		return callResultVoList;
	}

	private String getAttendanceString(String code) {
		switch (code) {
			case ATTENDANCE_RESULT_ABSENTEEISM:
				return "缺勤";

			case ATTENDANCE_RESULT_LATE:
				return "迟到";

			case ATTENDANCE_RESULT_LEAVE_EARLY:
				return "早退";

			case Constants.ATTENDANCE_RESULT_OK:
				return "到位";

			default:
				return "";
		}
	}

	public void updateRollCall(RollCallResult result) {
		rollCallResultMapper.updateByPrimaryKeySelective(result);
	}

	public void editRollCallResult(RollCallResult result) {
		EntityUtils.setUpdateInfo(result);
		rollCallResultMapper.updateByPrimaryKeySelective(result);
	}

}

