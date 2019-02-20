package com.microcore.center.service.impl;

import com.microcore.center.mapper.PsmScheduleConfigMapper;
import com.microcore.center.model.PsmScheduleConfig;
import com.microcore.center.model.PsmScheduleConfigExample;
import com.microcore.center.service.ScheduleConfigService;
import com.microcore.center.vo.PsmScheduleConfigVo;
import com.microcore.center.vo.ResultVo;
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
    public ResultVo getScheduleConfigList() {
        PsmScheduleConfigExample example = new PsmScheduleConfigExample();
        PsmScheduleConfigExample.Criteria criteria = example.createCriteria();
        List<PsmScheduleConfig> psmScheduleConfigs = psmScheduleConfigMapper.selectByExample(example);
        return ResultVo.ok(psmScheduleConfigs);
    }

}

