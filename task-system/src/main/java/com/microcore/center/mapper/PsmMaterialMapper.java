package com.microcore.center.mapper;

import com.microcore.center.model.PsmMaterial;
import com.microcore.center.model.PsmMaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsmMaterialMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(PsmMaterialExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(PsmMaterialExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(PsmMaterial record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PsmMaterial record);

    /**
     *
     * @mbggenerated
     */
    List<PsmMaterial> selectByExample(PsmMaterialExample example);

    /**
     *
     * @mbggenerated
     */
    PsmMaterial selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PsmMaterial record, @Param("example") PsmMaterialExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PsmMaterial record, @Param("example") PsmMaterialExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PsmMaterial record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PsmMaterial record);
}