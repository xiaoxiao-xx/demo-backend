package com.rainyhon.common.mapper;

import com.rainyhon.common.model.DynamicQueryColumn;
import com.rainyhon.common.model.DynamicQueryColumnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DynamicQueryColumnMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DynamicQueryColumnExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DynamicQueryColumnExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DynamicQueryColumn record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DynamicQueryColumn record);

    /**
     *
     * @mbggenerated
     */
    List<DynamicQueryColumn> selectByExample(DynamicQueryColumnExample example);

    /**
     *
     * @mbggenerated
     */
    DynamicQueryColumn selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DynamicQueryColumn record, @Param("example") DynamicQueryColumnExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DynamicQueryColumn record, @Param("example") DynamicQueryColumnExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DynamicQueryColumn record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DynamicQueryColumn record);
}