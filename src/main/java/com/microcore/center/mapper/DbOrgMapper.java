package com.microcore.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.microcore.api.model.DbOrg;
import com.microcore.center.model.DbOrgExample;

public interface DbOrgMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbOrgExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbOrgExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String orgId);

    /**
     *
     * @mbggenerated
     */
    int insert(DbOrg record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbOrg record);

    /**
     *
     * @mbggenerated
     */
    List<DbOrg> selectByExample(DbOrgExample example);

    /**
     *
     * @mbggenerated
     */
    DbOrg selectByPrimaryKey(String orgId);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbOrg record, @Param("example") DbOrgExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbOrg record, @Param("example") DbOrgExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbOrg record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbOrg record);
}