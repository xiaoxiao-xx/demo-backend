package com.rainyhon.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rainyhon.common.mapper.AlarmPolicyMapper;
import com.rainyhon.common.model.AlarmPolicy;
import com.rainyhon.common.model.AlarmPolicyExample;
import com.rainyhon.common.service.AlarmModeService;
import com.rainyhon.common.service.AlarmPolicyService;
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

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AlarmPolicyServiceImpl implements AlarmPolicyService {

    @Autowired
    private AlarmPolicyMapper psmAlarmPolicyMapper;

    @Autowired
    private ParaDefineService paraDefineService;

    @Autowired
    private AlarmModeService alarmModeService;

    @Override
    public ResultVo add(AlarmPolicyVo alarmPolicyVo) {
        AlarmPolicy p = CommonUtil.po2VO(alarmPolicyVo, AlarmPolicy.class);
        p.setId(CommonUtil.getUUID());
        psmAlarmPolicyMapper.insertSelective(p);
        return ResultVo.ok();
    }

    @Override
    public ResultVo update(AlarmPolicyVo alarmPolicyVo) {
        AlarmPolicy p = CommonUtil.po2VO(alarmPolicyVo, AlarmPolicy.class);
        psmAlarmPolicyMapper.updateByPrimaryKey(p);
        return ResultVo.ok();
    }

    @Override
    public ResultVo delete(String id) {
        String[] ids = id.split(",");
        for (String i : ids) {
            psmAlarmPolicyMapper.deleteByPrimaryKey(i);
        }
        return ResultVo.ok();
    }

    @Override
    public PageInfo<AlarmPolicyVo> query(String alarmType, String strategy, Integer pageIndex, Integer pageSize) {
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

    @Override
    public ResultVo startStop(AlarmPolicyOpt alarmPolicyOpt) {
        AlarmPolicy p = psmAlarmPolicyMapper.selectByPrimaryKey(alarmPolicyOpt.getId());
        p.setState(alarmPolicyOpt.getOpt());
        psmAlarmPolicyMapper.updateByPrimaryKey(p);
        return ResultVo.ok();
    }

    @Override
    public ResultVo getAllEnableAlarmPolicy() {
        AlarmPolicyExample example = new AlarmPolicyExample();
        AlarmPolicyExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo(State.Enabled);
        criteria.andDelStatusEqualTo(DelStatus.NotDelete);
        List<AlarmPolicy> list = psmAlarmPolicyMapper.selectByExample(example);
        return ResultVo.ok(list);
    }

    public List<String> getState() {
        List<String> list = new ArrayList<>();
        list.add(State.Disable);
        list.add(State.Enabled);
        return list;
    }

    public List<String> getDelStatus() {
        List<String> list = new ArrayList<>();
        list.add(DelStatus.NotDelete);
        list.add(DelStatus.Deleted);
        return list;
    }

    public List<String> getObjectType() {
        List<String> list = new ArrayList<>();
        list.add(ObjectType.TeamMember);
        list.add(ObjectType.Visitor);
        list.add(ObjectType.Stranger);
        return list;
    }

    /**
     * 启用 禁用状态
     */
    public class State {

        public static final String Disable = "0";

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
    public class ObjectType {
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
