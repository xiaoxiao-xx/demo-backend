package com.microcore.center.mapper;

import com.microcore.center.model.DbNameSpace;
import com.microcore.center.model.DbNameSpaceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbNameSpaceMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbNameSpaceExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbNameSpaceExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbNameSpace record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbNameSpace record);

    /**
     *
     * @mbggenerated
     */
    List<DbNameSpace> selectByExample(DbNameSpaceExample example);

    /**
     *
     * @mbggenerated
     */
    DbNameSpace selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbNameSpace record, @Param("example") DbNameSpaceExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbNameSpace record, @Param("example") DbNameSpaceExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbNameSpace record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbNameSpace record);
}