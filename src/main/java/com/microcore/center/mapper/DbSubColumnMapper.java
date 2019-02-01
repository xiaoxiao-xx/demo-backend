package com.microcore.center.mapper;

import com.microcore.center.model.DbSubColumn;
import com.microcore.center.model.DbSubColumnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbSubColumnMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbSubColumnExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbSubColumnExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbSubColumn record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbSubColumn record);

    /**
     *
     * @mbggenerated
     */
    List<DbSubColumn> selectByExample(DbSubColumnExample example);

    /**
     *
     * @mbggenerated
     */
    DbSubColumn selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbSubColumn record, @Param("example") DbSubColumnExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbSubColumn record, @Param("example") DbSubColumnExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbSubColumn record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbSubColumn record);
}