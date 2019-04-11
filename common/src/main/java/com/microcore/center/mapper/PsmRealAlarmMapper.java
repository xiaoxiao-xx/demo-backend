package com.microcore.center.mapper;

import com.microcore.center.model.PsmRealAlarm;
import com.microcore.center.model.PsmRealAlarmExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsmRealAlarmMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(PsmRealAlarmExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(PsmRealAlarmExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(PsmRealAlarm record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PsmRealAlarm record);

    /**
     *
     * @mbggenerated
     */
    List<PsmRealAlarm> selectByExample(PsmRealAlarmExample example);

    /**
     *
     * @mbggenerated
     */
    PsmRealAlarm selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PsmRealAlarm record, @Param("example") PsmRealAlarmExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PsmRealAlarm record, @Param("example") PsmRealAlarmExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PsmRealAlarm record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PsmRealAlarm record);
}