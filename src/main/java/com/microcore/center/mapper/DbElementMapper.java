package com.microcore.center.mapper;

import com.microcore.center.model.DbElement;
import com.microcore.center.model.DbElementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbElementMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbElementExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbElementExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbElement record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbElement record);

    /**
     *
     * @mbggenerated
     */
    List<DbElement> selectByExample(DbElementExample example);

    /**
     *
     * @mbggenerated
     */
    DbElement selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbElement record, @Param("example") DbElementExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbElement record, @Param("example") DbElementExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbElement record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbElement record);
}