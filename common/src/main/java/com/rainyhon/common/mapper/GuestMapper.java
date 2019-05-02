package com.rainyhon.common.mapper;

import com.rainyhon.common.model.Guest;
import com.rainyhon.common.model.GuestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuestMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(GuestExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(GuestExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(Guest record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(Guest record);

    /**
     *
     * @mbggenerated
     */
    List<Guest> selectByExample(GuestExample example);

    /**
     *
     * @mbggenerated
     */
    Guest selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Guest record, @Param("example") GuestExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Guest record, @Param("example") GuestExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Guest record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Guest record);
}