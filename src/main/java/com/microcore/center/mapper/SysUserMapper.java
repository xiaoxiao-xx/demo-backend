package com.microcore.center.mapper;

import com.microcore.center.model.SysUser;
import com.microcore.center.model.SysUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysUserMapper {

    @Select("select * from sys_user")
    List<SysUser> findAll();
    /**
     *
     * @mbggenerated
     */
    int countByExample(SysUserExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(SysUserExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(SysUser record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(SysUser record);

    /**
     *
     * @mbggenerated
     */
    List<SysUser> selectByExample(SysUserExample example);

    /**
     *
     * @mbggenerated
     */
    SysUser selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysUser record);
}