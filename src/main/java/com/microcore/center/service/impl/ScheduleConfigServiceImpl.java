package com.microcore.center.service.impl;

import com.github.pagehelper.PageInfo;
import com.microcore.center.mapper.PsmScheduleConfigMapper;
import com.microcore.center.model.PsmScheduleConfig;
import com.microcore.center.model.PsmScheduleConfigExample;
import com.microcore.center.model.PsmScheduleDetail;
import com.microcore.center.model.PsmUser;
import com.microcore.center.service.ScheduleConfigService;
import com.microcore.center.service.ScheduleDetailService;
import com.microcore.center.service.UserService;
import com.microcore.center.vo.PsmScheduleConfigVo;
import com.microcore.center.vo.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.github.pagehelper.page.PageMethod.startPage;
import static com.microcore.center.util.CommonUtil.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class ScheduleConfigServiceImpl implements ScheduleConfigService {

    @Autowired
    private PsmScheduleConfigMapper psmScheduleConfigMapper;

    @Autowired
    private ScheduleDetailService scheduleDetailService;

    @Autowired
    private UserService userService;

    @Override
    public ResultVo add(PsmScheduleConfigVo vo) {
        vo.setId(getUUID());
        psmScheduleConfigMapper.insert(vo);

        insertScheduleDetailList(vo);

        return ResultVo.ok();
    }

    private void insertScheduleDetailList(PsmScheduleConfig config) {
        List<PsmScheduleDetail> detailList = buildDetailList(config);
        if (detailList != null && detailList.size() > 0) {
            detailList.forEach(detail -> scheduleDetailService.addDetail(detail));
        }
    }

    private List<PsmScheduleDetail> buildDetailList(PsmScheduleConfig config) {
        List<PsmScheduleDetail> resultList = new ArrayList<>();

        if ("Y".equals(config.getSelectFlag())) {
            PsmScheduleDetail detail = buildDetail(config);
            resultList.add(detail);

            // 按重复周期生成后续日程
            List<PsmScheduleDetail> psmScheduleDetails = generateScheduleDetail(detail, config.getRepeatType());
            resultList.addAll(psmScheduleDetails);
        } else {
            List<PsmUser> userList = userService.getUserListByOrgId(config.getTeamId());
            if (userList != null && userList.size() > 0) {
                userList.forEach(user -> {
                    config.setObjectId(user.getId());
                    config.setRepeatType(user.getUsername());
                    PsmScheduleDetail detail = buildDetail(config);
                    resultList.add(detail);

                    // 按重复周期生成后续日程
                    List<PsmScheduleDetail> psmScheduleDetails = generateScheduleDetail(detail, config.getRepeatType());
                    resultList.addAll(psmScheduleDetails);
                });
            }
        }

        return resultList;
    }

    private PsmScheduleDetail buildDetail(PsmScheduleConfig config) {
        PsmScheduleDetail detail = new PsmScheduleDetail();

        detail.setObjectType(config.getObjectType());
        detail.setObjectId(config.getObjectId());

        detail.setNumber(config.getNumber());
        detail.setSomeDate(config.getSomeDate());
        detail.setStartTime(config.getStartTime());
        detail.setEndTime(config.getEndTime());
        detail.setAddress(config.getAddress());
        detail.setEvent(config.getEvent());
        detail.setTeacher(config.getTeacher());

        return detail;
    }

    @Override
    public ResultVo update(PsmScheduleConfigVo vo) {
        psmScheduleConfigMapper.updateByPrimaryKeySelective(vo);
        return ResultVo.ok();
    }

    @Override
    public ResultVo delete(String id) {
        psmScheduleConfigMapper.deleteByPrimaryKey(id);
        return ResultVo.ok();
    }

    @Override
    public ResultVo getScheduleConfigList(String team, Integer pageIndex, Integer pageSize) {
        PsmScheduleConfigExample example = new PsmScheduleConfigExample();
        PsmScheduleConfigExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(team)) {
            criteria.andObjectIdLike("%" + team + "%");
        }
        PageInfo<PsmScheduleConfig> scheduleConfigPageInfo = startPage(pageIndex, pageSize)
                .doSelectPageInfo(() -> psmScheduleConfigMapper.selectByExample(example));

        List<PsmScheduleConfig> configList = scheduleConfigPageInfo.getList();
        List<PsmScheduleConfigVo> configVos = listPo2VO(configList, PsmScheduleConfigVo.class);

        PageInfo<PsmScheduleConfigVo> scheduleConfigVoPageInfo = po2VO(scheduleConfigPageInfo, PageInfo.class);
        scheduleConfigVoPageInfo.setList(configVos);

        return ResultVo.ok(scheduleConfigVoPageInfo);
    }

    @Override
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

    private List<PsmScheduleDetail> generateScheduleDetail(PsmScheduleDetail detail, String repeatType) {
        List<PsmScheduleDetail> resultList = new ArrayList<>();

        if ("D".equals(repeatType)) {
            for (int i = 0; i < 10; i++) {
                Date tomorrow = addOneDay(detail.getSomeDate());
                detail.setSomeDate(tomorrow);

                resultList.add(detail);
            }
        } else if ("M".equals(repeatType)) {
            for (int i = 0; i < 10; i++) {
                Date nextMonth = addOneMonth(detail.getSomeDate());
                detail.setSomeDate(nextMonth);

                resultList.add(detail);
            }
        }

        return resultList;
    }

    @Override
    public ResultVo setRepeatType(String id, String repeatType) {
        PsmScheduleConfig config = new PsmScheduleConfig();
        config.setId(id);
        config.setRepeatType(repeatType);
        psmScheduleConfigMapper.updateByPrimaryKeySelective(config);

        PsmScheduleConfig scheduleConfig = getScheduleConfigById(id);
        insertScheduleDetailList(scheduleConfig);

        return ResultVo.ok();
    }

    private Date addOneMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 1);  // 今天+1天
        return c.getTime();
    }

    private Date addOneDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, 1);  // 今天+1天
        return c.getTime();
    }

    private PsmScheduleConfig getScheduleConfigById(String id) {
        return psmScheduleConfigMapper.selectByPrimaryKey(id);
    }

}

