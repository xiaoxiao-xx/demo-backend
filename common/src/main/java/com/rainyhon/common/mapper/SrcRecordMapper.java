package com.rainyhon.common.mapper;

import com.rainyhon.common.model.SrcRecord;
import com.rainyhon.common.model.SrcRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SrcRecordMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(SrcRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(SrcRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(SrcRecord record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(SrcRecord record);

    /**
     *
     * @mbggenerated
     */
    List<SrcRecord> selectByExample(SrcRecordExample example);

    /**
     *
     * @mbggenerated
     */
    SrcRecord selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SrcRecord record, @Param("example") SrcRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SrcRecord record, @Param("example") SrcRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SrcRecord record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SrcRecord record);
}