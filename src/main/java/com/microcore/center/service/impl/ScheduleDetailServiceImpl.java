package com.microcore.center.service.impl;

import com.microcore.center.mapper.PsmScheduleDetailMapper;
import com.microcore.center.model.PsmDeptInfo;
import com.microcore.center.model.PsmScheduleDetail;
import com.microcore.center.model.PsmScheduleDetailExample;
import com.microcore.center.service.DepartmentService;
import com.microcore.center.service.ScheduleDetailService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.vo.PsmScheduleDetailVo;
import com.microcore.center.vo.ResultVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ScheduleDetailServiceImpl implements ScheduleDetailService {

    @Autowired
    private PsmScheduleDetailMapper psmScheduleDetailMapper;

    @Autowired
    private DepartmentService departmentService;

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

    @Data
    @EqualsAndHashCode(callSuper = false)
    public static class Duty {
        Duty() {

        }

        Duty(String leaderName, String onDutyPerson, List<TeamStat> statList) {
            setLeaderName(leaderName);
            setOnDutyPerson(onDutyPerson);
            setStatList(statList);
        }

        private String leaderName;

        private String onDutyPerson;

        private List<TeamStat> statList;

    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    private static class TeamStat {
        TeamStat() {

        }

        TeamStat(String teamName, Integer totalCount, Integer onDutyCount) {
            setTeamName(teamName);
            setTotalCount(totalCount);
            setOnDutyCount(onDutyCount);
        }

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

    @Override
    public ResultVo getOnDutyData() {
        List<TeamStat> statList = new ArrayList<>(3);
        PsmDeptInfo departmentC = departmentService.getDepartment("0");
        PsmDeptInfo departmentA = departmentService.getDepartment("1");
        PsmDeptInfo departmentB = departmentService.getDepartment("2");
        PsmDeptInfo departmentD = departmentService.getDepartment("3");

        statList.add(new TeamStat(departmentA.getDeptName(), 23, 23));
        statList.add(new TeamStat(departmentB.getDeptName(), 17, 14));
        statList.add(new TeamStat(departmentC.getDeptName(), 127, 126));
        statList.add(new TeamStat(departmentD.getDeptName(), 234, 229));
        Duty duty = new Duty("王志", "程开甲", statList);
        return ResultVo.ok(duty);
    }

}

