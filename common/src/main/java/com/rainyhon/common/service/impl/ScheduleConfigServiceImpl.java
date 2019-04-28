package com.rainyhon.common.service.impl;

import com.github.pagehelper.PageInfo;
import com.microcore.center.model.PsmUser;
import com.rainyhon.common.mapper.ScheduleConfigMapper;
import com.rainyhon.common.model.ScheduleConfig;
import com.rainyhon.common.model.ScheduleConfigExample;
import com.rainyhon.common.model.ScheduleDetail;
import com.rainyhon.common.service.ParaDefineService;
import com.rainyhon.common.service.ScheduleConfigService;
import com.rainyhon.common.service.ScheduleDetailService;
import com.rainyhon.common.service.PsmUserService;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.vo.ScheduleConfigVo;
import com.rainyhon.common.vo.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.github.pagehelper.page.PageMethod.startPage;
import static com.rainyhon.common.util.CommonUtil.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class ScheduleConfigServiceImpl implements ScheduleConfigService {

    @Autowired
    private ScheduleConfigMapper scheduleConfigMapper;

    @Autowired
    private ScheduleDetailService scheduleDetailService;

    @Autowired
    private PsmUserService psmUserService;

    @Autowired
    private ParaDefineService paraDefineService;

    @Override
    public ResultVo add(ScheduleConfigVo vo) {
        vo.setId(getUUID());
        scheduleConfigMapper.insert(vo);

        // TODO
        // insertScheduleDetailList(vo);

        return ResultVo.ok();
    }

    private void insertScheduleDetailList(ScheduleConfig config) {
        List<ScheduleDetail> detailList = buildDetailList(config);
        if (detailList != null && detailList.size() > 0) {
            detailList.forEach(detail -> scheduleDetailService.addDetail(detail));
        }
    }

    private List<ScheduleDetail> buildDetailList(ScheduleConfig config) {
        List<ScheduleDetail> resultList = new ArrayList<>();

        if ("Y".equals(config.getSelectFlag())) {
            ScheduleDetail detail = buildDetail(config);
            resultList.add(detail);

            // 按重复周期生成后续日程
            List<ScheduleDetail> psmScheduleDetails = generateScheduleDetail(detail, config.getRepeatType());
            resultList.addAll(psmScheduleDetails);
        } else {
            List<PsmUser> userList = psmUserService.getUserListByOrgId(config.getTeamId());
            if (userList != null && userList.size() > 0) {
                userList.forEach(user -> {
                    config.setObjectId(user.getId());
                    config.setRepeatType(user.getUsername());
                    ScheduleDetail detail = buildDetail(config);
                    resultList.add(detail);

                    // 按重复周期生成后续日程
                    List<ScheduleDetail> psmScheduleDetails = generateScheduleDetail(detail, config.getRepeatType());
                    resultList.addAll(psmScheduleDetails);
                });
            }
        }

        return resultList;
    }

    private ScheduleDetail buildDetail(ScheduleConfig config) {
        ScheduleDetail detail = new ScheduleDetail();

        detail.setObjectType(config.getObjectType());
        detail.setObjectId(config.getObjectId());

        detail.setNumber(config.getNumber());
        detail.setSomeDate(config.getSomeDate());
        detail.setStartTime(config.getStartTime());
        detail.setEndTime(config.getEndTime());
        detail.setAddress(config.getAddress());
        detail.setTitle(config.getTitle());
        detail.setContent(config.getContent());
        detail.setTeacher(config.getTeacher());

        return detail;
    }

    @Override
    public ResultVo update(ScheduleConfigVo vo) {
        scheduleConfigMapper.updateByPrimaryKeySelective(vo);
        return ResultVo.ok();
    }

    @Override
    public ResultVo delete(String id) {
        scheduleConfigMapper.deleteByPrimaryKey(id);
        return ResultVo.ok();
    }

    @Override
    public ResultVo getScheduleConfigList(String team, Integer pageIndex, Integer pageSize) {
        ScheduleConfigExample example = new ScheduleConfigExample();
        ScheduleConfigExample.Criteria criteria = example.createCriteria();
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
            });
        }

        PageInfo<ScheduleConfigVo> scheduleConfigVoPageInfo = po2VO(scheduleConfigPageInfo, PageInfo.class);
        scheduleConfigVoPageInfo.setList(configVos);

        return ResultVo.ok(scheduleConfigVoPageInfo);
    }

    @Override
    public List<ScheduleConfig> getScheduleConfigList() {
        ScheduleConfigExample example = new ScheduleConfigExample();
        ScheduleConfigExample.Criteria criteria = example.createCriteria();
	    List<ScheduleConfig> configList = scheduleConfigMapper.selectByExample(example);
        return configList;
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

    private List<ScheduleDetail> generateScheduleDetail(ScheduleDetail detail, String repeatType) {
        List<ScheduleDetail> resultList = new ArrayList<>();

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
        } else if ("W".equals(repeatType)) {
            for (int i = 0; i < 10; i++) {
                Date nextMonth = addOneWeek(detail.getSomeDate());
                detail.setSomeDate(nextMonth);

                resultList.add(detail);
            }
        } else if ("Y".equals(repeatType)) {
            for (int i = 0; i < 10; i++) {
                Date nextMonth = addOneYear(detail.getSomeDate());
                detail.setSomeDate(nextMonth);

                resultList.add(detail);
            }
        } else if ("N".equals(repeatType)) {
            // do nothing
        }

        return resultList;
    }

    @Override
    public ResultVo setRepeatType(String id, String repeatType) {
        ScheduleConfig config = new ScheduleConfig();
        config.setId(id);
        config.setRepeatType(repeatType);
        scheduleConfigMapper.updateByPrimaryKeySelective(config);

        ScheduleConfig scheduleConfig = getScheduleConfigById(id);
        // TODO
        // insertScheduleDetailList(scheduleConfig);

        return ResultVo.ok();
    }

    private Date addOneYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR, 1);
        return c.getTime();
    }

    private Date addOneMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 1);
        return c.getTime();
    }

    private Date addOneWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.WEEK_OF_MONTH, 1);
        return c.getTime();
    }

    private Date addOneDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, 1);  // 今天+1天
        return c.getTime();
    }

    private ScheduleConfig getScheduleConfigById(String id) {
        return scheduleConfigMapper.selectByPrimaryKey(id);
    }

}

