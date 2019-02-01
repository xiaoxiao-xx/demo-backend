package com.microcore.center.mapper;

import com.microcore.center.model.DbServer;
import com.microcore.center.model.DbServerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbServerMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbServerExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbServerExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbServer record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbServer record);

    /**
     *
     * @mbggenerated
     */
    List<DbServer> selectByExample(DbServerExample example);

    /**
     *
     * @mbggenerated
     */
    DbServer selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbServer record, @Param("example") DbServerExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbServer record, @Param("example") DbServerExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbServer record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbServer record);
}