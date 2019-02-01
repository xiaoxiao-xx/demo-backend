package com.microcore.center.service;

import com.github.pagehelper.PageInfo;
import com.microcore.center.model.DbNameSpace;

import java.util.List;

public interface DbNameSpaceService {

	PageInfo queryNameSpace(String cname, Integer pageIndex, Integer pageSize);

	void add(DbNameSpace dbNameSpace);

	void update(DbNameSpace dbNameSpace);

	void delete(String id);

	DbNameSpace get(String id);

	String getCnameById(String id);

	List<DbNameSpace> queryNameSpace();
}
