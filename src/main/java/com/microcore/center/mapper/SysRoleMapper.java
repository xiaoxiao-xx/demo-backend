package com.microcore.center.mapper;

import com.microcore.center.model.SysRole;
import com.microcore.center.model.SysRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(SysRoleExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(SysRoleExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int insert(SysRole record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(SysRole record);

    /**
     *
     * @mbggenerated
     */
    List<SysRole> selectByExample(SysRoleExample example);

    /**
     *
     * @mbggenerated
     */
    SysRole selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysRole record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysRole record);
}