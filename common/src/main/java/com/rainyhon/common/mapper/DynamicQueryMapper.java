package com.rainyhon.common.mapper;

import com.rainyhon.common.model.DynamicQuery;
import com.rainyhon.common.model.DynamicQueryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DynamicQueryMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DynamicQueryExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DynamicQueryExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DynamicQuery record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DynamicQuery record);

    /**
     *
     * @mbggenerated
     */
    List<DynamicQuery> selectByExample(DynamicQueryExample example);

    /**
     *
     * @mbggenerated
     */
    DynamicQuery selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DynamicQuery record, @Param("example") DynamicQueryExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DynamicQuery record, @Param("example") DynamicQueryExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DynamicQuery record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DynamicQuery record);
}