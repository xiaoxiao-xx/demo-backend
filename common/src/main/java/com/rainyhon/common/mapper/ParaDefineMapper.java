package com.rainyhon.common.mapper;

import com.rainyhon.common.model.ParaDefine;
import com.rainyhon.common.model.ParaDefineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParaDefineMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ParaDefineExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ParaDefineExample example);

    /**
     *
     * @mbggenerated
     */
    int insert(ParaDefine record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(ParaDefine record);

    /**
     *
     * @mbggenerated
     */
    List<ParaDefine> selectByExample(ParaDefineExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ParaDefine record, @Param("example") ParaDefineExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ParaDefine record, @Param("example") ParaDefineExample example);
}