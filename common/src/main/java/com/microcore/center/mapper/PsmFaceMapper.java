package com.microcore.center.mapper;

import com.microcore.center.model.PsmFace;
import com.microcore.center.model.PsmFaceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsmFaceMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(PsmFaceExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(PsmFaceExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(PsmFace record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PsmFace record);

    /**
     *
     * @mbggenerated
     */
    List<PsmFace> selectByExample(PsmFaceExample example);

    /**
     *
     * @mbggenerated
     */
    PsmFace selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PsmFace record, @Param("example") PsmFaceExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PsmFace record, @Param("example") PsmFaceExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PsmFace record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PsmFace record);
}