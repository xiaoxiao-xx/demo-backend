package com.microcore.center.mapper;

import com.microcore.center.model.DbSubService;
import com.microcore.center.model.DbSubServiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbSubServiceMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbSubServiceExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbSubServiceExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbSubService record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbSubService record);

    /**
     *
     * @mbggenerated
     */
    List<DbSubService> selectByExample(DbSubServiceExample example);

    /**
     *
     * @mbggenerated
     */
    DbSubService selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbSubService record, @Param("example") DbSubServiceExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbSubService record, @Param("example") DbSubServiceExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbSubService record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbSubService record);
}