package com.microcore.center.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.mapper.PsmRealAlarmMapper;
import com.microcore.center.model.PsmRealAlarm;
import com.microcore.center.model.PsmRealAlarmExample;
import com.microcore.center.service.CommonService;
import com.microcore.center.service.ParaDefineService;
import com.microcore.center.service.RealAlarmService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.vo.PsmRealAlarmVo;
import com.microcore.center.vo.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.microcore.center.util.CommonUtil.getUUID;

@Service
@Transactional(rollbackFor = Exception.class)
public class RealAlarmServiceImpl implements RealAlarmService {

    @Autowired
    private PsmRealAlarmMapper psmRealAlarmMapper;

    @Autowired
    private ParaDefineService paraDefineService;

    @Autowired
    private CommonService commonService;

    @Override
    public PageInfo<PsmRealAlarmVo> getRealAlarmList(String alarmType, String operator, String state,
                                                     Integer pageIndex, Integer pageSize) {
        PsmRealAlarmExample example = new PsmRealAlarmExample();
        example.setOrderByClause("trigger_time desc");
        PsmRealAlarmExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(alarmType)) {
            criteria.andAlarmTypeEqualTo(alarmType);
        }
        if (StringUtils.isNotEmpty(operator)) {
            criteria.andOperatorEqualTo(operator);
        }
        if (StringUtils.isNotEmpty(state)) {
            criteria.andStateEqualTo(state);
        }

        PageInfo<PsmRealAlarm> realAlarmPageInfo = PageHelper.startPage(pageIndex, pageSize)
                .doSelectPageInfo(() -> psmRealAlarmMapper.selectByExample(example));

        List<PsmRealAlarmVo> list = CommonUtil.listPo2VO(realAlarmPageInfo.getList(), PsmRealAlarmVo.class);
        for (PsmRealAlarmVo psmRealAlarmVo : list) {
            psmRealAlarmVo.setStateName(paraDefineService.getValueByTypeAnd("REAL_ALARM_STATE", psmRealAlarmVo.getState()));
            psmRealAlarmVo.setAlarmTypeName(paraDefineService.getValueByTypeAnd("ALARM_MODE", psmRealAlarmVo.getAlarmType()));
        }
        PageInfo<PsmRealAlarmVo> pageInfo = new PageInfo<>();

        pageInfo.setList(list);
        pageInfo.setTotal(realAlarmPageInfo.getTotal());
        return pageInfo;
    }

    @Override
    public PageInfo<PsmRealAlarmVo> getRealAlarmList2(String alarmType, String operator, String state,
                                                      Integer pageIndex, Integer pageSize) {

        String sql = "SELECT\n" +
                "\t*, \n" +
                "\tDATE_FORMAT( psm_real_alarm_t.trigger_time, '%Y-%m-%d %H-%i' ) group_string \n" +
                " FROM\n" +
                "\tpsm_real_alarm_t \n" +
                "GROUP BY\n" +
                "\tDATE_FORMAT( psm_real_alarm_t.trigger_time, '%Y-%m-%d %H-%i' ) \n" +
                "ORDER BY \n" +
                "\ttrigger_time DESC limit 5";
        Map<String, Object> params = new HashMap<>(3);
        params.put("sql", sql);

        List<Map<String, Object>> maps = commonService.executeSelectSQL(params);

        List<PsmRealAlarmVo> list = CommonUtil.map2PO(maps, PsmRealAlarmVo.class);
        for (PsmRealAlarmVo psmRealAlarmVo : list) {
            psmRealAlarmVo.setStateName(paraDefineService.getValueByTypeAnd("REAL_ALARM_STATE", psmRealAlarmVo.getState()));
            psmRealAlarmVo.setAlarmTypeName(paraDefineService.getValueByTypeAnd("ALARM_MODE", psmRealAlarmVo.getAlarmType()));
        }
        PageInfo<PsmRealAlarmVo> pageInfo = new PageInfo<>();

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
    public ResultVo update(PsmRealAlarmVo vo) {
        PsmRealAlarm realAlarm = CommonUtil.po2VO(vo, PsmRealAlarm.class);
        psmRealAlarmMapper.updateByPrimaryKey(realAlarm);

        return ResultVo.ok();
    }

    @Override
    public ResultVo add(PsmRealAlarmVo vo) {
        PsmRealAlarm realAlarm = CommonUtil.po2VO(vo, PsmRealAlarm.class);
        realAlarm.setId(getUUID());
        psmRealAlarmMapper.insert(realAlarm);

        return ResultVo.ok();
    }

    @Override
    public ResultVo dealRealAlarm(PsmRealAlarmVo vo) {
        PsmRealAlarm psmRealAlarm = psmRealAlarmMapper.selectByPrimaryKey(vo.getId());
        psmRealAlarm.setRemark(vo.getRemark());
        psmRealAlarm.setState(vo.getState());
        psmRealAlarm.setOperator(CommonUtil.getCurrentUserId());
        psmRealAlarmMapper.updateByPrimaryKey(psmRealAlarm);
        return ResultVo.ok();
    }

    @Override
    public ResultVo getAlarmCount() {
        Map<String, Object> prams = new HashMap<>();
        String sql = "SELECT alarm_type, count( * ) count, p.para_value " +
                "FROM psm_real_alarm_t " +
                "LEFT JOIN psm_para_define_t p ON alarm_type = p.para_code AND p.para_type = 'ALARM_MODE' " +
                "GROUP BY alarm_type;";
        prams.put("sql", sql);
        List<Map<String, Object>> list = commonService.executeSelectSQL(prams);
        return ResultVo.ok(list);
    }

}
