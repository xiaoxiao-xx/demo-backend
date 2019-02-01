package com.microcore.center.service;

import java.util.List;
import java.util.Map;

import com.microcore.common.util.ResultVo;
import com.microcore.center.model.DbFieldCnf;

public interface DbFieldCnfService {

	ResultVo addDbFieldCnf(DbFieldCnf dbFieldCnf);

	ResultVo deleteDbFieldCnf(DbFieldCnf dbFieldCnf);

	ResultVo deleteByPid(String pid);

	ResultVo deleteByConId(String conId);

	ResultVo updateDbFieldCnf(DbFieldCnf dbFieldCnf);

	List<DbFieldCnf> getDbFieldCnfByPid(String pid);

	Map<String, String> getCommentMap(String conId, String tableName);
}
