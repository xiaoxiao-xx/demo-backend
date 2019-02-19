package com.microcore.center.mapper;

import com.microcore.center.model.PsmDeviceVersion;
import com.microcore.center.model.PsmDeviceVersionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsmDeviceVersionMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(PsmDeviceVersionExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(PsmDeviceVersionExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String devversionId);

    /**
     *
     * @mbggenerated
     */
    int insert(PsmDeviceVersion record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PsmDeviceVersion record);

    /**
     *
     * @mbggenerated
     */
    List<PsmDeviceVersion> selectByExample(PsmDeviceVersionExample example);

    /**
     *
     * @mbggenerated
     */
    PsmDeviceVersion selectByPrimaryKey(String devversionId);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PsmDeviceVersion record, @Param("example") PsmDeviceVersionExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PsmDeviceVersion record, @Param("example") PsmDeviceVersionExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PsmDeviceVersion record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PsmDeviceVersion record);
}