package com.microcore.center.mapper;

import com.microcore.center.model.DbTransRecord;
import com.microcore.center.model.DbTransRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbTransRecordMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbTransRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbTransRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbTransRecord record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbTransRecord record);

    /**
     *
     * @mbggenerated
     */
    List<DbTransRecord> selectByExample(DbTransRecordExample example);

    /**
     *
     * @mbggenerated
     */
    DbTransRecord selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbTransRecord record, @Param("example") DbTransRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbTransRecord record, @Param("example") DbTransRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbTransRecord record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbTransRecord record);
}