package com.microcore.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.microcore.api.model.DbServiceKit;
import com.microcore.center.model.DbServiceKitExample;

public interface DbServiceKitMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbServiceKitExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbServiceKitExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbServiceKit record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbServiceKit record);

    /**
     *
     * @mbggenerated
     */
    List<DbServiceKit> selectByExample(DbServiceKitExample example);

    /**
     *
     * @mbggenerated
     */
    DbServiceKit selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbServiceKit record, @Param("example") DbServiceKitExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbServiceKit record, @Param("example") DbServiceKitExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbServiceKit record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbServiceKit record);
}