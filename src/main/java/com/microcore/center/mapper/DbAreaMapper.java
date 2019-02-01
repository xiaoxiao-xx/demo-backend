package com.microcore.center.mapper;

import com.microcore.center.model.DbArea;
import com.microcore.center.model.DbAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbAreaMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbAreaExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbAreaExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbArea record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbArea record);

    /**
     *
     * @mbggenerated
     */
    List<DbArea> selectByExample(DbAreaExample example);

    /**
     *
     * @mbggenerated
     */
    DbArea selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbArea record, @Param("example") DbAreaExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbArea record, @Param("example") DbAreaExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbArea record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbArea record);
}