package com.microcore.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.microcore.api.model.DbDbKit;
import com.microcore.center.model.DbDbKitExample;

public interface DbDbKitMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbDbKitExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbDbKitExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbDbKit record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbDbKit record);

    /**
     *
     * @mbggenerated
     */
    List<DbDbKit> selectByExample(DbDbKitExample example);

    /**
     *
     * @mbggenerated
     */
    DbDbKit selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbDbKit record, @Param("example") DbDbKitExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbDbKit record, @Param("example") DbDbKitExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbDbKit record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbDbKit record);
}