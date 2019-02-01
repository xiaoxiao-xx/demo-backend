package com.microcore.center.mapper;

import com.microcore.center.model.DbApproval;
import com.microcore.center.model.DbApprovalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbApprovalMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbApprovalExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbApprovalExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbApproval record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbApproval record);

    /**
     *
     * @mbggenerated
     */
    List<DbApproval> selectByExample(DbApprovalExample example);

    /**
     *
     * @mbggenerated
     */
    DbApproval selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbApproval record, @Param("example") DbApprovalExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbApproval record, @Param("example") DbApprovalExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbApproval record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbApproval record);
}