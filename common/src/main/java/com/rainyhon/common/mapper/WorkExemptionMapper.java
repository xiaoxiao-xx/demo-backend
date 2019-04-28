package com.rainyhon.common.mapper;

import com.rainyhon.common.model.WorkExemption;
import com.rainyhon.common.model.WorkExemptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkExemptionMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(WorkExemptionExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(WorkExemptionExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(WorkExemption record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(WorkExemption record);

    /**
     *
     * @mbggenerated
     */
    List<WorkExemption> selectByExample(WorkExemptionExample example);

    /**
     *
     * @mbggenerated
     */
    WorkExemption selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") WorkExemption record, @Param("example") WorkExemptionExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") WorkExemption record, @Param("example") WorkExemptionExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(WorkExemption record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(WorkExemption record);
}