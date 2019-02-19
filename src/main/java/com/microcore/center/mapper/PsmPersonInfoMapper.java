package com.microcore.center.mapper;

import com.microcore.center.model.PsmPersonInfo;
import com.microcore.center.model.PsmPersonInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsmPersonInfoMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(PsmPersonInfoExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(PsmPersonInfoExample example);

    /**
     *
     * @mbggenerated
     */
    int insert(PsmPersonInfo record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PsmPersonInfo record);

    /**
     *
     * @mbggenerated
     */
    List<PsmPersonInfo> selectByExample(PsmPersonInfoExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PsmPersonInfo record, @Param("example") PsmPersonInfoExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PsmPersonInfo record, @Param("example") PsmPersonInfoExample example);
}