package com.rainyhon.common.mapper;

import com.rainyhon.common.model.DeviceVersion;
import com.rainyhon.common.model.DeviceVersionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceVersionMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DeviceVersionExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DeviceVersionExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String devversionId);

    /**
     *
     * @mbggenerated
     */
    int insert(DeviceVersion record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DeviceVersion record);

    /**
     *
     * @mbggenerated
     */
    List<DeviceVersion> selectByExample(DeviceVersionExample example);

    /**
     *
     * @mbggenerated
     */
    DeviceVersion selectByPrimaryKey(String devversionId);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DeviceVersion record, @Param("example") DeviceVersionExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DeviceVersion record, @Param("example") DeviceVersionExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DeviceVersion record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DeviceVersion record);
}