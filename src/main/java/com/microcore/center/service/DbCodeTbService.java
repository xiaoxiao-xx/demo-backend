package com.microcore.center.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.microcore.center.model.DbCodeTb;

public interface DbCodeTbService {

	PageInfo<DbCodeTb> queryDbCodeTb(String nspaceId, String name, Integer pageIndex, Integer pageSize);

	List<DbCodeTb> queryByNspaceId(String nspaceId);

	PageInfo queryPid(String pid, String name, Integer pageIndex, Integer pageSize);

	void add(DbCodeTb dbCodeTb);

	void update(DbCodeTb dbCodeTb);

	void delete(String id);

	DbCodeTb get(String id);

}

