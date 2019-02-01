package com.microcore.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.microcore.api.model.DbLabelKit;
import com.microcore.center.model.DbLabelKitExample;

public interface DbLabelKitMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbLabelKitExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbLabelKitExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbLabelKit record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbLabelKit record);

    /**
     *
     * @mbggenerated
     */
    List<DbLabelKit> selectByExample(DbLabelKitExample example);

    /**
     *
     * @mbggenerated
     */
    DbLabelKit selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbLabelKit record, @Param("example") DbLabelKitExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbLabelKit record, @Param("example") DbLabelKitExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbLabelKit record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbLabelKit record);
}