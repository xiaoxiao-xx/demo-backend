package com.microcore.center.mapper;

import com.microcore.center.model.DatePlan;
import com.microcore.center.model.DatePlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DatePlanMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DatePlanExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DatePlanExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DatePlan record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DatePlan record);

    /**
     *
     * @mbggenerated
     */
    List<DatePlan> selectByExample(DatePlanExample example);

    /**
     *
     * @mbggenerated
     */
    DatePlan selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DatePlan record, @Param("example") DatePlanExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DatePlan record, @Param("example") DatePlanExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DatePlan record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DatePlan record);
}