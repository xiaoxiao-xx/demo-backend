package com.microcore.center.mapper;

import com.microcore.center.model.DbSubTable;
import com.microcore.center.model.DbSubTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbSubTableMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbSubTableExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbSubTableExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbSubTable record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbSubTable record);

    /**
     *
     * @mbggenerated
     */
    List<DbSubTable> selectByExample(DbSubTableExample example);

    /**
     *
     * @mbggenerated
     */
    DbSubTable selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbSubTable record, @Param("example") DbSubTableExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbSubTable record, @Param("example") DbSubTableExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbSubTable record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbSubTable record);
}