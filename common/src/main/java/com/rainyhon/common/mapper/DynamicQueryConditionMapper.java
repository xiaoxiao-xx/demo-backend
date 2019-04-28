package com.rainyhon.common.mapper;

import com.rainyhon.common.model.DynamicQueryCondition;
import com.rainyhon.common.model.DynamicQueryConditionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DynamicQueryConditionMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DynamicQueryConditionExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DynamicQueryConditionExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DynamicQueryCondition record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DynamicQueryCondition record);

    /**
     *
     * @mbggenerated
     */
    List<DynamicQueryCondition> selectByExample(DynamicQueryConditionExample example);

    /**
     *
     * @mbggenerated
     */
    DynamicQueryCondition selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DynamicQueryCondition record, @Param("example") DynamicQueryConditionExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DynamicQueryCondition record, @Param("example") DynamicQueryConditionExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DynamicQueryCondition record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DynamicQueryCondition record);
}