package com.microcore.center.service.impl;

import com.microcore.center.mapper.PsmScheduleDetailMapper;
import com.microcore.center.model.PsmScheduleDetail;
import com.microcore.center.model.PsmScheduleDetailExample;
import com.microcore.center.service.ScheduleDetailService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.vo.PsmScheduleDetailVo;
import com.microcore.center.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ScheduleDetailServiceImpl implements ScheduleDetailService {

    @Autowired
    private PsmScheduleDetailMapper psmScheduleDetailMapper;

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
        PsmScheduleDetailExample.Criteria criteria = example.createCriteria();
        criteria.andObjectTypeLike("%" + objectType.trim() + "%");
        List<PsmScheduleDetail> psmScheduleDetails = psmScheduleDetailMapper.selectByExample(example);
        return ResultVo.ok(psmScheduleDetails);
    }

}

