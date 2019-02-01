package com.microcore.center.mapper;

import com.microcore.center.model.DbPolicyTemplate;
import com.microcore.center.model.DbPolicyTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbPolicyTemplateMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbPolicyTemplateExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbPolicyTemplateExample example);

    /**
     *
     * @mbggenerated
     */
    int insert(DbPolicyTemplate record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbPolicyTemplate record);

    /**
     *
     * @mbggenerated
     */
    List<DbPolicyTemplate> selectByExample(DbPolicyTemplateExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbPolicyTemplate record, @Param("example") DbPolicyTemplateExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbPolicyTemplate record, @Param("example") DbPolicyTemplateExample example);
}