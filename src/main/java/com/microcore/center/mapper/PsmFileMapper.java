package com.microcore.center.mapper;

import com.microcore.center.model.PsmFile;
import com.microcore.center.model.PsmFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsmFileMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(PsmFileExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(PsmFileExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(PsmFile record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PsmFile record);

    /**
     *
     * @mbggenerated
     */
    List<PsmFile> selectByExample(PsmFileExample example);

    /**
     *
     * @mbggenerated
     */
    PsmFile selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PsmFile record, @Param("example") PsmFileExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PsmFile record, @Param("example") PsmFileExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PsmFile record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PsmFile record);
}