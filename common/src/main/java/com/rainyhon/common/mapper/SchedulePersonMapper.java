package com.rainyhon.common.mapper;

import com.rainyhon.common.model.SchedulePerson;
import com.rainyhon.common.model.SchedulePersonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SchedulePersonMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(SchedulePersonExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(SchedulePersonExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(SchedulePerson record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(SchedulePerson record);

    /**
     *
     * @mbggenerated
     */
    List<SchedulePerson> selectByExample(SchedulePersonExample example);

    /**
     *
     * @mbggenerated
     */
    SchedulePerson selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SchedulePerson record, @Param("example") SchedulePersonExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SchedulePerson record, @Param("example") SchedulePersonExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SchedulePerson record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SchedulePerson record);
}