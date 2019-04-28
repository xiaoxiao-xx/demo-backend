package com.rainyhon.common.mapper;

import com.rainyhon.common.model.ScheduleDetail;
import com.rainyhon.common.model.ScheduleDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScheduleDetailMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ScheduleDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ScheduleDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(ScheduleDetail record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(ScheduleDetail record);

    /**
     *
     * @mbggenerated
     */
    List<ScheduleDetail> selectByExample(ScheduleDetailExample example);

    /**
     *
     * @mbggenerated
     */
    ScheduleDetail selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ScheduleDetail record, @Param("example") ScheduleDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ScheduleDetail record, @Param("example") ScheduleDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ScheduleDetail record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ScheduleDetail record);
}