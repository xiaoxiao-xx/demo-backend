package com.rainyhon.common.mapper;

import com.rainyhon.common.model.KeyPerson;
import com.rainyhon.common.model.KeyPersonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KeyPersonMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(KeyPersonExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(KeyPersonExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(KeyPerson record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(KeyPerson record);

    /**
     *
     * @mbggenerated
     */
    List<KeyPerson> selectByExample(KeyPersonExample example);

    /**
     *
     * @mbggenerated
     */
    KeyPerson selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") KeyPerson record, @Param("example") KeyPersonExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") KeyPerson record, @Param("example") KeyPersonExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(KeyPerson record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(KeyPerson record);
}