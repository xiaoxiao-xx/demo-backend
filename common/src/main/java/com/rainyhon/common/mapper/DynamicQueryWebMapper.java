package com.rainyhon.common.mapper;

import com.rainyhon.common.model.DynamicQueryWeb;
import com.rainyhon.common.model.DynamicQueryWebExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DynamicQueryWebMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DynamicQueryWebExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DynamicQueryWebExample example);

    /**
     *
     * @mbggenerated
     */
    int insert(DynamicQueryWeb record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DynamicQueryWeb record);

    /**
     *
     * @mbggenerated
     */
    List<DynamicQueryWeb> selectByExampleWithBLOBs(DynamicQueryWebExample example);

    /**
     *
     * @mbggenerated
     */
    List<DynamicQueryWeb> selectByExample(DynamicQueryWebExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DynamicQueryWeb record, @Param("example") DynamicQueryWebExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") DynamicQueryWeb record, @Param("example") DynamicQueryWebExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DynamicQueryWeb record, @Param("example") DynamicQueryWebExample example);
}