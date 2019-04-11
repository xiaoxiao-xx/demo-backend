package com.microcore.center.mapper;

import com.microcore.center.model.PsmScheduleDetail;
import com.microcore.center.model.PsmScheduleDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsmScheduleDetailMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(PsmScheduleDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(PsmScheduleDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(PsmScheduleDetail record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PsmScheduleDetail record);

    /**
     *
     * @mbggenerated
     */
    List<PsmScheduleDetail> selectByExample(PsmScheduleDetailExample example);

    /**
     *
     * @mbggenerated
     */
    PsmScheduleDetail selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PsmScheduleDetail record, @Param("example") PsmScheduleDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PsmScheduleDetail record, @Param("example") PsmScheduleDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PsmScheduleDetail record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PsmScheduleDetail record);
}