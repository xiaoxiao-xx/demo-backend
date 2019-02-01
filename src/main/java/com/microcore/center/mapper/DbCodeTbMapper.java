package com.microcore.center.mapper;

import com.microcore.center.model.DbCodeTb;
import com.microcore.center.model.DbCodeTbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbCodeTbMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbCodeTbExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbCodeTbExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbCodeTb record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbCodeTb record);

    /**
     *
     * @mbggenerated
     */
    List<DbCodeTb> selectByExample(DbCodeTbExample example);

    /**
     *
     * @mbggenerated
     */
    DbCodeTb selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbCodeTb record, @Param("example") DbCodeTbExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbCodeTb record, @Param("example") DbCodeTbExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbCodeTb record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbCodeTb record);
}