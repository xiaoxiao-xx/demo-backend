package com.microcore.center.controller;

import com.microcore.center.mapper.*;
import com.microcore.center.model.*;
import static com.microcore.center.util.StringUtil.*;
import com.microcore.center.vo.ResultVo;
import com.microcore.center.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("commonController")
public class CommonController {

    @Autowired
    private DbUserMapper dbUserMapper;

    @Autowired
    private EquipmentManageMapper equipmentManageMapper;

    @Autowired
    private AlarmStrategyMapper alarmStrategyMapper;

    @Autowired
    private RealTimeMapper realTimeMapper;

    @Autowired
    private EquipmentHistoryMapper equipmentHistoryMapper;

    @Autowired
    private UserHistoryMapper userHistoryMapper;

    @GetMapping("getUserList")
    public ResultVo getUserInfo(@RequestParam String name) {
        DbUserExample example = new DbUserExample();
        DbUserExample.Criteria criteria = example.createCriteria();
        if (isNotEmpty(name)) {
            criteria.andUsernameLike("%" + name.trim() + "%");
        }
        criteria.andDelStatusEqualTo("NOR");
        return ResultVo.ok(dbUserMapper.selectByExample(example));
    }

    @GetMapping("getEquipmentList")
    public ResultVo getEquipmentInfo(@RequestParam String num, @RequestParam String type, @RequestParam String status) {
        EquipmentManageExample example = new EquipmentManageExample();
        EquipmentManageExample.Criteria criteria = example.createCriteria();

        if (isNotEmpty(num)) {
            criteria.andAlarmNumEqualTo(num);
        }

        if (isNotEmpty(type)) {
            criteria.andEquiTypeEqualTo(type);
        }

        if (isNotEmpty(status)) {
            criteria.andDelStatusEqualTo(status);
        }
        return ResultVo.ok(equipmentManageMapper.selectByExample(example));
    }

    @GetMapping("getAlarmStrategyList")
    public ResultVo getAlarmStrategyList(@RequestParam String name, @RequestParam String type) {
        AlarmStrategyExample example = new AlarmStrategyExample();
        AlarmStrategyExample.Criteria criteria = example.createCriteria();

        if (isNotEmpty(name)) {
            criteria.andAlarmNameLike("%" + name.trim() + "%");
        }

        if (isNotEmpty(type)) {
            criteria.andAlarmTypeEqualTo(type);
        }
        return ResultVo.ok(alarmStrategyMapper.selectByExample(example));
    }

//    @GetMapping("getRealTime")
//    public ResultVo getRealTime() {
//        RealTimeExample example = new RealTimeExample();
//        RealTimeExample.Criteria criteria = example.createCriteria();
//        List<RealTime> realTimes = realTimeMapper.selectByExample(example);
//        return ResultVo.ok(realTimes);
//    }


    @GetMapping("getEquipmentHistory")
    public ResultVo getEquipmentHistory(@RequestParam String id){
        EquipmentHistoryExample example = new EquipmentHistoryExample();
        EquipmentHistoryExample.Criteria criteria = example.createCriteria();
        criteria.andEquipmentIdEqualTo(id);
        return ResultVo.ok(equipmentHistoryMapper.selectByExample(example));
    }

    @GetMapping("getUserHistory")
    public ResultVo getUserHistory(@RequestParam String id) {
        UserHistoryExample example = new UserHistoryExample();
        UserHistoryExample.Criteria criteria = example.createCriteria();
        criteria.andNameIdEqualTo(id);
        return ResultVo.ok(userHistoryMapper.selectByExample(example));
    }

    @PostMapping("addUserCare")
    public ResultVo addUserCare(@RequestBody UserVo userVo) {
        DbUser user = new DbUser();
        user.setId(userVo.getId());
        user.setMoreCare(userVo.getCare());
        dbUserMapper.updateByPrimaryKeySelective(user);
        UserHistory history = new UserHistory();
        setUserHistory(history, userVo);
        history.setDoType("添加重点关注");
        userHistoryMapper.insertSelective(history);
        return ResultVo.ok();
    }

    @PostMapping("rmUserCare")
    public ResultVo rmUserCare(@RequestBody UserVo userVo) {
        DbUser user = new DbUser();
        user.setId(userVo.getId());
        user.setMoreCare(null);
        dbUserMapper.updateByPrimaryKeySelective(user);
        UserHistory history = new UserHistory();
        setUserHistory(history, userVo);
        history.setDoType("取消重点关注");
        userHistoryMapper.insertSelective(history);
        return ResultVo.ok();
    }

    private void setUserHistory(UserHistory history, UserVo userVo) {
        history.setId(getUUID());
        history.setName(userVo.getUsername());
        history.setNameId(userVo.getId());
        history.setDoTm(new Date());
        history.setDoMan("admin");
        history.setDoManId("0");
        history.setRemark(userVo.getRemark());
    }

    @PostMapping("enableEquipment")
    public ResultVo enableEquipment(String id) {
        EquipmentManage manage = new EquipmentManage();
        manage.setId(id);
        manage.setUpStatus("启用");
        equipmentManageMapper.updateByPrimaryKeySelective(manage);
        EquipmentHistory history = new EquipmentHistory();
        setEquipmentHistory(history, id);
        history.setDoType("启用");
        equipmentHistoryMapper.insertSelective(history);
        return ResultVo.ok();
    }

    @PostMapping("shutdownEquipment")
    public ResultVo shutdownEquipment(String id) {
        EquipmentManage manage = new EquipmentManage();
        manage.setId(id);
        manage.setUpStatus("停用");
        equipmentManageMapper.updateByPrimaryKeySelective(manage);
        EquipmentHistory history = new EquipmentHistory();
        setEquipmentHistory(history, id);
        history.setDoType("停用");
        equipmentHistoryMapper.insertSelective(history);
        return ResultVo.ok();
    }

    private void setEquipmentHistory(EquipmentHistory history, String id) {
        history.setId(getUUID());
        history.setDoMan("admin");
        history.setDoManId("0");
        history.setDoTm(new Date());
        history.setEquipmentId(id);
    }
}
