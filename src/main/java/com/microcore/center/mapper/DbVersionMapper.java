package com.microcore.center.mapper;

import com.microcore.center.model.DbVersion;
import com.microcore.center.model.DbVersionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbVersionMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbVersionExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbVersionExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbVersion record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbVersion record);

    /**
     *
     * @mbggenerated
     */
    List<DbVersion> selectByExample(DbVersionExample example);

    /**
     *
     * @mbggenerated
     */
    DbVersion selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbVersion record, @Param("example") DbVersionExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbVersion record, @Param("example") DbVersionExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbVersion record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbVersion record);
}