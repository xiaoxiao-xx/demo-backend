package com.rainyhon.common.mapper;

import com.rainyhon.common.model.DynamicQueryUnaryRelation;
import com.rainyhon.common.model.DynamicQueryUnaryRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DynamicQueryUnaryRelationMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DynamicQueryUnaryRelationExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DynamicQueryUnaryRelationExample example);

    /**
     *
     * @mbggenerated
     */
    int insert(DynamicQueryUnaryRelation record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DynamicQueryUnaryRelation record);

    /**
     *
     * @mbggenerated
     */
    List<DynamicQueryUnaryRelation> selectByExample(DynamicQueryUnaryRelationExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DynamicQueryUnaryRelation record, @Param("example") DynamicQueryUnaryRelationExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DynamicQueryUnaryRelation record, @Param("example") DynamicQueryUnaryRelationExample example);
}