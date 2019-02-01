package com.microcore.center.mapper;

import com.microcore.center.model.EquipmentManage;
import com.microcore.center.model.EquipmentManageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EquipmentManageMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(EquipmentManageExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(EquipmentManageExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(EquipmentManage record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(EquipmentManage record);

    /**
     *
     * @mbggenerated
     */
    List<EquipmentManage> selectByExample(EquipmentManageExample example);

    /**
     *
     * @mbggenerated
     */
    EquipmentManage selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") EquipmentManage record, @Param("example") EquipmentManageExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") EquipmentManage record, @Param("example") EquipmentManageExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(EquipmentManage record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(EquipmentManage record);
}