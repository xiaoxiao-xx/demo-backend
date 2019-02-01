package com.microcore.center.mapper;

import com.microcore.center.model.DbOrgAreaRel;
import com.microcore.center.model.DbOrgAreaRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbOrgAreaRelMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbOrgAreaRelExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbOrgAreaRelExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbOrgAreaRel record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbOrgAreaRel record);

    /**
     *
     * @mbggenerated
     */
    List<DbOrgAreaRel> selectByExample(DbOrgAreaRelExample example);

    /**
     *
     * @mbggenerated
     */
    DbOrgAreaRel selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbOrgAreaRel record, @Param("example") DbOrgAreaRelExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbOrgAreaRel record, @Param("example") DbOrgAreaRelExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbOrgAreaRel record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbOrgAreaRel record);
}