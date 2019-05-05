package com.rainyhon.common.mapper;

import com.rainyhon.common.model.UserRoleRelation;
import com.rainyhon.common.model.UserRoleRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleRelationMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(UserRoleRelationExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(UserRoleRelationExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(UserRoleRelation record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(UserRoleRelation record);

    /**
     *
     * @mbggenerated
     */
    List<UserRoleRelation> selectByExample(UserRoleRelationExample example);

    /**
     *
     * @mbggenerated
     */
    UserRoleRelation selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") UserRoleRelation record, @Param("example") UserRoleRelationExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") UserRoleRelation record, @Param("example") UserRoleRelationExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UserRoleRelation record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserRoleRelation record);
}