package com.microcore.center.mapper;

import com.microcore.center.model.DbFileRecord;
import com.microcore.center.model.DbFileRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbFileRecordMapper {
    int countByExample(DbFileRecordExample example);

    int deleteByExample(DbFileRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(DbFileRecord record);

    int insertSelective(DbFileRecord record);

    List<DbFileRecord> selectByExample(DbFileRecordExample example);

    DbFileRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DbFileRecord record, @Param("example") DbFileRecordExample example);

    int updateByExample(@Param("record") DbFileRecord record, @Param("example") DbFileRecordExample example);

    int updateByPrimaryKeySelective(DbFileRecord record);

    int updateByPrimaryKey(DbFileRecord record);
}