package com.microcore.center.mapper;

import com.microcore.center.model.PsmRollCall;
import com.microcore.center.model.PsmRollCallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsmRollCallMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(PsmRollCallExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(PsmRollCallExample example);

    /**
     *
     * @mbggenerated
     */
    int insert(PsmRollCall record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PsmRollCall record);

    /**
     *
     * @mbggenerated
     */
    List<PsmRollCall> selectByExample(PsmRollCallExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PsmRollCall record, @Param("example") PsmRollCallExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PsmRollCall record, @Param("example") PsmRollCallExample example);
}