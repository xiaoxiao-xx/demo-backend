package com.microcore.center.mapper;

import com.microcore.center.model.DbServiceParam;
import com.microcore.center.model.DbServiceParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbServiceParamMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbServiceParamExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbServiceParamExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbServiceParam record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbServiceParam record);

    /**
     *
     * @mbggenerated
     */
    List<DbServiceParam> selectByExample(DbServiceParamExample example);

    /**
     *
     * @mbggenerated
     */
    DbServiceParam selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbServiceParam record, @Param("example") DbServiceParamExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbServiceParam record, @Param("example") DbServiceParamExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbServiceParam record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbServiceParam record);
}