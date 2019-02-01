package com.microcore.center.mapper;

import com.microcore.center.model.DbPolicyItem;
import com.microcore.center.model.DbPolicyItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbPolicyItemMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbPolicyItemExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbPolicyItemExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbPolicyItem record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbPolicyItem record);

    /**
     *
     * @mbggenerated
     */
    List<DbPolicyItem> selectByExample(DbPolicyItemExample example);

    /**
     *
     * @mbggenerated
     */
    DbPolicyItem selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbPolicyItem record, @Param("example") DbPolicyItemExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbPolicyItem record, @Param("example") DbPolicyItemExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbPolicyItem record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbPolicyItem record);
}