package com.microcore.center.mapper;

import com.microcore.center.model.Role;
import com.microcore.center.model.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(RoleExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(RoleExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(Role record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(Role record);

    /**
     *
     * @mbggenerated
     */
    List<Role> selectByExample(RoleExample example);

    /**
     *
     * @mbggenerated
     */
    Role selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Role record);
}