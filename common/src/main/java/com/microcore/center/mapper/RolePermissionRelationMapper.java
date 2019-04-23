package com.microcore.center.mapper;

import com.microcore.center.model.RolePermissionRelation;
import com.microcore.center.model.RolePermissionRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionRelationMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(RolePermissionRelationExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(RolePermissionRelationExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(RolePermissionRelation record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(RolePermissionRelation record);

    /**
     *
     * @mbggenerated
     */
    List<RolePermissionRelation> selectByExample(RolePermissionRelationExample example);

    /**
     *
     * @mbggenerated
     */
    RolePermissionRelation selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") RolePermissionRelation record, @Param("example") RolePermissionRelationExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") RolePermissionRelation record, @Param("example") RolePermissionRelationExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(RolePermissionRelation record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(RolePermissionRelation record);
}