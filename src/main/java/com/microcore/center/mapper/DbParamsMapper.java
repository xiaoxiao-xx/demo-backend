package com.microcore.center.mapper;

import com.microcore.center.model.DbParams;
import com.microcore.center.model.DbParamsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbParamsMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbParamsExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbParamsExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbParams record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbParams record);

    /**
     *
     * @mbggenerated
     */
    List<DbParams> selectByExample(DbParamsExample example);

    /**
     *
     * @mbggenerated
     */
    DbParams selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbParams record, @Param("example") DbParamsExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbParams record, @Param("example") DbParamsExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbParams record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbParams record);
}