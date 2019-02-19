package com.microcore.center.mapper;

import com.microcore.center.model.PsmDealRes;
import com.microcore.center.model.PsmDealResExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsmDealResMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(PsmDealResExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(PsmDealResExample example);

    /**
     *
     * @mbggenerated
     */
    int insert(PsmDealRes record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PsmDealRes record);

    /**
     *
     * @mbggenerated
     */
    List<PsmDealRes> selectByExample(PsmDealResExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PsmDealRes record, @Param("example") PsmDealResExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PsmDealRes record, @Param("example") PsmDealResExample example);
}