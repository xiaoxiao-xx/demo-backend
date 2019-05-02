package com.rainyhon.common.mapper;

import com.rainyhon.common.model.GuestArea;
import com.rainyhon.common.model.GuestAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuestAreaMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(GuestAreaExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(GuestAreaExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(GuestArea record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(GuestArea record);

    /**
     *
     * @mbggenerated
     */
    List<GuestArea> selectByExample(GuestAreaExample example);

    /**
     *
     * @mbggenerated
     */
    GuestArea selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") GuestArea record, @Param("example") GuestAreaExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") GuestArea record, @Param("example") GuestAreaExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(GuestArea record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(GuestArea record);
}