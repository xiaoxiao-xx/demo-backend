package com.microcore.center.mapper;

import com.microcore.center.model.PsmUser;
import com.microcore.center.model.PsmUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsmUserMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(PsmUserExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(PsmUserExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(PsmUser record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PsmUser record);

    /**
     *
     * @mbggenerated
     */
    List<PsmUser> selectByExample(PsmUserExample example);

    /**
     *
     * @mbggenerated
     */
    PsmUser selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PsmUser record, @Param("example") PsmUserExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PsmUser record, @Param("example") PsmUserExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PsmUser record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PsmUser record);
}