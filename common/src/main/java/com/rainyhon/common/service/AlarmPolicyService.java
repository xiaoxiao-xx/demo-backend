package com.rainyhon.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rainyhon.common.mapper.AlarmPolicyMapper;
import com.rainyhon.common.model.AlarmPolicy;
import com.rainyhon.common.model.AlarmPolicyExample;
import com.rainyhon.common.service.AlarmModeService;
import com.rainyhon.common.service.ParaDefineService;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.StringUtil;
import com.rainyhon.common.vo.AlarmPolicyOpt;
import com.rainyhon.common.vo.AlarmPolicyVo;
import com.rainyhon.common.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class AlarmPolicyService {

    public static final String SPLIT_TIME_PERIOD = " - ";

    public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private AlarmPolicyMapper psmAlarmPolicyMapper;

    @Autowired
    private ParaDefineService paraDefineService;

    @Autowired
    private AlarmModeService alarmModeService;

    public ResultVo add(AlarmPolicy alarmPolicy) throws ParseException {
        alarmPolicy.setId(CommonUtil.getUUID());
        alarmPolicy.setDelStatus(DelStatus.NotDelete);
        // 00:00:00 - 00:00:00
        alarmPolicy.setBeginTime(TIME_FORMAT.parse(alarmPolicy.getTimePeriod()[0]));
        alarmPolicy.setEndTime(TIME_FORMAT.parse(alarmPolicy.getTimePeriod()[1]));
        alarmPolicy.setCrtTm(new Date());
        alarmPolicy.setUpdTm(new Date());
        psmAlarmPolicyMapper.insertSelective(alarmPolicy);
        return ResultVo.ok();
    }

    public ResultVo update(AlarmPolicyVo alarmPolicyVo) {
        AlarmPolicy p = CommonUtil.po2VO(alarmPolicyVo, AlarmPolicy.class);
        psmAlarmPolicyMapper.updateByPrimaryKey(p);
        return ResultVo.ok();
    }

    public ResultVo delete(String id) {
        String[] ids = id.split(",");
        for (String i : ids) {
            psmAlarmPolicyMapper.deleteByPrimaryKey(i);
        }
        return ResultVo.ok();
    }

    public PageInfo<AlarmPolicyVo> page(String alarmType, String strategy, Integer pageIndex, Integer pageSize) {
        AlarmPolicyExample example = new AlarmPolicyExample();
        AlarmPolicyExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(alarmType)) {
            criteria.andAlarmTypeEqualTo(alarmType);
        }
        if (StringUtil.isNotEmpty(strategy)) {
            criteria.andPolicyNameLike("%" + strategy.trim() + "%");
        }
        PageInfo<AlarmPolicy> psmAlarmPolicyPage = PageHelper.startPage(pageIndex, pageSize)
                .doSelectPageInfo(() -> psmAlarmPolicyMapper.selectByExample(example));
        List<AlarmPolicyVo> list = new ArrayList<>();
        for (AlarmPolicy psmAlarmPolicy : psmAlarmPolicyPage.getList()) {
            AlarmPolicyVo vo = new AlarmPolicyVo();
            BeanUtils.copyProperties(psmAlarmPolicy, vo);
            vo.setAlarmTypeName(paraDefineService.getValueByTypeAnd("ALARM_MODE", psmAlarmPolicy.getAlarmType()));
            vo.setAlarmModeName(alarmModeService.getAlarmMode(psmAlarmPolicy.getAlarmModeId()));
            list.add(vo);
        }
        PageInfo<AlarmPolicyVo> pageInfo = new PageInfo<>();
        pageInfo.setList(list);
        pageInfo.setTotal(psmAlarmPolicyPage.getTotal());
        return pageInfo;
    }

    public ResultVo startStop(AlarmPolicyOpt alarmPolicyOpt) {
        AlarmPolicy p = psmAlarmPolicyMapper.selectByPrimaryKey(alarmPolicyOpt.getId());
        p.setState(alarmPolicyOpt.getOpt());
        psmAlarmPolicyMapper.updateByPrimaryKey(p);
        return ResultVo.ok();
    }

    public ResultVo getAllEnableAlarmPolicy() {
        AlarmPolicyExample example = new AlarmPolicyExample();
        AlarmPolicyExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo(State.Enabled);
        criteria.andDelStatusEqualTo(DelStatus.NotDelete);
        List<AlarmPolicy> list = psmAlarmPolicyMapper.selectByExample(example);
        return ResultVo.ok(list);
    }

    /**
     * 启用状态
     *
     * @return
     */
    public ResultVo getState() {
        Map<String, String> map = new HashMap<>();
        map.put(State.Disable, "禁用");
        map.put(State.Enabled, "启用");
        return ResultVo.ok(map);
    }

    /**
     * 删除状态
     *
     * @return
     */
    public ResultVo getDelStatus() {
        Map<String, String> map = new HashMap<>();
        map.put(DelStatus.NotDelete, "未删除");
        map.put(DelStatus.Deleted, "已删除");
        return ResultVo.ok(map);
    }

    /**
     * 对象类型
     *
     * @return
     */
    public ResultVo getObjectType() {
        Map<String, String> map = new HashMap<>();
        map.put(ObjectType.TeamMember, "团队成员");
        map.put(ObjectType.Visitor, "访客");
        map.put(ObjectType.Stranger, "陌生人");
        return ResultVo.ok(map);
    }

    /**
     * 告警方式
     *
     * @return
     */
    public ResultVo getAlarmModel() {
        Map<String, String> map = new HashMap<>();
        map.put("0", "邮件告警");
        map.put("1", "系统告警");
        map.put("1", "声音告警");
        return ResultVo.ok(map);
    }

    /**
     * 告警类型
     *
     * @return
     */
    public ResultVo getAlarmType() {
        Map<String, String> map = new HashMap<>();
        map.put("0", "考勤");
        map.put("1", "值班");
        return ResultVo.ok(map);
    }

    /**
     * 告警级别
     *
     * @return
     */
    public ResultVo getAlarmLevel() {
        Map<String, String> map = new HashMap<>();
        map.put("0", "一般");
        map.put("1", "轻微");
        map.put("2", "严重");
        return ResultVo.ok(map);
    }

    /**
     * 告警区域
     *
     * @return
     */
    public ResultVo getAlarmAddress() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "A入口");
        map.put("2", "B入口");
        map.put("3", "工作区");
        map.put("4", "会议室");
        map.put("5", "总经理室");
        return ResultVo.ok(map);
    }

    /**
     * 启用 禁用状态
     */
    public static class State {

        /**
         * 禁用
         */
        public static final String Disable = "0";

        /**
         * 启用
         */
        public static final String Enabled = "1";

    }

    /**
     * 逻辑删除
     */
    public static class DelStatus {
        /**
         * 已删除
         */
        public static final String NotDelete = "0";

        /**
         * 未删除
         */
        public static final String Deleted = "1";

    }

    /**
     * 对象类型
     */
    public static class ObjectType {
        /**
         * 团队成员
         */
        public static final String TeamMember = "0";
        /**
         * 访客
         */
        public static final String Visitor = "1";
        /**
         * 陌生人
         */
        public static final String Stranger = "2";
    }


}
