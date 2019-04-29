package com.rainyhon.common.mapper;

import com.rainyhon.common.model.AlarmPolicy;
import com.rainyhon.common.model.AlarmPolicyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlarmPolicyMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AlarmPolicyExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AlarmPolicyExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(AlarmPolicy record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AlarmPolicy record);

    /**
     *
     * @mbggenerated
     */
    List<AlarmPolicy> selectByExample(AlarmPolicyExample example);

    /**
     *
     * @mbggenerated
     */
    AlarmPolicy selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AlarmPolicy record, @Param("example") AlarmPolicyExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AlarmPolicy record, @Param("example") AlarmPolicyExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AlarmPolicy record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AlarmPolicy record);
}