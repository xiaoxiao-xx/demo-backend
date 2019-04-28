package com.rainyhon.common.mapper;

import com.rainyhon.common.model.ScheduleConfig;
import com.rainyhon.common.model.ScheduleConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScheduleConfigMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ScheduleConfigExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ScheduleConfigExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(ScheduleConfig record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(ScheduleConfig record);

    /**
     *
     * @mbggenerated
     */
    List<ScheduleConfig> selectByExample(ScheduleConfigExample example);

    /**
     *
     * @mbggenerated
     */
    ScheduleConfig selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ScheduleConfig record, @Param("example") ScheduleConfigExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ScheduleConfig record, @Param("example") ScheduleConfigExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ScheduleConfig record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ScheduleConfig record);
}