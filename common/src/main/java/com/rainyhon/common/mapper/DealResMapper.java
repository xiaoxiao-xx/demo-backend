package com.rainyhon.common.mapper;

import com.rainyhon.common.model.DealRes;
import com.rainyhon.common.model.DealResExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DealResMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DealResExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DealResExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DealRes record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DealRes record);

    /**
     *
     * @mbggenerated
     */
    List<DealRes> selectByExample(DealResExample example);

    /**
     *
     * @mbggenerated
     */
    DealRes selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DealRes record, @Param("example") DealResExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DealRes record, @Param("example") DealResExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DealRes record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DealRes record);
}