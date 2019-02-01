package com.microcore.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.microcore.api.model.DbFileKit;
import com.microcore.center.model.DbFileKitExample;

public interface DbFileKitMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbFileKitExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbFileKitExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbFileKit record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbFileKit record);

    /**
     *
     * @mbggenerated
     */
    List<DbFileKit> selectByExample(DbFileKitExample example);

    /**
     *
     * @mbggenerated
     */
    DbFileKit selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbFileKit record, @Param("example") DbFileKitExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbFileKit record, @Param("example") DbFileKitExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbFileKit record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbFileKit record);
}