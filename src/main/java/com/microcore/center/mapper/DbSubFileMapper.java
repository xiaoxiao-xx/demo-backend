package com.microcore.center.mapper;

import com.microcore.center.model.DbSubFile;
import com.microcore.center.model.DbSubFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbSubFileMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbSubFileExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbSubFileExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String subId);

    /**
     *
     * @mbggenerated
     */
    int insert(DbSubFile record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbSubFile record);

    /**
     *
     * @mbggenerated
     */
    List<DbSubFile> selectByExample(DbSubFileExample example);

    /**
     *
     * @mbggenerated
     */
    DbSubFile selectByPrimaryKey(String subId);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbSubFile record, @Param("example") DbSubFileExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbSubFile record, @Param("example") DbSubFileExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbSubFile record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbSubFile record);
}