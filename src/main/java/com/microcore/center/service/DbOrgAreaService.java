package com.microcore.center.service;

import java.util.List;
import java.util.stream.Stream;

import com.microcore.api.model.DbOrg;
import com.microcore.center.model.DbArea;
import com.microcore.center.model.ShArea;
import com.microcore.common.util.ResultVo;

public interface DbOrgAreaService {

	List<DbArea> getDbAreaByOrgId(String orgId);

	List<DbOrg> getDbOrgByAreaId(String areaId);

	void addOrgRel(String orgId, String areaIds);

	void addAreaRel(String areaId, String orgIds);

	ResultVo<List<ShArea>> getLayerArea(String id);

	String realConvertAuthScope(Stream<String> s, String authType);

	String convertAuthScope(String c, String authType);
	/**
	 * 
	 * getOrgIds:根据域ID集合获取机构ID集合. <br/>
	 *
	 * @author whater
	 * @param areaIds
	 * @return
	 * @since JDK 1.8
	 */
	String getOrgIds(String areaIds);
}
