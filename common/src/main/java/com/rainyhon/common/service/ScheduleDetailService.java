package com.rainyhon.common.service;

import com.rainyhon.common.constant.Constants;
import com.rainyhon.common.mapper.RollCallResultMapper;
import com.rainyhon.common.mapper.ScheduleDetailMapper;
import com.rainyhon.common.model.*;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.EntityUtils;
import com.rainyhon.common.util.JedisPoolUtil;
import com.rainyhon.common.vo.ResultVo;
import com.rainyhon.common.vo.ScheduleDetailVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.rainyhon.common.constant.Constants.ATTENDANCE_RESULT_ABSENTEEISM;
import static com.rainyhon.common.constant.Constants.SCHEDULE_DETAIL_TYPE_ROLL_CALL;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class ScheduleDetailService {

	private final ScheduleDetailMapper scheduleDetailMapper;

	private final CommonService commonService;

	private final JedisPoolUtil redisUtil;

	private final PersonInfoService personInfoService;

	private final ThreadLocal<SimpleDateFormat> dateFormat = ThreadLocal.withInitial(()
			-> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS"));

	private List<String> leaderList = new ArrayList<>();

	private List<String> onDutyPersonList = new ArrayList<>();

	{
		leaderList.add("u22");
		leaderList.add("u9");
	}

	{
		onDutyPersonList.add("u17");
		onDutyPersonList.add("u19");
		onDutyPersonList.add("u20");
		onDutyPersonList.add("u21");
		onDutyPersonList.add("u23");
	}

	@Autowired
	public ScheduleDetailService(ScheduleDetailMapper scheduleDetailMapper, CommonService commonService,
	                             JedisPoolUtil redisUtil, PersonInfoService personInfoService) {
		this.scheduleDetailMapper = scheduleDetailMapper;
		this.commonService = commonService;
		this.redisUtil = redisUtil;
		this.personInfoService = personInfoService;
	}

	public ResultVo<String> add(ScheduleDetailVo vo) {
		String id = addDetail(vo);
		return ResultVo.ok(id);
	}

	@Autowired
	private UserService userService;

	public String addDetail(ScheduleDetail detail) {
		String detailId = CommonUtil.getUUID();
		detail.setId(detailId);

		// 默认把机构总人数设置为应到人数
		String currentOrgId = CommonUtil.getCurrentOrgId();
		Integer number = personInfoService.getPersonCountByOrgId(currentOrgId);
		detail.setNumber(number);

		// 后台默认设置时间
		int defaultTime = 60;
		detail.setSomeDate(new Date());
		detail.setStartTime(new Date());
		detail.setEndTime(new DateTime().plusSeconds(defaultTime).toDate());

		String currentUserId = CommonUtil.getCurrentUserId();
		String teacherId = userService.getRealPersonIdByUserId(currentUserId);
		detail.setTeacher(teacherId);
		EntityUtils.setCreateAndUpdateInfo(detail);

		// 为电子点名生成结果表
		if (SCHEDULE_DETAIL_TYPE_ROLL_CALL.equals(detail.getType())) {
			List<PersonInfo> personInfoList = personInfoService.getPersonInfoListByOrgId(detail.getObjectId());
			if (CommonUtil.isNotEmpty(personInfoList)) {
				personInfoList.forEach(personInfo -> {
					RollCallResult result = new RollCallResult();
					result.setId(CommonUtil.getUUID());
					result.setOrgId(personInfo.getOrgId());
					result.setPersonId(personInfo.getId());
					result.setDetailId(detailId);
					result.setResult(ATTENDANCE_RESULT_ABSENTEEISM);
					EntityUtils.setCreateAndUpdateInfo(result);
					rollCallResultMapper.insert(result);
				});
			}
		}

		scheduleDetailMapper.insertSelective(detail);

		return detailId;
	}

	@Autowired
	private RollCallResultMapper rollCallResultMapper;

	public ResultVo update(ScheduleDetailVo vo) {
		scheduleDetailMapper.updateByPrimaryKeySelective(vo);
		return ResultVo.ok();
	}

	public void update(ScheduleDetail detail) {
		scheduleDetailMapper.updateByPrimaryKeySelective(detail);
	}

	public ResultVo delete(String id) {
		scheduleDetailMapper.deleteByPrimaryKey(id);
		return ResultVo.ok();
	}

	public ResultVo getScheduleDetailList(String objectType) {
		ScheduleDetailExample example = new ScheduleDetailExample();
		example.setOrderByClause("start_time asc");
		ScheduleDetailExample.Criteria criteria = example.createCriteria();
		criteria.andObjectTypeLike("%" + objectType.trim() + "%");
		List<ScheduleDetail> scheduleDetailList = scheduleDetailMapper.selectByExample(example);
		return ResultVo.ok(scheduleDetailList);
	}

	public ResultVo getOnDutyData() {
		String sql = "SELECT p.org_id team_id, COUNT( 1 ) total_count, d.dept_name team_name \n" +
				"FROM person_info p \n" +
				"LEFT JOIN dept_info d ON p.org_id = d.dept_id \n" +
				"GROUP BY p.org_id HAVING p.org_id <> '0'";

		Map<String, Object> params = new HashMap<>(3);
		params.put("sql", sql);
		List<Map<String, Object>> list = commonService.executeSelectSQL(params);

		List<TeamStat> statList = CommonUtil.map2PO(list, TeamStat.class);

		Calendar nineClock = getNineClock();
		Integer onDutyCount = 0;
		Map<String, Integer> onDutyMap = new HashMap<>();
		Set<String> keys = redisUtil.keys("u*");
		for (String key : keys) {
			List<String> map = redisUtil.hmget(key, "teamId", "captureTime");
			String teamId = map.get(0);
			String captureTime = map.get(1);

			// log.info("{}-{}", nineClock.getTime().toString(), nineClock.getTime().getTime());
			// log.info("{}", captureTime);

			try {
				if (dateFormat.get().parse(captureTime).getTime() > nineClock.getTime().getTime()) {
					addOne(onDutyMap, teamId);
					onDutyCount += 1;
					// log.info("on duty: {}", key);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		Integer totalCount = 0;
		for (TeamStat teamStat : statList) {
			String teamId = teamStat.getTeamId();
			Integer number = onDutyMap.get(teamId);
			teamStat.setOnDutyCount(number == null ? 0 : number);

			totalCount += teamStat.getTotalCount();
		}

		Duty duty = new Duty();
		int dayOfWeek = getDayOfWeek();
		PersonInfo leader = getLeader(dayOfWeek);
		duty.setLeaderName(leader.getName());
		PersonInfo onDutyPerson = getOnDutyPerson(dayOfWeek);
		duty.setOnDutyPerson(onDutyPerson.getName());
		duty.setStatList(statList);
		duty.setTotalCount(totalCount);
		duty.setOnDutyCount(onDutyCount);
		duty.setNotOnDutyCount(totalCount - onDutyCount);
		return ResultVo.ok(duty);
	}

	public List<ScheduleDetail> getScheduleDetailByTimeAndArea(String userId, Date time, String areaId) {
		Date timeAdd10Minute = new Date(time.getTime() + 10 * 60 * 1000);
		Date timeSub10Minute = new Date(time.getTime() - 10 * 60 * 1000);

		ScheduleDetailExample example = new ScheduleDetailExample();
		ScheduleDetailExample.Criteria criteria = example.createCriteria();
		criteria.andObjectIdEqualTo(userId);
		// 非电子点名
		criteria.andTypeNotEqualTo(SCHEDULE_DETAIL_TYPE_ROLL_CALL);
		criteria.andStartTimeLessThanOrEqualTo(timeAdd10Minute);
		criteria.andEndTimeGreaterThanOrEqualTo(timeSub10Minute);
		criteria.andAddressEqualTo(areaId);
		criteria.andDelStatusEqualTo(Constants.DELETE_STATUS_NO);
		return scheduleDetailMapper.selectByExample(example);
	}

	public List<ScheduleDetail> getScheduleDetailByTimeForRollCall(String orgId, Date time, String areaId) {
		Date timeAdd10Minute = new Date(time.getTime() + 30 * 1000);
		Date timeSub10Minute = new Date(time.getTime() - 30 * 1000);

		ScheduleDetailExample example = new ScheduleDetailExample();
		ScheduleDetailExample.Criteria criteria = example.createCriteria();
		criteria.andObjectIdEqualTo(orgId);
		// 电子点名
		criteria.andTypeEqualTo(SCHEDULE_DETAIL_TYPE_ROLL_CALL);
		criteria.andStartTimeLessThanOrEqualTo(timeAdd10Minute);
		criteria.andEndTimeGreaterThanOrEqualTo(timeSub10Minute);
		criteria.andAddressEqualTo(areaId);
		criteria.andDelStatusEqualTo(Constants.DELETE_STATUS_NO);
		return scheduleDetailMapper.selectByExample(example);
	}

	private int getDayOfWeek() {
		Calendar current = Calendar.getInstance();
		return current.get(Calendar.DAY_OF_WEEK);
	}

	private Calendar getNineClock() {
		Calendar nineClock = Calendar.getInstance();
		nineClock.set(Calendar.HOUR_OF_DAY, 9);
		nineClock.set(Calendar.MINUTE, 0);
		nineClock.set(Calendar.SECOND, 0);
		nineClock.set(Calendar.MILLISECOND, 0);

		return nineClock;
	}

	private PersonInfo getLeader(int dayOfWeek) {
		int index = (dayOfWeek - 1) % leaderList.size();
		String userId = leaderList.get(index);
		return personInfoService.getPersonInfo(userId);
	}

	private PersonInfo getOnDutyPerson(int dayOfWeek) {
		int index = (dayOfWeek - 1) % onDutyPersonList.size();
		String userId = onDutyPersonList.get(index);
		return personInfoService.getPersonInfo(userId);
	}

	private void addOne(Map<String, Integer> map, String key) {
		map.merge(key, 1, (a, b) -> a + b);
	}

	@Data
	@EqualsAndHashCode(callSuper = false)
	public static class Duty {

		private String leaderName;

		private String onDutyPerson;
		/**
		 *
		 */
		private Integer totalCount;

		private Integer onDutyCount;

		private Integer notOnDutyCount;

		private List<TeamStat> statList;

		public Duty() {

		}

		public Duty(String leaderName, String onDutyPerson, List<TeamStat> statList) {
			setLeaderName(leaderName);
			setOnDutyPerson(onDutyPerson);
			setStatList(statList);
		}
	}

	@Data
	@EqualsAndHashCode(callSuper = false)
	public static class TeamStat {
		/**
		 *
		 */
		private String teamId;

		/**
		 * 团队名
		 */
		private String teamName;
		/**
		 * 总人数
		 */
		private Integer totalCount;
		/**
		 * 在位人数
		 */
		private Integer onDutyCount;

	}

}

