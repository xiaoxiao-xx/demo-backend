package com.microcore.center.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.microcore.center.model.DbArea;
import com.microcore.center.vo.DbAreaVo;

public interface DbAreaService {
	/**
	 * 
	 * orgList:分页查询域列表. <br/>
	 *
	 * @author whater
	 * @param id
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @since JDK 1.8
	 */
	PageInfo<DbAreaVo> areaList(String id,String areaName, Integer pageIndex, Integer pageSize);
	
	List<DbArea> list();
	
	/**
	 * 
	 * add:新增域信息. <br/>
	 *
	 * @author whater
	 * @param dbAreaVo
	 * @since JDK 1.8
	 */
	void add(DbAreaVo dbAreaVo);
	/**
	 * 
	 * update:修改域信息. <br/>
	 *
	 * @author whater
	 * @param dbAreaVo
	 * @since JDK 1.8
	 */
	void update(DbAreaVo dbAreaVo);
	/**
	 * 
	 * delete:删除域信息. <br/>
	 *
	 * @author whater
	 * @param id
	 * @since JDK 1.8
	 */
	void delete(String id);
	/**
	 * 
	 * getDbOrgByOrgSort:(根据域ID获取域信息). <br/>
	 *
	 * @author whater
	 * @param id
	 * @return
	 * @since JDK 1.8
	 */
	DbArea getDbAreaById(String id);

	/**
	 * 根据域ID获取域名称
	 * 
	 * @param areaId 域ID
	 * @return 域名称
	 */
	String getAreaNameByAreaId(String areaId);
}

