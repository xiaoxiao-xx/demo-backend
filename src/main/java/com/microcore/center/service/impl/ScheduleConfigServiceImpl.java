package com.microcore.center.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.mapper.PsmScheduleConfigMapper;
import com.microcore.center.model.PsmScheduleConfig;
import com.microcore.center.model.PsmScheduleConfigExample;
import com.microcore.center.model.PsmScheduleDetail;
import com.microcore.center.service.ScheduleConfigService;
import com.microcore.center.service.ScheduleDetailService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.vo.PsmScheduleConfigVo;
import com.microcore.center.vo.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.microcore.center.util.CommonUtil.getUUID;

@Service
@Transactional
public class ScheduleConfigServiceImpl implements ScheduleConfigService {

    @Autowired
    private PsmScheduleConfigMapper psmScheduleConfigMapper;

    @Autowired
    private ScheduleDetailService scheduleDetailService;

    @Override
    public ResultVo add(PsmScheduleConfigVo vo) {
        vo.setId(getUUID());
        psmScheduleConfigMapper.insert(vo);

        PsmScheduleDetail detail = buildDetail(vo);
        scheduleDetailService.addDetail(detail);

        return ResultVo.ok();
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
        PageInfo<PsmScheduleConfig> scheduleConfigPageInfo = PageHelper.startPage(pageIndex, pageSize)
                .doSelectPageInfo(() -> psmScheduleConfigMapper.selectByExample(example));

        List<PsmScheduleConfig> configList = scheduleConfigPageInfo.getList();
        List<PsmScheduleConfigVo> configVos = CommonUtil.listPo2VO(configList, PsmScheduleConfigVo.class);

        PageInfo<PsmScheduleConfigVo> scheduleConfigVoPageInfo = CommonUtil.po2VO(scheduleConfigPageInfo, PageInfo.class);
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

    @Override
    public ResultVo setRepeatType(String id, String repeatType) {
        PsmScheduleConfig config = new PsmScheduleConfig();
        config.setId(id);
        config.setRepeatType(repeatType);
        psmScheduleConfigMapper.updateByPrimaryKeySelective(config);

        PsmScheduleConfig scheduleConfig = getScheduleConfigById(id);

        PsmScheduleDetail detail = buildDetail(config);
        if ("D".equals(repeatType)) {
            for (int i = 0; i < 10; i++) {
                Date tomorrow = addOneDay(detail.getSomeDate());
                detail.setSomeDate(tomorrow);

                scheduleDetailService.addDetail(detail);
            }
        } else if ("M".equals(repeatType)) {
            for (int i = 0; i < 10; i++) {
                Date nextMonth = addOneMonth(detail.getSomeDate());
                detail.setSomeDate(nextMonth);

                scheduleDetailService.addDetail(detail);
            }
        }

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

