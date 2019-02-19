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
    int deleteByPrimaryKey(String id);

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
    PsmDealRes selectByPrimaryKey(String id);

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

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PsmDealRes record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PsmDealRes record);
}