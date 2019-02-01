package com.microcore.center.mapper;

import com.microcore.center.model.DbTableCnf;
import com.microcore.center.model.DbTableCnfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbTableCnfMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbTableCnfExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbTableCnfExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbTableCnf record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbTableCnf record);

    /**
     *
     * @mbggenerated
     */
    List<DbTableCnf> selectByExample(DbTableCnfExample example);

    /**
     *
     * @mbggenerated
     */
    DbTableCnf selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbTableCnf record, @Param("example") DbTableCnfExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbTableCnf record, @Param("example") DbTableCnfExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbTableCnf record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbTableCnf record);
}