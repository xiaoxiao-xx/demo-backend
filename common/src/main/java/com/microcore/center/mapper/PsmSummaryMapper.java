package com.microcore.center.mapper;

import com.microcore.center.model.PsmSummary;
import com.microcore.center.model.PsmSummaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsmSummaryMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(PsmSummaryExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(PsmSummaryExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(PsmSummary record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PsmSummary record);

    /**
     *
     * @mbggenerated
     */
    List<PsmSummary> selectByExample(PsmSummaryExample example);

    /**
     *
     * @mbggenerated
     */
    PsmSummary selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PsmSummary record, @Param("example") PsmSummaryExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PsmSummary record, @Param("example") PsmSummaryExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PsmSummary record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PsmSummary record);
}