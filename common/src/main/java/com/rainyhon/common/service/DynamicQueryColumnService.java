package com.rainyhon.common.service;

import com.rainyhon.common.mapper.DynamicQueryColumnMapper;
import com.rainyhon.common.model.DynamicQueryColumn;
import com.rainyhon.common.model.DynamicQueryColumnExample;
import com.rainyhon.common.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DynamicQueryColumnService {

    @Autowired
    private DynamicQueryColumnMapper mapper;

    public List<DynamicQueryColumn> findOneByDQId(String dqId) {
        DynamicQueryColumnExample example = new DynamicQueryColumnExample();
        DynamicQueryColumnExample.Criteria criteria = example.createCriteria();
        criteria.andDqIdEqualTo(dqId);
        List<DynamicQueryColumn> list = mapper.selectByExample(example);
        return list;
    }

    public ResultVo add(DynamicQueryColumn record) {
        mapper.insertSelective(record);
        return ResultVo.ok();
    }

    public ResultVo delete(String dqId) {
        DynamicQueryColumnExample example = new DynamicQueryColumnExample();
        DynamicQueryColumnExample.Criteria criteria = example.createCriteria();
        criteria.andDqIdEqualTo(dqId);
        mapper.deleteByExample(example);
        return ResultVo.ok();
    }
}