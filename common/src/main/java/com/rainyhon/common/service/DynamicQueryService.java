package com.rainyhon.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rainyhon.common.mapper.DynamicQueryMapper;
import com.rainyhon.common.model.DeviceVersion;
import com.rainyhon.common.model.DynamicQuery;
import com.rainyhon.common.model.DynamicQueryExample;
import com.rainyhon.common.vo.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DynamicQueryService {

    @Autowired
    private DynamicQueryMapper mapper;

    public ResultVo page(String viewDisplayName, Integer pageIndex, Integer pageSize) {
        DynamicQueryExample example = new DynamicQueryExample();
        DynamicQueryExample.Criteria criteria = example.createCriteria();
        // 模糊查询视图名称
        if (StringUtils.isNotEmpty(viewDisplayName)) {
            criteria.andViewDisplayNameLike(viewDisplayName);
        }
        example.setOrderByClause("create_time desc");
        PageInfo<DeviceVersion> pageInfo = PageHelper.startPage(pageIndex, pageSize)
                .doSelectPageInfo(() -> mapper.selectByExample(example));

        return ResultVo.ok(pageInfo);
    }

    /**
     * 新增
     *
     * @param record
     * @return
     */
    public ResultVo add(DynamicQuery record) {
        mapper.insertSelective(record);
        return ResultVo.ok();
    }

    public ResultVo modify(DynamicQuery record) {
        mapper.updateByPrimaryKeySelective(record);
        return ResultVo.ok();
    }

    public ResultVo delete(String id) {
        mapper.deleteByPrimaryKey(id);
        return ResultVo.ok();
    }

    /**
     * 判断是否存在
     *
     * @param uuid
     * @return
     */
    public boolean isExist(String uuid) {
        DynamicQuery query = mapper.selectByPrimaryKey(uuid);
        if (query != null) {
            return true;
        }
        return false;
    }

    public DynamicQuery findOne(String id) {
        return mapper.selectByPrimaryKey(id);
    }
}