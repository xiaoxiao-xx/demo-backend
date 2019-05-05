package com.rainyhon.common.mapper;

import com.rainyhon.common.model.Detail;
import com.rainyhon.common.model.DetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DetailMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DetailExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DetailExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(Detail record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(Detail record);

    /**
     *
     * @mbggenerated
     */
    List<Detail> selectByExample(DetailExample example);

    /**
     *
     * @mbggenerated
     */
    Detail selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Detail record, @Param("example") DetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Detail record, @Param("example") DetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Detail record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Detail record);
}