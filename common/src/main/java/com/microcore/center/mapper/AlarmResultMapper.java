package com.microcore.center.mapper;

import com.microcore.center.model.AlarmResult;
import com.microcore.center.model.AlarmResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlarmResultMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AlarmResultExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AlarmResultExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(AlarmResult record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AlarmResult record);

    /**
     *
     * @mbggenerated
     */
    List<AlarmResult> selectByExample(AlarmResultExample example);

    /**
     *
     * @mbggenerated
     */
    AlarmResult selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AlarmResult record, @Param("example") AlarmResultExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AlarmResult record, @Param("example") AlarmResultExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AlarmResult record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AlarmResult record);
}