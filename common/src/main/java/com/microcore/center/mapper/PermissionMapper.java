package com.microcore.center.mapper;

import com.microcore.center.model.Permission;
import com.microcore.center.model.PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(PermissionExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(PermissionExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(Permission record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(Permission record);

    /**
     *
     * @mbggenerated
     */
    List<Permission> selectByExample(PermissionExample example);

    /**
     *
     * @mbggenerated
     */
    Permission selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Permission record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Permission record);
}