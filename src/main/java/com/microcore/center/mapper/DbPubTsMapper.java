package com.microcore.center.mapper;

import com.microcore.api.model.DbPubTs;
import com.microcore.center.model.DbPubTsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DbPubTsMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbPubTsExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbPubTsExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbPubTs record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbPubTs record);

    /**
     *
     * @mbggenerated
     */
    List<DbPubTs> selectByExample(DbPubTsExample example);

    /**
     *
     * @mbggenerated
     */
    DbPubTs selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbPubTs record, @Param("example") DbPubTsExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbPubTs record, @Param("example") DbPubTsExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbPubTs record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbPubTs record);
}