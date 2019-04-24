package com.microcore.center.mapper;

import com.microcore.center.model.Face;
import com.microcore.center.model.FaceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FaceMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(FaceExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(FaceExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(Face record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(Face record);

    /**
     *
     * @mbggenerated
     */
    List<Face> selectByExample(FaceExample example);

    /**
     *
     * @mbggenerated
     */
    Face selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Face record, @Param("example") FaceExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Face record, @Param("example") FaceExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Face record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Face record);
}