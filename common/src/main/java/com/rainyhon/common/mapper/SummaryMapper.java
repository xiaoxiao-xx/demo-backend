package com.rainyhon.common.mapper;

import com.rainyhon.common.model.Summary;
import com.rainyhon.common.model.SummaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SummaryMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(SummaryExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(SummaryExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(Summary record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(Summary record);

    /**
     *
     * @mbggenerated
     */
    List<Summary> selectByExample(SummaryExample example);

    /**
     *
     * @mbggenerated
     */
    Summary selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Summary record, @Param("example") SummaryExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Summary record, @Param("example") SummaryExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Summary record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Summary record);
}