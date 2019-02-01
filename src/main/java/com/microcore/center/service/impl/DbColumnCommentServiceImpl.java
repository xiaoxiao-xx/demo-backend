package com.microcore.center.service.impl;

import com.microcore.center.mapper.DbColumnCommentMapper;
import com.microcore.center.model.DbColumnComment;
import com.microcore.center.model.DbColumnCommentExample;
import com.microcore.center.service.DbColumnCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 字段自定义注释管理
 */
@Transactional
@Service
public class DbColumnCommentServiceImpl implements DbColumnCommentService {

	@Autowired
	private DbColumnCommentMapper dbColumnCommentMapper;

	@Override
	public DbColumnComment getColumnComment(String conId, String tableName, String columnName) {
		DbColumnCommentExample example = new DbColumnCommentExample();
		DbColumnCommentExample.Criteria criteria = example.createCriteria();
		criteria.andConIdEqualTo(conId);
		criteria.andTableNameEqualTo(tableName);
		criteria.andColumnNameEqualTo(columnName);
		List<DbColumnComment> dbColumnComments = dbColumnCommentMapper.selectByExample(example);
		if (dbColumnComments.size() > 0) {
			return dbColumnComments.get(0);
		} else {
			return new DbColumnComment();
		}
	}

}

