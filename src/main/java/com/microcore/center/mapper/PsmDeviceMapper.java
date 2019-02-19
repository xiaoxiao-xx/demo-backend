package com.microcore.center.mapper;

import com.microcore.center.model.PsmDevice;
import com.microcore.center.model.PsmDeviceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsmDeviceMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(PsmDeviceExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(PsmDeviceExample example);

    /**
     *
     * @mbggenerated
     */
    int insert(PsmDevice record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PsmDevice record);

    /**
     *
     * @mbggenerated
     */
    List<PsmDevice> selectByExample(PsmDeviceExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PsmDevice record, @Param("example") PsmDeviceExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PsmDevice record, @Param("example") PsmDeviceExample example);
}