package com.microcore.center.mapper;

import com.microcore.center.model.InOutRecord;
import com.microcore.center.model.InOutRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InOutRecordMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(InOutRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(InOutRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(InOutRecord record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(InOutRecord record);

    /**
     *
     * @mbggenerated
     */
    List<InOutRecord> selectByExample(InOutRecordExample example);

    /**
     *
     * @mbggenerated
     */
    InOutRecord selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") InOutRecord record, @Param("example") InOutRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") InOutRecord record, @Param("example") InOutRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(InOutRecord record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(InOutRecord record);
}