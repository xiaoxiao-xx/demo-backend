package com.rainyhon.common.service;

import com.rainyhon.common.constant.Constants;
import com.rainyhon.common.mapper.SchedulePersonMapper;
import com.rainyhon.common.model.*;
import com.rainyhon.common.vo.ScheduleConfigVo;
import com.rainyhon.common.vo.ResultVo;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.rainyhon.common.mapper.ScheduleConfigMapper;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.vo.SchedulePersonVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.github.pagehelper.page.PageMethod.startPage;
import static com.rainyhon.common.constant.Constants.*;
import static com.rainyhon.common.util.CommonUtil.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class ScheduleConfigService {

	@Autowired
	private ScheduleConfigMapper scheduleConfigMapper;

	@Autowired
	private ParaDefineService paraDefineService;

	@Autowired
	private SchedulePersonMapper schedulePersonMapper;

	@Autowired
	private PersonInfoService personInfoService;

	@Autowired
	private OrgService orgService;

	public ResultVo add(ScheduleConfigVo vo) {
		vo.setId(getUUID());

		if (SCHEDULE_CONFIG_OBJECT_TYPE_PERSON.equals(vo.getObjectType())) {
			// 如果是个人类型的日程配置, 则特殊处理多个个人的列表
			String objectId = CommonUtil.getUUID();
			vo.setObjectId(objectId);

			List<SchedulePersonVo> schedulePersonList = vo.getSchedulePersonList();
			if (CommonUtil.isNotEmpty(schedulePersonList)) {
				schedulePersonList.forEach(schedulePerson -> {
					schedulePerson.setId(CommonUtil.getUUID());
					schedulePerson.setObjectId(objectId);
					schedulePersonMapper.insert(schedulePerson);
				});
			}
		}

		scheduleConfigMapper.insert(vo);

		return ResultVo.ok();
	}

	public ResultVo update(ScheduleConfigVo vo) {
		String id = vo.getId();
		ScheduleConfig scheduleConfig = getScheduleConfigById(id);

		// 如果是个人类型的日程配置, 则特殊处理多个个人的列表
		if (SCHEDULE_CONFIG_OBJECT_TYPE_PERSON.equals(vo.getObjectType())) {
			// 删除旧人员列表
			deleteSchedulePersonByObjectId(scheduleConfig.getObjectId());

			// 新增人员列表
			String objectId = CommonUtil.getUUID();
			vo.setObjectId(objectId);

			List<SchedulePersonVo> schedulePersonList = vo.getSchedulePersonList();
			if (CommonUtil.isNotEmpty(schedulePersonList)) {
				schedulePersonList.forEach(schedulePerson -> {
					schedulePerson.setId(CommonUtil.getUUID());
					schedulePerson.setObjectId(objectId);
					schedulePersonMapper.insert(schedulePerson);
				});
			}
		}

		scheduleConfigMapper.updateByPrimaryKeySelective(vo);
		return ResultVo.ok();
	}

	private void deleteSchedulePersonByObjectId(String objectId) {
		SchedulePersonExample example = new SchedulePersonExample();
		SchedulePersonExample.Criteria criteria = example.createCriteria();
		criteria.andObjectIdEqualTo(objectId);
		schedulePersonMapper.deleteByExample(example);
	}

	public ResultVo delete(String id) {
		ScheduleConfig scheduleConfig = getScheduleConfigById(id);
		deleteSchedulePersonByObjectId(scheduleConfig.getObjectId());

		scheduleConfigMapper.deleteByPrimaryKey(id);

		return ResultVo.ok();
	}

	public ResultVo getScheduleConfigList(Date someDate, String configType, String objectType, String team,
	                                      Integer pageIndex, Integer pageSize) {
		ScheduleConfigExample example = new ScheduleConfigExample();
		ScheduleConfigExample.Criteria criteria = example.createCriteria();

		if (someDate != null) {
			criteria.andSomeDateEqualTo(someDate);
		}
		if (StringUtils.isNotEmpty(configType)) {
			criteria.andConfigTypeEqualTo(configType);
		}
		if (StringUtils.isNotEmpty(objectType)) {
			criteria.andObjectTypeEqualTo(objectType);
		}
		if (StringUtils.isNotEmpty(team)) {
			criteria.andTeamIdEqualTo(team);
		}
		PageInfo<ScheduleConfig> scheduleConfigPageInfo = startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> scheduleConfigMapper.selectByExample(example));

		List<ScheduleConfig> configList = scheduleConfigPageInfo.getList();

		List<ScheduleConfigVo> configVos = listPo2VO(configList, ScheduleConfigVo.class);
		if (CommonUtil.isNotEmpty(configVos)) {
			configVos.forEach(vo -> {
				vo.setCheckFlag("Y".equals(vo.getCheckFlag()) ? "是" : "否");
				vo.setConfigType(paraDefineService.getValueByTypeAnd("SCHEDULE_TYPE", vo.getConfigType()));
				vo.setObjectName(getObjectName(vo));
				vo.setSchedulePersonList(getSchedulePersonListByObjectId(vo));
				vo.setTeacherOrgId(personInfoService.getPersonInfo(vo.getTeacher()).getOrgId());
			});
		}

		PageInfo<ScheduleConfigVo> scheduleConfigVoPageInfo = po2VO(scheduleConfigPageInfo, PageInfo.class);
		scheduleConfigVoPageInfo.setList(configVos);

		return ResultVo.ok(scheduleConfigVoPageInfo);
	}

	private List<SchedulePersonVo> getSchedulePersonListByObjectId(ScheduleConfig config) {
		String objectType = config.getObjectType();
		if (SCHEDULE_CONFIG_OBJECT_TYPE_ORG.equals(objectType)) {
			return null;
		} else if (SCHEDULE_CONFIG_OBJECT_TYPE_PERSON.equals(objectType)) {
			return getSchedulePersonListObjectId(config.getObjectId());
		}

		return null;
	}

	private List<SchedulePersonVo> getSchedulePersonListObjectId(String objectId) {
		SchedulePersonExample example = new SchedulePersonExample();
		SchedulePersonExample.Criteria criteria = example.createCriteria();
		criteria.andObjectIdEqualTo(objectId);
		List<SchedulePersonVo> personVoList = listPo2VO(schedulePersonMapper.selectByExample(example), SchedulePersonVo.class);
		personVoList.forEach(schedulePersonVo ->
				schedulePersonVo.setOrgId(personInfoService.getPersonInfo(schedulePersonVo.getPersonId()).getOrgId()));

		return personVoList;
	}

	private String getObjectName(ScheduleConfig config) {
		String objectType = config.getObjectType();
		if (SCHEDULE_CONFIG_OBJECT_TYPE_ORG.equals(objectType)) {
			return orgService.getOrgNameById(config.getObjectId());
		} else if (SCHEDULE_CONFIG_OBJECT_TYPE_PERSON.equals(objectType)) {
			return getSchedulePersonLeaderName(config);
		}

		return "";
	}

	private String getSchedulePersonLeaderName(ScheduleConfig config) {
		String objectId = config.getObjectId();
		List<SchedulePerson> schedulePersonList = getSchedulePersonLeaderObjectId(objectId);
		if (CommonUtil.isNotEmpty(schedulePersonList)) {
			return personInfoService.getPersonInfoName(schedulePersonList.get(0).getPersonId());
		} else {
			// 没有领导, 取第一个人员的名字
			List<SchedulePersonVo> personVoList = getSchedulePersonListObjectId(objectId);
			if (CommonUtil.isNotEmpty(personVoList)) {
				return personInfoService.getPersonInfoName(personVoList.get(0).getPersonId());
			} else {
				return "";
			}
		}
	}

	private List<SchedulePerson> getSchedulePersonLeaderObjectId(String objectId) {
		SchedulePersonExample example = new SchedulePersonExample();
		SchedulePersonExample.Criteria criteria = example.createCriteria();
		criteria.andObjectIdEqualTo(objectId);
		criteria.andLeaderEqualTo(YES);
		return schedulePersonMapper.selectByExample(example);
	}

	public List<ScheduleConfig> getScheduleConfigList() {
		ScheduleConfigExample example = new ScheduleConfigExample();
		ScheduleConfigExample.Criteria criteria = example.createCriteria();
		return scheduleConfigMapper.selectByExample(example);
	}

	public void batchDelete(String idList) {
		idList = idList.trim();
		if (StringUtils.isEmpty(idList)) {
			return;
		}

		String[] ids = idList.split(",");
		for (String i : ids) {
			delete(i);
		}
	}

	public ResultVo setRepeatType(String id, String repeatType) {
		ScheduleConfig config = new ScheduleConfig();
		config.setId(id);
		config.setRepeatType(repeatType);
		scheduleConfigMapper.updateByPrimaryKeySelective(config);

		// 重新设置重复方式，必须重新生成日程，这比较麻烦
		// 所以不允许修改重复方式较好
		ScheduleConfig scheduleConfig = getScheduleConfigById(id);

		return ResultVo.ok();
	}

	private ScheduleConfig getScheduleConfigById(String id) {
		return scheduleConfigMapper.selectByPrimaryKey(id);
	}

}

