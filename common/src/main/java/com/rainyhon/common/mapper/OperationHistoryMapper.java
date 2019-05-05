package com.rainyhon.common.mapper;

import com.rainyhon.common.model.OperationHistory;
import com.rainyhon.common.model.OperationHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationHistoryMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(OperationHistoryExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(OperationHistoryExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(OperationHistory record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(OperationHistory record);

    /**
     *
     * @mbggenerated
     */
    List<OperationHistory> selectByExample(OperationHistoryExample example);

    /**
     *
     * @mbggenerated
     */
    OperationHistory selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") OperationHistory record, @Param("example") OperationHistoryExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") OperationHistory record, @Param("example") OperationHistoryExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(OperationHistory record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OperationHistory record);
}