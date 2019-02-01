package com.microcore.center.mapper;

import com.microcore.center.model.SysUserRole;
import com.microcore.center.model.SysUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserRoleMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(SysUserRoleExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(SysUserRoleExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(SysUserRole record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(SysUserRole record);

    /**
     *
     * @mbggenerated
     */
    List<SysUserRole> selectByExample(SysUserRoleExample example);

    /**
     *
     * @mbggenerated
     */
    SysUserRole selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysUserRole record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysUserRole record);
}