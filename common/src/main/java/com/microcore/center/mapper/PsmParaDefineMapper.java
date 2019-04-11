package com.microcore.center.mapper;

import com.microcore.center.model.PsmParaDefine;
import com.microcore.center.model.PsmParaDefineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsmParaDefineMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(PsmParaDefineExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(PsmParaDefineExample example);

    /**
     *
     * @mbggenerated
     */
    int insert(PsmParaDefine record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PsmParaDefine record);

    /**
     *
     * @mbggenerated
     */
    List<PsmParaDefine> selectByExample(PsmParaDefineExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PsmParaDefine record, @Param("example") PsmParaDefineExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PsmParaDefine record, @Param("example") PsmParaDefineExample example);
}