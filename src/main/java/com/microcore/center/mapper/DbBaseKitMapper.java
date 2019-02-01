package com.microcore.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.microcore.api.model.DbBaseKit;
import com.microcore.center.model.DbBaseKitExample;

public interface DbBaseKitMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbBaseKitExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbBaseKitExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbBaseKit record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbBaseKit record);

    /**
     *
     * @mbggenerated
     */
    List<DbBaseKit> selectByExample(DbBaseKitExample example);

    /**
     *
     * @mbggenerated
     */
    DbBaseKit selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbBaseKit record, @Param("example") DbBaseKitExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbBaseKit record, @Param("example") DbBaseKitExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbBaseKit record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbBaseKit record);
}