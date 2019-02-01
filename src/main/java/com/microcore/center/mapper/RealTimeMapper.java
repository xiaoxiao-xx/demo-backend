package com.microcore.center.mapper;


import com.microcore.center.model.RealTime;
import com.microcore.center.model.RealTimeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RealTimeMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(RealTimeExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(RealTimeExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(RealTime record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(RealTime record);

    /**
     *
     * @mbggenerated
     */
    List<RealTime> selectByExample(RealTimeExample example);

    /**
     *
     * @mbggenerated
     */
    RealTime selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") RealTime record, @Param("example") RealTimeExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") RealTime record, @Param("example") RealTimeExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(RealTime record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(RealTime record);
}