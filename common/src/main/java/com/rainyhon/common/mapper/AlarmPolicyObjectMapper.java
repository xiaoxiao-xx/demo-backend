package com.rainyhon.common.mapper;

import com.rainyhon.common.model.AlarmPolicyObject;
import com.rainyhon.common.model.AlarmPolicyObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlarmPolicyObjectMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AlarmPolicyObjectExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AlarmPolicyObjectExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String policyId);

    /**
     *
     * @mbggenerated
     */
    int insert(AlarmPolicyObject record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AlarmPolicyObject record);

    /**
     *
     * @mbggenerated
     */
    List<AlarmPolicyObject> selectByExample(AlarmPolicyObjectExample example);

    /**
     *
     * @mbggenerated
     */
    AlarmPolicyObject selectByPrimaryKey(String policyId);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AlarmPolicyObject record, @Param("example") AlarmPolicyObjectExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AlarmPolicyObject record, @Param("example") AlarmPolicyObjectExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AlarmPolicyObject record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AlarmPolicyObject record);
}