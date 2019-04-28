package com.rainyhon.common.mapper;

import com.rainyhon.common.model.DynamicQueryUnary;
import com.rainyhon.common.model.DynamicQueryUnaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DynamicQueryUnaryMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DynamicQueryUnaryExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DynamicQueryUnaryExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DynamicQueryUnary record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DynamicQueryUnary record);

    /**
     *
     * @mbggenerated
     */
    List<DynamicQueryUnary> selectByExample(DynamicQueryUnaryExample example);

    /**
     *
     * @mbggenerated
     */
    DynamicQueryUnary selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DynamicQueryUnary record, @Param("example") DynamicQueryUnaryExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DynamicQueryUnary record, @Param("example") DynamicQueryUnaryExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DynamicQueryUnary record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DynamicQueryUnary record);
}