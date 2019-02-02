package com.microcore.center.mapper;

import com.microcore.center.model.EquipmentHistory;
import com.microcore.center.model.EquipmentHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EquipmentHistoryMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(EquipmentHistoryExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(EquipmentHistoryExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(EquipmentHistory record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(EquipmentHistory record);

    /**
     *
     * @mbggenerated
     */
    List<EquipmentHistory> selectByExample(EquipmentHistoryExample example);

    /**
     *
     * @mbggenerated
     */
    EquipmentHistory selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") EquipmentHistory record, @Param("example") EquipmentHistoryExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") EquipmentHistory record, @Param("example") EquipmentHistoryExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(EquipmentHistory record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(EquipmentHistory record);
}