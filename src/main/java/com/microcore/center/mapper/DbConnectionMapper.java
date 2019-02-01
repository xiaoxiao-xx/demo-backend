package com.microcore.center.mapper;

import com.microcore.center.model.DbConnection;
import com.microcore.center.model.DbConnectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbConnectionMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbConnectionExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbConnectionExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbConnection record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbConnection record);

    /**
     *
     * @mbggenerated
     */
    List<DbConnection> selectByExample(DbConnectionExample example);

    /**
     *
     * @mbggenerated
     */
    DbConnection selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbConnection record, @Param("example") DbConnectionExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbConnection record, @Param("example") DbConnectionExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbConnection record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbConnection record);
}