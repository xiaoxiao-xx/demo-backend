package com.microcore.center.mapper;

import com.microcore.center.model.DbServiceRecord;
import com.microcore.center.model.DbServiceRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbServiceRecordMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbServiceRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbServiceRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbServiceRecord record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbServiceRecord record);

    /**
     *
     * @mbggenerated
     */
    List<DbServiceRecord> selectByExample(DbServiceRecordExample example);

    /**
     *
     * @mbggenerated
     */
    DbServiceRecord selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbServiceRecord record, @Param("example") DbServiceRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbServiceRecord record, @Param("example") DbServiceRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbServiceRecord record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbServiceRecord record);
}