package com.microcore.center.mapper;

import com.microcore.center.model.PsmAlarmMode;
import com.microcore.center.model.PsmAlarmModeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsmAlarmModeMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(PsmAlarmModeExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(PsmAlarmModeExample example);

    /**
     *
     * @mbggenerated
     */
    int insert(PsmAlarmMode record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PsmAlarmMode record);

    /**
     *
     * @mbggenerated
     */
    List<PsmAlarmMode> selectByExample(PsmAlarmModeExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PsmAlarmMode record, @Param("example") PsmAlarmModeExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PsmAlarmMode record, @Param("example") PsmAlarmModeExample example);
}