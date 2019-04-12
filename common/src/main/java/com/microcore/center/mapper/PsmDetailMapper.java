package com.microcore.center.mapper;

import com.microcore.center.model.PsmDetail;
import com.microcore.center.model.PsmDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsmDetailMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(PsmDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(PsmDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(PsmDetail record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PsmDetail record);

    /**
     *
     * @mbggenerated
     */
    List<PsmDetail> selectByExample(PsmDetailExample example);

    /**
     *
     * @mbggenerated
     */
    PsmDetail selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PsmDetail record, @Param("example") PsmDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PsmDetail record, @Param("example") PsmDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PsmDetail record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PsmDetail record);
}