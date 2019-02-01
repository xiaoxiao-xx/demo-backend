package com.microcore.center.mapper;

import com.microcore.center.model.ShArea;
import com.microcore.center.model.ShAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShAreaMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ShAreaExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ShAreaExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int insert(ShArea record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(ShArea record);

    /**
     *
     * @mbggenerated
     */
    List<ShArea> selectByExample(ShAreaExample example);

    /**
     *
     * @mbggenerated
     */
    ShArea selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ShArea record, @Param("example") ShAreaExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ShArea record, @Param("example") ShAreaExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ShArea record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ShArea record);
}