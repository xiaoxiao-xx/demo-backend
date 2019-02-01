package com.microcore.center.mapper;

import com.microcore.center.model.DbModel;
import com.microcore.center.model.DbModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbModelMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbModelExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbModelExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbModel record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbModel record);

    /**
     *
     * @mbggenerated
     */
    List<DbModel> selectByExample(DbModelExample example);

    /**
     *
     * @mbggenerated
     */
    DbModel selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbModel record, @Param("example") DbModelExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbModel record, @Param("example") DbModelExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbModel record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbModel record);
}