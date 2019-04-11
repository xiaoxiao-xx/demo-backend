package com.microcore.center.mapper;

import com.microcore.center.model.PsmArea;
import com.microcore.center.model.PsmAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsmAreaMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(PsmAreaExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(PsmAreaExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(PsmArea record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PsmArea record);

    /**
     *
     * @mbggenerated
     */
    List<PsmArea> selectByExample(PsmAreaExample example);

    /**
     *
     * @mbggenerated
     */
    PsmArea selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PsmArea record, @Param("example") PsmAreaExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PsmArea record, @Param("example") PsmAreaExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PsmArea record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PsmArea record);
}