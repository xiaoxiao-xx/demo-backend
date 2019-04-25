package com.rainyhon.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.mapper.AlarmResultMapper;
import com.microcore.center.model.AlarmResult;
import com.microcore.center.model.AlarmResultExample;
import com.rainyhon.common.service.CommonService;
import com.rainyhon.common.service.ParaDefineService;
import com.rainyhon.common.service.AlarmResultService;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.vo.AlarmResultVo;
import com.rainyhon.common.vo.ResultVo;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.rainyhon.common.util.CommonUtil.getUUID;

@Service
@Transactional(rollbackFor = Exception.class)
public class AlarmResultServiceImpl implements AlarmResultService {

    @Autowired
    private AlarmResultMapper psmRealAlarmMapper;

    @Autowired
    private ParaDefineService paraDefineService;

    @Autowired
    private CommonService commonService;

    @Override
    public PageInfo<AlarmResultVo> getRealAlarmList(String alarmType, String operator, String state,
                                                    Integer pageIndex, Integer pageSize) {
        AlarmResultExample example = new AlarmResultExample();
        example.setOrderByClause("trigger_time desc");
        AlarmResultExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(alarmType)) {
            criteria.andAlarmModeTypeEqualTo(alarmType);
        }
        if (StringUtils.isNotEmpty(operator)) {
            criteria.andOperatorEqualTo(operator);
        }
        if (StringUtils.isNotEmpty(state)) {
            criteria.andStateEqualTo(state);
        }

        PageInfo<AlarmResult> realAlarmPageInfo = PageHelper.startPage(pageIndex, pageSize)
                .doSelectPageInfo(() -> psmRealAlarmMapper.selectByExample(example));

        List<AlarmResultVo> list = CommonUtil.listPo2VO(realAlarmPageInfo.getList(), AlarmResultVo.class);
        for (AlarmResultVo alarmResultVo : list) {
            alarmResultVo.setStateName(paraDefineService.getValueByTypeAnd("REAL_ALARM_STATE", alarmResultVo.getState()));
            alarmResultVo.setAlarmTypeName(paraDefineService.getValueByTypeAnd("ALARM_MODE", alarmResultVo.getAlarmModeType()));
        }
        PageInfo<AlarmResultVo> pageInfo = new PageInfo<>();

        pageInfo.setList(list);
        pageInfo.setTotal(realAlarmPageInfo.getTotal());
        return pageInfo;
    }

    @Override
    public PageInfo<AlarmResultVo> getRealAlarmList2(String alarmType, String operator, String state,
                                                     Integer pageIndex, Integer pageSize) {
        String sql = "SELECT *, \n" +
                "DATE_FORMAT( psm_real_alarm_t.trigger_time, '%Y-%m-%d %H-%i' ) group_string \n" +
                "FROM psm_real_alarm_t \n" +
                "GROUP BY DATE_FORMAT(psm_real_alarm_t.trigger_time, '%Y-%m-%d %H-%i') \n" +
                "ORDER BY trigger_time DESC \n" +
		        "LIMIT 5";
        Map<String, Object> params = new HashMap<>(3);
        params.put("sql", sql);

        List<Map<String, Object>> maps = commonService.executeSelectSQL(params);

        List<AlarmResultVo> list = CommonUtil.map2PO(maps, AlarmResultVo.class);
        for (AlarmResultVo alarmResultVo : list) {
            alarmResultVo.setStateName(paraDefineService.getValueByTypeAnd("REAL_ALARM_STATE", alarmResultVo.getState()));
            alarmResultVo.setAlarmTypeName(paraDefineService.getValueByTypeAnd("ALARM_MODE", alarmResultVo.getAlarmModeType()));
        }
        PageInfo<AlarmResultVo> pageInfo = new PageInfo<>();

        pageInfo.setList(list);
        pageInfo.setTotal(list.size());
        return pageInfo;
    }

    @Override
    public ResultVo delete(String id) {
        String[] ids = id.split(",");
        for (String i : ids) {
            psmRealAlarmMapper.deleteByPrimaryKey(i);
        }

        return ResultVo.ok();
    }

    @Override
    public ResultVo update(AlarmResultVo vo) {
        AlarmResult realAlarm = CommonUtil.po2VO(vo, AlarmResult.class);
        psmRealAlarmMapper.updateByPrimaryKey(realAlarm);

        return ResultVo.ok();
    }

    @Override
    public ResultVo add(AlarmResultVo vo) {
        AlarmResult realAlarm = CommonUtil.po2VO(vo, AlarmResult.class);
        realAlarm.setId(getUUID());
        psmRealAlarmMapper.insert(realAlarm);

        return ResultVo.ok();
    }

    @Override
    public ResultVo dealRealAlarm(AlarmResultVo vo) {
        AlarmResult psmRealAlarm = psmRealAlarmMapper.selectByPrimaryKey(vo.getId());
        psmRealAlarm.setRemark(vo.getRemark());
        psmRealAlarm.setState(vo.getState());
        psmRealAlarm.setOperator(CommonUtil.getCurrentUserId());
        psmRealAlarmMapper.updateByPrimaryKey(psmRealAlarm);
        return ResultVo.ok();
    }

    @Override
    public ResultVo getAlarmCount() {
        String sql = "SELECT alarm_type, count( * ) count, p.para_value " +
                "FROM psm_real_alarm_t " +
                "LEFT JOIN psm_para_define_t p ON alarm_type = p.para_code AND p.para_type = 'ALARM_MODE' " +
                "GROUP BY alarm_type;";
        Map<String, Object> prams = new HashMap<>();
        prams.put("sql", sql);
        List<Map<String, Object>> list = commonService.executeSelectSQL(prams);
        return ResultVo.ok(list);
    }

	@Override

	public ResultVo getAlarmStateInfo() {
        String sql = "select state, count(id) count from psm_real_alarm_t GROUP BY state";

		Map<String, Object> prams = new HashMap<>();
		prams.put("sql", sql);
		List<Map<String, Object>> list = commonService.executeSelectSQL(prams);
		List<AlarmState> alarmStates = CommonUtil.map2PO(list, AlarmState.class);

		Long totalCount = 0L;
		Long unprocessed = 0L;
		Map<String, Long> resultMap = new HashMap<>();
		for (AlarmState alarmState : alarmStates) {
			totalCount += alarmState.getCount();

			if (alarmState.getState().equals("0")) {
				resultMap.put("unprocessed", alarmState.getCount());
				unprocessed = alarmState.getCount();
			}
		}

		resultMap.put("totalCount", totalCount);
		resultMap.put("precessed", totalCount - unprocessed);

		return ResultVo.ok(resultMap);
	}

	/**
	 * Notice: the modifier of the class must be public
	 */
	@Data
	public static class AlarmState {

    	private String state;

    	private Long count;

    }

}
