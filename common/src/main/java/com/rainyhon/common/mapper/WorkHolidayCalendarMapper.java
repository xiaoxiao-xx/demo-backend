package com.rainyhon.common.mapper;

import com.rainyhon.common.model.WorkHolidayCalendar;
import com.rainyhon.common.model.WorkHolidayCalendarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkHolidayCalendarMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(WorkHolidayCalendarExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(WorkHolidayCalendarExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(WorkHolidayCalendar record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(WorkHolidayCalendar record);

    /**
     *
     * @mbggenerated
     */
    List<WorkHolidayCalendar> selectByExample(WorkHolidayCalendarExample example);

    /**
     *
     * @mbggenerated
     */
    WorkHolidayCalendar selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") WorkHolidayCalendar record, @Param("example") WorkHolidayCalendarExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") WorkHolidayCalendar record, @Param("example") WorkHolidayCalendarExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(WorkHolidayCalendar record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(WorkHolidayCalendar record);
}