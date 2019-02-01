package com.microcore.center.service.impl;

import com.microcore.center.mapper.DbParamsMapper;
import com.microcore.center.model.DbParams;
import com.microcore.center.model.DbParamsExample;
import com.microcore.center.service.DbParamsService;
import com.microcore.common.constant.Constants;
import com.microcore.common.util.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 参数管理
 */
@Service
@Transactional
@Slf4j
public class DbParamsServiceImpl implements DbParamsService {

    @Autowired
    private DbParamsMapper dbParamsMapper;

    /**
     * 根据params_type字段查询db_params表
     *
     * @param paramsType params_type字段
     * @return DbParams列表
     */
    @Override
    public List<DbParams> getTypeOrMode(String paramsType) {
        DbParamsExample example = new DbParamsExample();
        DbParamsExample.Criteria criteria = example.createCriteria();
        criteria.andParamsTypeEqualTo(paramsType);
        List<DbParams> dbParams = dbParamsMapper.selectByExample(example);
        dbParams.forEach(p -> {
            if ("supervisePassword".equals(p.getParamsKey())) {
                String value = DESUtil.encrypt(p.getParamsValue());
                p.setParamsValue(value);
            }
        });
        return dbParams;
    }

    @Override
    public List<DbParams> getParamListByTypeAndKey(String paramsType, String paramsKey) {
        DbParamsExample example = new DbParamsExample();
        DbParamsExample.Criteria criteria = example.createCriteria();
        if (paramsType != null) {
	        criteria.andParamsTypeEqualTo(paramsType);
        }
        if (paramsKey != null) {
	        criteria.andParamsKeyEqualTo(paramsKey);
        }
        return dbParamsMapper.selectByExample(example);
    }

    @Override
    public String getParamsValueByTypeAndKey(String paramsType, String paramsKey) {
        DbParamsExample example = new DbParamsExample();
        DbParamsExample.Criteria criteria = example.createCriteria();
        criteria.andParamsTypeEqualTo(paramsType);
        if (paramsKey != null) {
	        criteria.andParamsKeyEqualTo(paramsKey);
        }
        List<DbParams> list = dbParamsMapper.selectByExample(example);
        if (CommonUtil.isEmpty(list) || list.size() > 1) {
            return "";
        } else {
            DbParams param = list.get(0);
            return param.getParamsValue();
        }
    }

    @Override
    public ResultVo addParams(List<DbParams> params) {
        if (null == params || params.isEmpty()) {
            return ResultVo.fail("配置参数不能为空！");
        }
        String paramsType = params.get(0).getParamsType();
        if (StringUtil.isEmpty(paramsType)) {
            return ResultVo.fail("配置参数类型不能为空！");
        }
        DbParamsExample example = new DbParamsExample();
        DbParamsExample.Criteria criteria = example.createCriteria();
        criteria.andParamsTypeEqualTo(paramsType);
        dbParamsMapper.deleteByExample(example);

        params.forEach(p -> {
            if (StringUtil.isEmpty(p.getId())) {
                p.setId(CommonUtil.getUUID());
            }
            try {
                if ("supervisePassword".equals(p.getParamsKey())) {
                    String value = DESUtil.decryptor(p.getParamsValue());
                    if (!PasswordUtil.isEncrypted(value)) {
                        value = PasswordUtil.encrypt(value);
                    }
                    p.setParamsValue(value);
                }
            } catch (Exception e) {
                log.error("DES解密异常[{}]",e.getMessage());
            }
            dbParamsMapper.insert(p);
        });

        return ResultVo.ok("添加成功！");
    }

    @Override
    public ResultVo openOrCloseMasterKey(String status) {
        if (StringUtil.isNotEmpty(status)) {
            DbParams dbParams = new DbParams();
            DbParamsExample example = new DbParamsExample();
            DbParamsExample.Criteria criteria = example.createCriteria();
            criteria.andParamsTypeEqualTo("master_key");
            criteria.andParamsKeyEqualTo("master_key");
            if (Constants.YES.equalsIgnoreCase(status)) {
                dbParams.setParamsValue(Constants.YES);
            }else {
                dbParams.setParamsValue(Constants.NO);
            }
            dbParamsMapper.updateByExampleSelective(dbParams, example);
            return ResultVo.ok();
        }
        return ResultVo.fail();
    }
}

