package com.microcore.center.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.microcore.center.service.DbAreaService;
import com.microcore.center.service.DbOrgService;
import com.microcore.common.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microcore.api.model.DbOrg;
import com.microcore.center.mapper.DbOrgAreaRelMapper;
import com.microcore.center.mapper.ShAreaMapper;
import com.microcore.center.model.DbArea;
import com.microcore.center.model.DbOrgAreaRel;
import com.microcore.center.model.DbOrgAreaRelExample;
import com.microcore.center.model.ShArea;
import com.microcore.center.model.ShAreaExample;
import com.microcore.center.service.DbOrgAreaService;
import com.microcore.common.service.CommonService;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.StringUtil;

import static com.microcore.common.constant.Constants.AUTH_TYPE_ORG;
import static com.microcore.common.constant.Constants.AUTH_TYPE_REGION;

@Service
@Transactional
public class DbOrgAreaServiceImpl implements DbOrgAreaService {

    @Autowired
    private CommonService commonService;

    @Autowired
    private DbOrgAreaRelMapper dbOrgAreaRelMapper;

    @Autowired
    private ShAreaMapper shAreaMapper;

    @Autowired
    private DbOrgService dbOrgService;

    @Autowired
    private DbAreaService dbAreaService;

    @Override
    public List<DbArea> getDbAreaByOrgId(String orgId) {
        Map<String, Object> params = new HashMap<>();
        params.put("sql", "select a.* from db_org_area_rel r left join db_area a on r.area_id = a.id where r.org_id = #{orgId} ");
        params.put("orgId", orgId);
        return CommonUtil.map2PO(commonService.executeSelectSQL(params), DbArea.class, true);
    }

    @Override
    public List<DbOrg> getDbOrgByAreaId(String areaId) {
        Map<String, Object> params = new HashMap<>();
        // TODO because of the left join, o might be null
        params.put("sql", "select o.* from db_org_area_rel r left join db_org o on r.org_id = o.org_id where r.area_id = #{areaId} ");
        params.put("areaId", areaId);
        return CommonUtil.map2PO(commonService.executeSelectSQL(params), DbOrg.class, true);
    }

    @Override
    public void addOrgRel(String orgId, String areaIds) {
        DbOrgAreaRelExample example = new DbOrgAreaRelExample();
        DbOrgAreaRelExample.Criteria criteria = example.createCriteria();
        criteria.andOrgIdEqualTo(orgId);
        dbOrgAreaRelMapper.deleteByExample(example);
        if (StringUtil.isNotEmpty(areaIds)) {
            for (String areaId : areaIds.split(",")) {
                DbOrgAreaRel rel = new DbOrgAreaRel();
                rel.setId(CommonUtil.getUUID());
                rel.setAreaId(areaId);
                rel.setOrgId(orgId);
                dbOrgAreaRelMapper.insert(rel);
            }
        }
    }

    @Override
    public void addAreaRel(String areaId, String orgIds) {
        DbOrgAreaRelExample example = new DbOrgAreaRelExample();
        DbOrgAreaRelExample.Criteria criteria = example.createCriteria();
        criteria.andAreaIdEqualTo(areaId);
        dbOrgAreaRelMapper.deleteByExample(example);
        if (StringUtil.isNotEmpty(orgIds)) {
            for (String orgId : orgIds.split(",")) {
                DbOrgAreaRel rel = new DbOrgAreaRel();
                rel.setId(CommonUtil.getUUID());
                rel.setAreaId(areaId);
                rel.setOrgId(orgId);
                dbOrgAreaRelMapper.insert(rel);
            }
        }
    }

    @Override
    public ResultVo<List<ShArea>> getLayerArea(String id) {
        ShAreaExample example = new ShAreaExample();
        ShAreaExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(id)) {
            criteria.andPidEqualTo(Integer.parseInt(id));
            List<ShArea> list = shAreaMapper.selectByExample(example);
            if (list.isEmpty()) {
                return ResultVo.fail("没有数据");
            }
            return ResultVo.ok(list);
        }
        return ResultVo.fail("id不存在");
    }

    @Override
    public String realConvertAuthScope(Stream<String> s, String authType) {
        String authScopeStr = "";
	    if (AUTH_TYPE_ORG.equals(authType)) {
		    authScopeStr = s.map(orgId
				    -> dbOrgService.getOrgNameByOrgId(orgId)).collect(Collectors.joining(","));
	    } else if (AUTH_TYPE_REGION.equals(authType)) {
		    authScopeStr = s.map(areaId
				    -> dbAreaService.getAreaNameByAreaId(areaId)).collect(Collectors.joining(","));
        }

        return authScopeStr;
    }

    @Override
    public String convertAuthScope(String c, String authType) {
        // 将授权范围转为机构或域名
        Stream<String> s = Arrays.stream(c.split(","));
        return realConvertAuthScope(s, authType);
    }

	@Override
	public String getOrgIds(String areaIds) {
		if(StringUtil.isEmpty(areaIds)) {
			return null ;
		}
		List<String> values = new ArrayList<>();
		String[] areaIdArr = areaIds.split(",");
		if(areaIdArr.length == 0) {
			return null ;
		}
		for (String areaId : areaIdArr) {
			values.add(areaId);
		}
        DbOrgAreaRelExample example = new DbOrgAreaRelExample();
        DbOrgAreaRelExample.Criteria criteria = example.createCriteria();
        criteria.andAreaIdIn(values);
        List<DbOrgAreaRel> dbOrgAreaRelList = dbOrgAreaRelMapper.selectByExample(example);
        if(CommonUtil.isEmpty(dbOrgAreaRelList)) {
        	return null ;
        }
		StringBuilder sb = new StringBuilder();
		dbOrgAreaRelList.forEach(dbOrgAreaRel -> sb.append(",").append(dbOrgAreaRel.getOrgId()));
		return sb.substring(1);
	}

}

