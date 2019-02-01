package com.microcore.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.microcore.api.model.DbPubTsColumn;
import com.microcore.center.model.DbPubTsColumnExample;

public interface DbPubTsColumnMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbPubTsColumnExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbPubTsColumnExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbPubTsColumn record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbPubTsColumn record);

    /**
     *
     * @mbggenerated
     */
    List<DbPubTsColumn> selectByExample(DbPubTsColumnExample example);

    /**
     *
     * @mbggenerated
     */
    DbPubTsColumn selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbPubTsColumn record, @Param("example") DbPubTsColumnExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbPubTsColumn record, @Param("example") DbPubTsColumnExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbPubTsColumn record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbPubTsColumn record);
}