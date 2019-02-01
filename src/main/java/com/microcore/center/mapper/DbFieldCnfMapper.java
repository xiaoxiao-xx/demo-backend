package com.microcore.center.mapper;

import com.microcore.center.model.DbFieldCnf;
import com.microcore.center.model.DbFieldCnfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbFieldCnfMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbFieldCnfExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbFieldCnfExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbFieldCnf record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbFieldCnf record);

    /**
     *
     * @mbggenerated
     */
    List<DbFieldCnf> selectByExample(DbFieldCnfExample example);

    /**
     *
     * @mbggenerated
     */
    DbFieldCnf selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbFieldCnf record, @Param("example") DbFieldCnfExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbFieldCnf record, @Param("example") DbFieldCnfExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbFieldCnf record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbFieldCnf record);
}