package com.rainyhon.common.mapper;

import com.rainyhon.common.model.Material;
import com.rainyhon.common.model.MaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(MaterialExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(MaterialExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(Material record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(Material record);

    /**
     *
     * @mbggenerated
     */
    List<Material> selectByExample(MaterialExample example);

    /**
     *
     * @mbggenerated
     */
    Material selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Material record, @Param("example") MaterialExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Material record, @Param("example") MaterialExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Material record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Material record);
}