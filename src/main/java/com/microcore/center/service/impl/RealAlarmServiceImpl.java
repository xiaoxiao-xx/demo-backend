package com.microcore.center.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.mapper.PsmRealAlarmMapper;
import com.microcore.center.model.PsmRealAlarm;
import com.microcore.center.model.PsmRealAlarmExample;
import com.microcore.center.service.ParaDefineService;
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
    @Autowired
	private ParaDefineService paraDefineService;
    @Override
    public PageInfo<PsmRealAlarmVo> getRealAlarmList(String alarmType, String operator,String state, Integer pageIndex, Integer pageSize) {
        PsmRealAlarmExample example = new PsmRealAlarmExample();
        PsmRealAlarmExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(alarmType)) {
            criteria.andAlarmTypeEqualTo(alarmType);
        }
        if (StringUtils.isNotEmpty(operator)) {
            criteria.andOperatorEqualTo(operator);
        }
        if (StringUtils.isNotEmpty(state)) {
            criteria.andStateEqualTo(state);
        }
        PageInfo<PsmRealAlarm> realAlarmPageInfo = PageHelper.startPage(pageIndex, pageSize)
                .doSelectPageInfo(() -> psmRealAlarmMapper.selectByExample(example));

        List<PsmRealAlarmVo> list = CommonUtil.listPo2VO(realAlarmPageInfo.getList(), PsmRealAlarmVo.class);
        for (PsmRealAlarmVo psmRealAlarmVo : list) {
        	psmRealAlarmVo.setStateName(paraDefineService.getValueByTypeAnd("REAL_ALARM_STATE", psmRealAlarmVo.getState()));
		}
        PageInfo<PsmRealAlarmVo> pageInfo = new PageInfo<>();
        
        pageInfo.setList(list);
        pageInfo.setTotal(realAlarmPageInfo.getTotal());
        return pageInfo;
    }

    @Override
    public ResultVo delete(String id) {
        String[] ids = id.split(",");
		for (String i : ids) {
			psmRealAlarmMapper.deleteByPrimaryKey(i);
		}
        
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

	@Override
	public ResultVo dealRealAlarm(PsmRealAlarmVo vo) {
		PsmRealAlarm psmRealAlarm = psmRealAlarmMapper.selectByPrimaryKey(vo.getId());
		psmRealAlarm.setRemark(vo.getRemark());
		psmRealAlarm.setState(vo.getState());
		psmRealAlarm.setOperator(CommonUtil.getCurrentUserId());
		psmRealAlarmMapper.updateByPrimaryKey(psmRealAlarm);
		return ResultVo.ok();
	}

}
