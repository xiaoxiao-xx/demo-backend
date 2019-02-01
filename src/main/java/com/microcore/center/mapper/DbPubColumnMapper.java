package com.microcore.center.mapper;

import com.microcore.center.model.DbPubColumn;
import com.microcore.center.model.DbPubColumnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbPubColumnMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbPubColumnExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbPubColumnExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbPubColumn record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbPubColumn record);

    /**
     *
     * @mbggenerated
     */
    List<DbPubColumn> selectByExample(DbPubColumnExample example);

    /**
     *
     * @mbggenerated
     */
    DbPubColumn selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbPubColumn record, @Param("example") DbPubColumnExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbPubColumn record, @Param("example") DbPubColumnExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbPubColumn record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbPubColumn record);
}