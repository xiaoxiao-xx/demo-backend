package com.microcore.center.mapper;

import com.microcore.center.model.PsmSrcRecord;
import com.microcore.center.model.PsmSrcRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsmSrcRecordMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(PsmSrcRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(PsmSrcRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int insert(PsmSrcRecord record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PsmSrcRecord record);

    /**
     *
     * @mbggenerated
     */
    List<PsmSrcRecord> selectByExample(PsmSrcRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PsmSrcRecord record, @Param("example") PsmSrcRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PsmSrcRecord record, @Param("example") PsmSrcRecordExample example);
}