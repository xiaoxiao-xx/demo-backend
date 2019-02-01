package com.microcore.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.microcore.api.model.DbSubTs;
import com.microcore.center.model.DbSubTsExample;

public interface DbSubTsMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbSubTsExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbSubTsExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbSubTs record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbSubTs record);

    /**
     *
     * @mbggenerated
     */
    List<DbSubTs> selectByExample(DbSubTsExample example);

    /**
     *
     * @mbggenerated
     */
    DbSubTs selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbSubTs record, @Param("example") DbSubTsExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbSubTs record, @Param("example") DbSubTsExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbSubTs record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbSubTs record);
}