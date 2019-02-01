package com.microcore.center.mapper;

import com.microcore.center.model.DbPubTableRel;
import com.microcore.center.model.DbPubTableRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbPubTableRelMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbPubTableRelExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbPubTableRelExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbPubTableRel record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbPubTableRel record);

    /**
     *
     * @mbggenerated
     */
    List<DbPubTableRel> selectByExample(DbPubTableRelExample example);

    /**
     *
     * @mbggenerated
     */
    DbPubTableRel selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbPubTableRel record, @Param("example") DbPubTableRelExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbPubTableRel record, @Param("example") DbPubTableRelExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbPubTableRel record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbPubTableRel record);
}