package com.rainyhon.common.mapper;

import com.rainyhon.common.model.WorkCheckTime;
import com.rainyhon.common.model.WorkCheckTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkCheckTimeMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(WorkCheckTimeExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(WorkCheckTimeExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(WorkCheckTime record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(WorkCheckTime record);

    /**
     *
     * @mbggenerated
     */
    List<WorkCheckTime> selectByExample(WorkCheckTimeExample example);

    /**
     *
     * @mbggenerated
     */
    WorkCheckTime selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") WorkCheckTime record, @Param("example") WorkCheckTimeExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") WorkCheckTime record, @Param("example") WorkCheckTimeExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(WorkCheckTime record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(WorkCheckTime record);
}