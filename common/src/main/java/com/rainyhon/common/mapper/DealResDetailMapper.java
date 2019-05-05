package com.rainyhon.common.mapper;

import com.rainyhon.common.model.DealResDetail;
import com.rainyhon.common.model.DealResDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DealResDetailMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DealResDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DealResDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String resId);

    /**
     *
     * @mbggenerated
     */
    int insert(DealResDetail record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DealResDetail record);

    /**
     *
     * @mbggenerated
     */
    List<DealResDetail> selectByExample(DealResDetailExample example);

    /**
     *
     * @mbggenerated
     */
    DealResDetail selectByPrimaryKey(String resId);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DealResDetail record, @Param("example") DealResDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DealResDetail record, @Param("example") DealResDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DealResDetail record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DealResDetail record);
}