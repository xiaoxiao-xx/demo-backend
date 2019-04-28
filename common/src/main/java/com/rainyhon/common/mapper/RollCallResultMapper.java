package com.rainyhon.common.mapper;

import com.rainyhon.common.model.RollCallResult;
import com.rainyhon.common.model.RollCallResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RollCallResultMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(RollCallResultExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(RollCallResultExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(RollCallResult record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(RollCallResult record);

    /**
     *
     * @mbggenerated
     */
    List<RollCallResult> selectByExample(RollCallResultExample example);

    /**
     *
     * @mbggenerated
     */
    RollCallResult selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") RollCallResult record, @Param("example") RollCallResultExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") RollCallResult record, @Param("example") RollCallResultExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(RollCallResult record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(RollCallResult record);
}