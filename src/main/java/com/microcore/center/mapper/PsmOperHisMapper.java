package com.microcore.center.mapper;

import com.microcore.center.model.PsmOperHis;
import com.microcore.center.model.PsmOperHisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsmOperHisMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(PsmOperHisExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(PsmOperHisExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(PsmOperHis record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PsmOperHis record);

    /**
     *
     * @mbggenerated
     */
    List<PsmOperHis> selectByExample(PsmOperHisExample example);

    /**
     *
     * @mbggenerated
     */
    PsmOperHis selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PsmOperHis record, @Param("example") PsmOperHisExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PsmOperHis record, @Param("example") PsmOperHisExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PsmOperHis record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PsmOperHis record);
}