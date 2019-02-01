package com.microcore.center.mapper;

import com.microcore.center.model.DbExtTemplate;
import com.microcore.center.model.DbExtTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbExtTemplateMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbExtTemplateExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbExtTemplateExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbExtTemplate record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbExtTemplate record);

    /**
     *
     * @mbggenerated
     */
    List<DbExtTemplate> selectByExample(DbExtTemplateExample example);

    /**
     *
     * @mbggenerated
     */
    DbExtTemplate selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbExtTemplate record, @Param("example") DbExtTemplateExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbExtTemplate record, @Param("example") DbExtTemplateExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbExtTemplate record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbExtTemplate record);
}