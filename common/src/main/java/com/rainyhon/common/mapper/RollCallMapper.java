package com.rainyhon.common.mapper;

import com.rainyhon.common.model.RollCall;
import com.rainyhon.common.model.RollCallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RollCallMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(RollCallExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(RollCallExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(RollCall record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(RollCall record);

    /**
     *
     * @mbggenerated
     */
    List<RollCall> selectByExample(RollCallExample example);

    /**
     *
     * @mbggenerated
     */
    RollCall selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") RollCall record, @Param("example") RollCallExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") RollCall record, @Param("example") RollCallExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(RollCall record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(RollCall record);
}