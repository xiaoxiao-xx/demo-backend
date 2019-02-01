package com.microcore.center.mapper;

import com.microcore.center.model.DbEncryptionType;
import com.microcore.center.model.DbEncryptionTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbEncryptionTypeMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbEncryptionTypeExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbEncryptionTypeExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbEncryptionType record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbEncryptionType record);

    /**
     *
     * @mbggenerated
     */
    List<DbEncryptionType> selectByExample(DbEncryptionTypeExample example);

    /**
     *
     * @mbggenerated
     */
    DbEncryptionType selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbEncryptionType record, @Param("example") DbEncryptionTypeExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbEncryptionType record, @Param("example") DbEncryptionTypeExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbEncryptionType record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbEncryptionType record);
}