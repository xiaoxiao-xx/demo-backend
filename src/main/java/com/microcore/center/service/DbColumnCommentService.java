package com.microcore.center.service;

import com.microcore.center.model.DbColumnComment;

public interface DbColumnCommentService {

	DbColumnComment getColumnComment(String conId, String tableName, String columnName);

}
