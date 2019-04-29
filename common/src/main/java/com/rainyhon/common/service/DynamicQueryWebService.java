package com.rainyhon.common.service;

import com.rainyhon.common.mapper.DynamicQueryWebMapper;
import com.rainyhon.common.model.DynamicQueryWeb;
import com.rainyhon.common.model.DynamicQueryWebExample;
import com.rainyhon.common.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DynamicQueryWebService {

    @Autowired
    private DynamicQueryWebMapper mapper;

    public ResultVo add(DynamicQueryWeb record) {
        mapper.insertSelective(record);
        return ResultVo.ok();
    }

    public ResultVo delete(String dqId) {
        DynamicQueryWebExample example = new DynamicQueryWebExample();
        DynamicQueryWebExample.Criteria criteria = example.createCriteria();
        criteria.andDqIdEqualTo(dqId);
        mapper.deleteByExample(example);
        return ResultVo.ok();
    }

    public DynamicQueryWeb findOneByDQId(String dqId) {
        DynamicQueryWebExample example = new DynamicQueryWebExample();
        DynamicQueryWebExample.Criteria criteria = example.createCriteria();
        criteria.andDqIdEqualTo(dqId);
        List<DynamicQueryWeb> list = mapper.selectByExampleWithBLOBs(example);
        // 暂时认为是一对一的
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}