package com.microcore.center.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.microcore.api.model.DbOrg;
import com.microcore.api.vo.DbBaseKitVo;
import com.microcore.center.client.DbKitTemplate;
import com.microcore.center.vo.DbOrgVo;
import com.microcore.common.util.ResultVo;

public interface DbOrgService {
	
	void setDbDbKitTemplate(DbKitTemplate dbDbKitTemplate);
	/**
	 * orgList:分页查询机构列表. <br/>
	 *
	 * @param orgName
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @author whater
	 * @since JDK 1.8
	 */
	PageInfo<DbOrgVo> orgList(String orgId, String orgName, Integer pageIndex, Integer pageSize);

	PageInfo<DbOrgVo> queryDbOrg(String orgId, String orgName,String areaId, Integer pageIndex, Integer pageSize);
	/**
	 * @return
	 */
	List<DbOrg> list();
	/**
	 * @return
	 */
	List<DbOrg> listOfAll();

	/**
	 * @return
	 */
	List<DbOrg> otherList();

	/**
	 * add:新增机构信息. <br/>
	 *
	 * @param dbOrgVo
	 * @author whater
	 * @since JDK 1.8
	 */
	void add(DbOrgVo dbOrgVo);

	/**
	 * update:修改机构信息. <br/>
	 *
	 * @param dbOrgVo
	 * @author whater
	 * @since JDK 1.8
	 */
	void update(DbOrgVo dbOrgVo);

	/**
	 * delete:删除机构信息. <br/>
	 *
	 * @param orgId
	 * @author whater
	 * @since JDK 1.8
	 */
	void delete(String orgId);

	/**
	 * getDbOrgByOrgSort:(根据机构序号获取机构信息). <br/>
	 *
	 * @param orgSort
	 * @return
	 * @author whater
	 * @since JDK 1.8
	 */
	DbOrg getDbOrgByOrgSort(Integer orgSort);

	/**
	 * getDbOrgByOrgSort:(根据机构ID获取机构信息). <br/>
	 *
	 * @param orgId
	 * @return
	 * @author whater
	 * @since JDK 1.8
	 */
	DbOrg getDbOrgByOrgSort(String orgId);

	/**
	 * getMaxOrgSort:(获取最大机构序号). <br/>
	 *
	 * @return
	 * @author whater
	 * @since JDK 1.8
	 */
	Integer getMaxOrgSort();


	DbOrg getDbOrgByOrgId(String orgId);

	/**
	 * 根据机构名获取机构ID
	 *
	 * @param orgId 机构ID
	 * @return 机构名
	 */
	String getOrgNameByOrgId(String orgId);
	
	List<DbBaseKitVo> getKitInfoByOrgId(String orgId,String type);
	
	ResultVo getOrgKitInfo();

	ResultVo getLabelKitInfo();

	List<String> getOrgIdListByOrgName(String name);


	ResultVo otherListForLabelManage();
	
	ResultVo<List<DbOrg>> getOrgListByPub(String type);
	
}
