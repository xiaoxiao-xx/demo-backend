package com.microcore.center.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.mapper.PsmScheduleConfigMapper;
import com.microcore.center.model.PsmScheduleConfig;
import com.microcore.center.model.PsmScheduleConfigExample;
import com.microcore.center.service.ScheduleConfigService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.vo.PsmScheduleConfigVo;
import com.microcore.center.vo.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.microcore.center.util.CommonUtil.getUUID;

@Service
@Transactional
public class ScheduleConfigServiceImpl implements ScheduleConfigService {

    @Autowired
    private PsmScheduleConfigMapper psmScheduleConfigMapper;

    @Override
    public ResultVo add(PsmScheduleConfigVo vo) {
        vo.setId(getUUID());
        psmScheduleConfigMapper.insert(vo);
        return ResultVo.ok();
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
    public ResultVo getScheduleConfigList(Integer pageIndex, Integer pageSize) {
        PsmScheduleConfigExample example = new PsmScheduleConfigExample();
        PsmScheduleConfigExample.Criteria criteria = example.createCriteria();

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

}

