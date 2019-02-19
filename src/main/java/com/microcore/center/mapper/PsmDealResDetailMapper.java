package com.microcore.center.mapper;

import com.microcore.center.model.PsmDealResDetail;
import com.microcore.center.model.PsmDealResDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsmDealResDetailMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(PsmDealResDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(PsmDealResDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int insert(PsmDealResDetail record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PsmDealResDetail record);

    /**
     *
     * @mbggenerated
     */
    List<PsmDealResDetail> selectByExample(PsmDealResDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PsmDealResDetail record, @Param("example") PsmDealResDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PsmDealResDetail record, @Param("example") PsmDealResDetailExample example);
}