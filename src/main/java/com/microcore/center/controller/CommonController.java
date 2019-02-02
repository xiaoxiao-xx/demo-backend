package com.microcore.center.controller;

import com.microcore.center.mapper.AlarmStrategyMapper;
import com.microcore.center.mapper.DbUserMapper;
import com.microcore.center.mapper.EquipmentManageMapper;
import com.microcore.center.model.AlarmStrategyExample;
import com.microcore.center.model.DbUserExample;
import com.microcore.center.model.EquipmentManageExample;
import com.microcore.center.util.StringUtil;
import com.microcore.center.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("commonController")
public class CommonController {

    @Autowired
    private DbUserMapper dbUserMapper;

    @Autowired
    private EquipmentManageMapper equipmentManageMapper;

    @Autowired
    private AlarmStrategyMapper alarmStrategyMapper;

    @GetMapping("getUserList")
    public ResultVo getUserInfo(@RequestParam String name) {
        DbUserExample example = new DbUserExample();
        DbUserExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(name)) {
            criteria.andUsernameLike("%"+name.trim()+"%");
        }
        criteria.andDelStatusEqualTo("NOR");
        return ResultVo.ok(dbUserMapper.selectByExample(example));
    }

    @GetMapping("getEquipmentList")
    public ResultVo getEquipmentInfo(@RequestParam String num, @RequestParam String type, @RequestParam String status) {
        EquipmentManageExample example = new EquipmentManageExample();
        EquipmentManageExample.Criteria criteria = example.createCriteria();

        if (StringUtil.isNotEmpty(num)) {
            criteria.andAlarmNumEqualTo(num);
        }

        if (StringUtil.isNotEmpty(type)) {
            criteria.andEquiTypeEqualTo(type);
        }

        if (StringUtil.isNotEmpty(status)) {
            criteria.andDelStatusEqualTo(status);
        }
        return ResultVo.ok(equipmentManageMapper.selectByExample(example));
    }

    @GetMapping("getAlarmStrategyList")
    public ResultVo getAlarmStrategyList(@RequestParam String name, @RequestParam String type) {
        AlarmStrategyExample example = new AlarmStrategyExample();
        AlarmStrategyExample.Criteria criteria = example.createCriteria();

        if (StringUtil.isNotEmpty(name)) {
            criteria.andAlarmNameLike("%" + name.trim() + "%");
        }

        if (StringUtil.isNotEmpty(type)) {
            criteria.andAlarmTypeEqualTo(type);
        }
        return ResultVo.ok(alarmStrategyMapper.selectByExample(example));
    }



}
