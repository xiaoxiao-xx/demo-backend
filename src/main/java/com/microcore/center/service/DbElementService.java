package com.microcore.center.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.microcore.center.vo.DbElementVo;
import com.microcore.common.util.ResultVo;

public interface DbElementService {
	
	ResultVo<?> queryCoreElement(String name);
	
	ResultVo<?> queryDefineElement(String name);
	
	List<DbElementVo> queryDbElementVo(String name, String type);
	
	ResultVo addElement(DbElementVo dbElementVo);
	
	ResultVo updateElement(DbElementVo dbElementVo);
	
	ResultVo delElement(String id);
	
	DbElementVo getElement(String id);

	PageInfo queryDbElementVo(String name, String type, Integer pageIndex, Integer pageSize);

	ResultVo getDbElements();
}

