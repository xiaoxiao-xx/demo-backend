package com.microcore.center.mapper;

import com.microcore.center.model.DbDistillRecord;
import com.microcore.center.model.DbDistillRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbDistillRecordMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbDistillRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbDistillRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbDistillRecord record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbDistillRecord record);

    /**
     *
     * @mbggenerated
     */
    List<DbDistillRecord> selectByExample(DbDistillRecordExample example);

    /**
     *
     * @mbggenerated
     */
    DbDistillRecord selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbDistillRecord record, @Param("example") DbDistillRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbDistillRecord record, @Param("example") DbDistillRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbDistillRecord record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbDistillRecord record);
}