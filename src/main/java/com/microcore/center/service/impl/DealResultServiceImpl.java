package com.microcore.center.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.mapper.PsmDealResMapper;
import com.microcore.center.model.PsmDealRes;
import com.microcore.center.model.PsmDealResExample;
import com.microcore.center.service.DealResultService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.vo.PsmDealResVo;
import com.microcore.center.vo.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class DealResultServiceImpl implements DealResultService {

    @Autowired
    private PsmDealResMapper psmDealResMapper;

    @Override
    public PageInfo<PsmDealResVo> getDealResultList(String alarmType, Integer pageIndex, Integer pageSize) {
        PsmDealResExample example = new PsmDealResExample();
        PsmDealResExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(alarmType)) {
            criteria.andAlarmTypeEqualTo(alarmType);
        }

        PageInfo<PsmDealRes> psmDealResPageInfo = PageHelper.startPage(pageIndex, pageSize)
                .doSelectPageInfo(() -> psmDealResMapper.selectByExample(example));

        List<PsmDealResVo> resVoList = CommonUtil.listPo2VO(psmDealResPageInfo.getList(), PsmDealResVo.class);
        PageInfo<PsmDealResVo> resVoPageInfo = CommonUtil.po2VO(psmDealResPageInfo, PageInfo.class);
        resVoPageInfo.setList(resVoList);
        return resVoPageInfo;
    }

    @Override
    public ResultVo delete(String id) {
        
        String[] ids = id.split(",");
		for (String i : ids) {
			psmDealResMapper.deleteByPrimaryKey(i);
		}
        
        return ResultVo.ok();
    }

    @Override
    public ResultVo update(PsmDealResVo vo) {
        psmDealResMapper.updateByPrimaryKeySelective(vo);
        return ResultVo.ok();
    }

    @Override
    public ResultVo add(PsmDealResVo vo) {
        psmDealResMapper.insert(vo);
        return ResultVo.ok();
    }

}
