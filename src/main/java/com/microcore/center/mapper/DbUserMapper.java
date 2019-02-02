package com.microcore.center.mapper;

import com.microcore.center.model.DbUser;
import com.microcore.center.model.DbUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbUserMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbUserExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbUserExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbUser record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbUser record);

    /**
     *
     * @mbggenerated
     */
    List<DbUser> selectByExample(DbUserExample example);

    /**
     *
     * @mbggenerated
     */
    DbUser selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbUser record, @Param("example") DbUserExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbUser record, @Param("example") DbUserExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbUser record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbUser record);
}