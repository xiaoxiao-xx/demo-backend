package com.rainyhon.common.mapper;

import com.rainyhon.common.model.AlarmMode;
import com.rainyhon.common.model.AlarmModeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlarmModeMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AlarmModeExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AlarmModeExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(AlarmMode record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AlarmMode record);

    /**
     *
     * @mbggenerated
     */
    List<AlarmMode> selectByExample(AlarmModeExample example);

    /**
     *
     * @mbggenerated
     */
    AlarmMode selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AlarmMode record, @Param("example") AlarmModeExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AlarmMode record, @Param("example") AlarmModeExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AlarmMode record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AlarmMode record);
}