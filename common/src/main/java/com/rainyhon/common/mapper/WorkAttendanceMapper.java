package com.rainyhon.common.mapper;

import com.rainyhon.common.model.WorkAttendance;
import com.rainyhon.common.model.WorkAttendanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkAttendanceMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(WorkAttendanceExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(WorkAttendanceExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(WorkAttendance record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(WorkAttendance record);

    /**
     *
     * @mbggenerated
     */
    List<WorkAttendance> selectByExample(WorkAttendanceExample example);

    /**
     *
     * @mbggenerated
     */
    WorkAttendance selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") WorkAttendance record, @Param("example") WorkAttendanceExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") WorkAttendance record, @Param("example") WorkAttendanceExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(WorkAttendance record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(WorkAttendance record);
}