package com.rainyhon.common.mapper;

import com.rainyhon.common.model.DeptInfo;
import com.rainyhon.common.model.DeptInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeptInfoMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DeptInfoExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DeptInfoExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String deptId);

    /**
     *
     * @mbggenerated
     */
    int insert(DeptInfo record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DeptInfo record);

    /**
     *
     * @mbggenerated
     */
    List<DeptInfo> selectByExample(DeptInfoExample example);

    /**
     *
     * @mbggenerated
     */
    DeptInfo selectByPrimaryKey(String deptId);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DeptInfo record, @Param("example") DeptInfoExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DeptInfo record, @Param("example") DeptInfoExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DeptInfo record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DeptInfo record);
}