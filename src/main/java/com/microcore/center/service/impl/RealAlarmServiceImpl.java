package com.microcore.center.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.mapper.PsmRealAlarmMapper;
import com.microcore.center.model.PsmRealAlarm;
import com.microcore.center.model.PsmRealAlarmExample;
import com.microcore.center.service.RealAlarmService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.vo.PsmRealAlarmVo;
import com.microcore.center.vo.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.microcore.center.util.CommonUtil.getUUID;

@Service
@Transactional(rollbackFor = Exception.class)
public class RealAlarmServiceImpl implements RealAlarmService {

    @Autowired
    private PsmRealAlarmMapper psmRealAlarmMapper;

    @Override
    public PageInfo<PsmRealAlarmVo> getRealAlarmList(String alarmType, String operator, Integer pageIndex, Integer pageSize) {
        PsmRealAlarmExample example = new PsmRealAlarmExample();
        PsmRealAlarmExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(alarmType)) {
            criteria.andAlarmTypeEqualTo(alarmType);
        }

        PageInfo<PsmRealAlarm> realAlarmPageInfo = PageHelper.startPage(pageIndex, pageSize)
                .doSelectPageInfo(() -> psmRealAlarmMapper.selectByExample(example));

        List<PsmRealAlarmVo> list = CommonUtil.listPo2VO(realAlarmPageInfo.getList(), PsmRealAlarmVo.class);

        PageInfo<PsmRealAlarmVo> pageInfo = CommonUtil.po2VO(realAlarmPageInfo, PageInfo.class);
        pageInfo.setList(list);

        return pageInfo;
    }

    @Override
    public ResultVo delete(String id) {
        psmRealAlarmMapper.deleteByPrimaryKey(id);
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

}
