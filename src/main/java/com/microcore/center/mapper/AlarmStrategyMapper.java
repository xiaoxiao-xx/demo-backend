package com.microcore.center.mapper;

import com.microcore.center.model.AlarmStrategy;
import com.microcore.center.model.AlarmStrategyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AlarmStrategyMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AlarmStrategyExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AlarmStrategyExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(AlarmStrategy record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AlarmStrategy record);

    /**
     *
     * @mbggenerated
     */
    List<AlarmStrategy> selectByExample(AlarmStrategyExample example);

    /**
     *
     * @mbggenerated
     */
    AlarmStrategy selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AlarmStrategy record, @Param("example") AlarmStrategyExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AlarmStrategy record, @Param("example") AlarmStrategyExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AlarmStrategy record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AlarmStrategy record);
}