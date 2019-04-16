package com.microcore.center.service.impl;

import com.microcore.center.mapper.PsmScheduleDetailMapper;
import com.microcore.center.model.PsmPersonInfo;
import com.microcore.center.model.PsmScheduleDetail;
import com.microcore.center.model.PsmScheduleDetailExample;
import com.microcore.center.service.CommonService;
import com.microcore.center.service.PersonService;
import com.microcore.center.service.ScheduleDetailService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.util.JedisPoolUtil;
import com.microcore.center.vo.PsmScheduleDetailVo;
import com.microcore.center.vo.ResultVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class ScheduleDetailServiceImpl implements ScheduleDetailService {

	@Autowired
	private PsmScheduleDetailMapper psmScheduleDetailMapper;

	@Autowired
	private CommonService commonService;

	@Autowired
	private JedisPoolUtil redisUtil;

	@Autowired
	private PersonService personService;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");

	@Override
	public ResultVo add(PsmScheduleDetailVo vo) {
		addDetail(vo);
		return ResultVo.ok();
	}

	@Override
	public void addDetail(PsmScheduleDetail detail) {
		detail.setId(CommonUtil.getUUID());
		psmScheduleDetailMapper.insertSelective(detail);
	}

	@Override
	public ResultVo update(PsmScheduleDetailVo vo) {
		psmScheduleDetailMapper.updateByPrimaryKeySelective(vo);
		return ResultVo.ok();
	}

	@Override
	public ResultVo delete(String id) {
		psmScheduleDetailMapper.deleteByPrimaryKey(id);
		return ResultVo.ok();
	}

	@Override
	public ResultVo getScheduleDetailList(String objectType) {
		PsmScheduleDetailExample example = new PsmScheduleDetailExample();
		example.setOrderByClause("start_time asc");
		PsmScheduleDetailExample.Criteria criteria = example.createCriteria();
		criteria.andObjectTypeLike("%" + objectType.trim() + "%");
		List<PsmScheduleDetail> psmScheduleDetails = psmScheduleDetailMapper.selectByExample(example);
		return ResultVo.ok(psmScheduleDetails);
	}

	@Override
	public ResultVo getOnDutyData() {
		String sql = "SELECT p.dept_id team_id, COUNT( 1 ) total_count, d.dept_name team_name\n" +
				" FROM psm_person_info_t p\n" +
				" LEFT JOIN psm_dept_info_t d ON p.dept_id = d.dept_id \n" +
				" GROUP BY p.dept_id HAVING p.dept_id <> '0'";

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

				if (dateFormat.parse(captureTime).getTime() > nineClock.getTime().getTime()) {
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
		PsmPersonInfo leader = getLeader(dayOfWeek);
		duty.setLeaderName(leader.getName());
		PsmPersonInfo onDutyPerson = getOnDutyPerson(dayOfWeek);
		duty.setOnDutyPerson(onDutyPerson.getName());
		duty.setStatList(statList);
		duty.setTotalCount(totalCount);
		duty.setOnDutyCount(onDutyCount);
		duty.setNotOnDutyCount(totalCount - onDutyCount);
		return ResultVo.ok(duty);
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

	private List<String> leaderList = new ArrayList();

	{
		leaderList.add("u22");
		leaderList.add("u9");
	}

	private PsmPersonInfo getLeader(int dayOfWeek) {
		int index = (dayOfWeek - 1) % leaderList.size();
		String userId = leaderList.get(index);
		return personService.getPsmPersonInfo(userId);
	}

	private List<String> onDutyPersonList = new ArrayList();

	{
		onDutyPersonList.add("u17");
		onDutyPersonList.add("u18");
		onDutyPersonList.add("u19");
		onDutyPersonList.add("u20");
		onDutyPersonList.add("u21");
		onDutyPersonList.add("u23");
	}

	private PsmPersonInfo getOnDutyPerson(int dayOfWeek) {
		int index = (dayOfWeek - 1) % onDutyPersonList.size();
		String userId = onDutyPersonList.get(index);
		return personService.getPsmPersonInfo(userId);
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

