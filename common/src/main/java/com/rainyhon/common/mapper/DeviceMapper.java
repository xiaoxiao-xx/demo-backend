package com.rainyhon.common.mapper;

import com.rainyhon.common.model.Device;
import com.rainyhon.common.model.DeviceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DeviceExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DeviceExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String deviceId);

    /**
     *
     * @mbggenerated
     */
    int insert(Device record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(Device record);

    /**
     *
     * @mbggenerated
     */
    List<Device> selectByExample(DeviceExample example);

    /**
     *
     * @mbggenerated
     */
    Device selectByPrimaryKey(String deviceId);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Device record, @Param("example") DeviceExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Device record, @Param("example") DeviceExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Device record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Device record);
}