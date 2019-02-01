package com.microcore.center.mapper;

import com.microcore.center.model.DbColumnComment;
import com.microcore.center.model.DbColumnCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbColumnCommentMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbColumnCommentExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbColumnCommentExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbColumnComment record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbColumnComment record);

    /**
     *
     * @mbggenerated
     */
    List<DbColumnComment> selectByExample(DbColumnCommentExample example);

    /**
     *
     * @mbggenerated
     */
    DbColumnComment selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbColumnComment record, @Param("example") DbColumnCommentExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbColumnComment record, @Param("example") DbColumnCommentExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbColumnComment record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbColumnComment record);
}