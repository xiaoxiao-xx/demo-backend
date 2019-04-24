package com.microcore.center.mapper;

import com.microcore.center.model.DetectResult;
import com.microcore.center.model.DetectResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DetectResultMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DetectResultExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DetectResultExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DetectResult record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DetectResult record);

    /**
     *
     * @mbggenerated
     */
    List<DetectResult> selectByExampleWithBLOBs(DetectResultExample example);

    /**
     *
     * @mbggenerated
     */
    List<DetectResult> selectByExample(DetectResultExample example);

    /**
     *
     * @mbggenerated
     */
    DetectResult selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DetectResult record, @Param("example") DetectResultExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") DetectResult record, @Param("example") DetectResultExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DetectResult record, @Param("example") DetectResultExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DetectResult record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(DetectResult record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DetectResult record);
}