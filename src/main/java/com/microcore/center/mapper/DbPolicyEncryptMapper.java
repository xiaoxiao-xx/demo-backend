package com.microcore.center.mapper;

import com.microcore.center.model.DbPolicyEncrypt;
import com.microcore.center.model.DbPolicyEncryptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbPolicyEncryptMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbPolicyEncryptExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbPolicyEncryptExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbPolicyEncrypt record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbPolicyEncrypt record);

    /**
     *
     * @mbggenerated
     */
    List<DbPolicyEncrypt> selectByExample(DbPolicyEncryptExample example);

    /**
     *
     * @mbggenerated
     */
    DbPolicyEncrypt selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbPolicyEncrypt record, @Param("example") DbPolicyEncryptExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbPolicyEncrypt record, @Param("example") DbPolicyEncryptExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbPolicyEncrypt record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbPolicyEncrypt record);
}