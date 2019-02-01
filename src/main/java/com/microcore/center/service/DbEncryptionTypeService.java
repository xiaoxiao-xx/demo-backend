package com.microcore.center.service;

import com.github.pagehelper.PageInfo;
import com.microcore.center.model.DbEncryptionType;

import java.util.List;

public interface DbEncryptionTypeService {

	void addEncryptionType(DbEncryptionType type);

	void updateEncryptionType(DbEncryptionType type);

	List<DbEncryptionType> getEncryptionTypeList();

	void deleteEncryptionType(String id);

	DbEncryptionType getEncryptionTypeById(String id);

}

