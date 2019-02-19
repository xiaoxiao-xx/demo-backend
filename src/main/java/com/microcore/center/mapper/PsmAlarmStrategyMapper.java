package com.microcore.center.mapper;

import com.microcore.center.model.PsmAlarmStrategy;
import com.microcore.center.model.PsmAlarmStrategyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsmAlarmStrategyMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(PsmAlarmStrategyExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(PsmAlarmStrategyExample example);

    /**
     *
     * @mbggenerated
     */
    int insert(PsmAlarmStrategy record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PsmAlarmStrategy record);

    /**
     *
     * @mbggenerated
     */
    List<PsmAlarmStrategy> selectByExample(PsmAlarmStrategyExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PsmAlarmStrategy record, @Param("example") PsmAlarmStrategyExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PsmAlarmStrategy record, @Param("example") PsmAlarmStrategyExample example);
}