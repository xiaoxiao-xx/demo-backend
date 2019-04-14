package com.microcore.center.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.mapper.PsmDealResDetailMapper;
import com.microcore.center.model.PsmDealResDetail;
import com.microcore.center.model.PsmDealResDetailExample;
import com.microcore.center.service.DealResultDetailService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.vo.PsmDealResDetailVo;
import com.microcore.center.vo.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class DealResultDetailServiceImpl implements DealResultDetailService {

    @Autowired
    private PsmDealResDetailMapper psmDealResDetailMapper;

    @Override
    public PageInfo<PsmDealResDetailVo> getDealResultDetailList(String alarmType, Integer pageIndex, Integer pageSize) {
        PsmDealResDetailExample example = new PsmDealResDetailExample();
        PsmDealResDetailExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(alarmType)) {
            criteria.andAlarmTypeEqualTo(alarmType);
        }

        PageInfo<PsmDealResDetail> psmDealResPageInfo = PageHelper.startPage(pageIndex, pageSize)
                .doSelectPageInfo(() -> psmDealResDetailMapper.selectByExample(example));

        List<PsmDealResDetailVo> resVoList = CommonUtil.listPo2VO(psmDealResPageInfo.getList(), PsmDealResDetailVo.class);
        PageInfo<PsmDealResDetailVo> resVoPageInfo = CommonUtil.po2VO(psmDealResPageInfo, PageInfo.class);
        resVoPageInfo.setList(resVoList);
        return resVoPageInfo;
    }

    @Override
    public ResultVo add(PsmDealResDetailVo vo) {
        psmDealResDetailMapper.insert(vo);
        return ResultVo.ok();
    }

    @Override
    public ResultVo delete(String id) {
        String[] ids = id.split(",");
		for (String i : ids) {
			psmDealResDetailMapper.deleteByPrimaryKey(i);
		}
        return ResultVo.ok();
    }

    @Override
    public ResultVo update(PsmDealResDetailVo vo) {
        psmDealResDetailMapper.updateByPrimaryKeySelective(vo);
        return ResultVo.ok();
    }

}
