package com.microcore.center.mapper;

import com.microcore.center.model.Resource;
import com.microcore.center.model.ResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ResourceExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ResourceExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(Resource record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(Resource record);

    /**
     *
     * @mbggenerated
     */
    List<Resource> selectByExample(ResourceExample example);

    /**
     *
     * @mbggenerated
     */
    Resource selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Resource record, @Param("example") ResourceExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Resource record, @Param("example") ResourceExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Resource record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Resource record);
}