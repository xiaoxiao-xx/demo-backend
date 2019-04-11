package com.microcore.center.mapper;

import com.microcore.center.model.PsmDeptInfo;
import com.microcore.center.model.PsmDeptInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsmDeptInfoMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(PsmDeptInfoExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(PsmDeptInfoExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String deptId);

    /**
     *
     * @mbggenerated
     */
    int insert(PsmDeptInfo record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PsmDeptInfo record);

    /**
     *
     * @mbggenerated
     */
    List<PsmDeptInfo> selectByExample(PsmDeptInfoExample example);

    /**
     *
     * @mbggenerated
     */
    PsmDeptInfo selectByPrimaryKey(String deptId);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PsmDeptInfo record, @Param("example") PsmDeptInfoExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PsmDeptInfo record, @Param("example") PsmDeptInfoExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PsmDeptInfo record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PsmDeptInfo record);
}