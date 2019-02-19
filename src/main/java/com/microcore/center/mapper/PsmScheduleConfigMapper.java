package com.microcore.center.mapper;

import com.microcore.center.model.PsmScheduleConfig;
import com.microcore.center.model.PsmScheduleConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsmScheduleConfigMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(PsmScheduleConfigExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(PsmScheduleConfigExample example);

    /**
     *
     * @mbggenerated
     */
    int insert(PsmScheduleConfig record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PsmScheduleConfig record);

    /**
     *
     * @mbggenerated
     */
    List<PsmScheduleConfig> selectByExample(PsmScheduleConfigExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PsmScheduleConfig record, @Param("example") PsmScheduleConfigExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PsmScheduleConfig record, @Param("example") PsmScheduleConfigExample example);
}