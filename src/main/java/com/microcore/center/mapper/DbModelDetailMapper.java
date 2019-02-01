package com.microcore.center.mapper;

import com.microcore.center.model.DbModelDetail;
import com.microcore.center.model.DbModelDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbModelDetailMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbModelDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbModelDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbModelDetail record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbModelDetail record);

    /**
     *
     * @mbggenerated
     */
    List<DbModelDetail> selectByExample(DbModelDetailExample example);

    /**
     *
     * @mbggenerated
     */
    DbModelDetail selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbModelDetail record, @Param("example") DbModelDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbModelDetail record, @Param("example") DbModelDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbModelDetail record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbModelDetail record);
}