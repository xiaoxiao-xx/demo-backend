package com.microcore.center.service.impl;

import com.microcore.center.mapper.DbFileRecordMapper;
import com.microcore.center.model.DbFileRecord;
import com.microcore.center.service.DbFileRecordService;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 */
@Service
@Transactional
@Slf4j
public class DbFileRecordServiceImpl implements DbFileRecordService {


    @Autowired
    private DbFileRecordMapper dbFileRecordMapper;

    /**
     * 文件操作记录新增
     */
    @Override
    public ResultVo addDbFileRecord(DbFileRecord dbFileRecord) {
        dbFileRecord.setId(checkId(CommonUtil.getUUID()));
        dbFileRecord.setMakeDate(new Date());
        try {
            dbFileRecordMapper.insert(dbFileRecord);
        } catch (Exception e) {
            log.warn(e.getMessage());
            return ResultVo.fail("记录新增失败！");
        }
        return ResultVo.ok();
    }

    public String checkId(String rid){
        DbFileRecord dbFR = dbFileRecordMapper.selectByPrimaryKey(rid);
        if (dbFR != null){
            rid = CommonUtil.getUUID();
            return checkId(rid);
        }
        return rid;
    }
}
