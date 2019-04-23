package com.microcore.center.mapper;

import com.microcore.center.model.PermissionResourceRelation;
import com.microcore.center.model.PermissionResourceRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionResourceRelationMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(PermissionResourceRelationExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(PermissionResourceRelationExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(PermissionResourceRelation record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PermissionResourceRelation record);

    /**
     *
     * @mbggenerated
     */
    List<PermissionResourceRelation> selectByExample(PermissionResourceRelationExample example);

    /**
     *
     * @mbggenerated
     */
    PermissionResourceRelation selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PermissionResourceRelation record, @Param("example") PermissionResourceRelationExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PermissionResourceRelation record, @Param("example") PermissionResourceRelationExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PermissionResourceRelation record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PermissionResourceRelation record);
}