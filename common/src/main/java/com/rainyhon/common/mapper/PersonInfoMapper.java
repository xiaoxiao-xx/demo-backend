package com.rainyhon.common.mapper;

import com.rainyhon.common.model.PersonInfo;
import com.rainyhon.common.model.PersonInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonInfoMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(PersonInfoExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(PersonInfoExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(PersonInfo record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PersonInfo record);

    /**
     *
     * @mbggenerated
     */
    List<PersonInfo> selectByExample(PersonInfoExample example);

    /**
     *
     * @mbggenerated
     */
    PersonInfo selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PersonInfo record, @Param("example") PersonInfoExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PersonInfo record, @Param("example") PersonInfoExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PersonInfo record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PersonInfo record);
}