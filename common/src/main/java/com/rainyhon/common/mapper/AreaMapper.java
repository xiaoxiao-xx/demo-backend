package com.rainyhon.common.mapper;

import com.rainyhon.common.model.Area;
import com.rainyhon.common.model.AreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AreaMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AreaExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AreaExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(Area record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(Area record);

    /**
     *
     * @mbggenerated
     */
    List<Area> selectByExample(AreaExample example);

    /**
     *
     * @mbggenerated
     */
    Area selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Area record, @Param("example") AreaExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Area record, @Param("example") AreaExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Area record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Area record);
}