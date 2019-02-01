package com.microcore.center.mapper;

import com.microcore.center.model.DbPubTableExt;
import com.microcore.center.model.DbPubTableExtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbPubTableExtMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbPubTableExtExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbPubTableExtExample example);

    /**
     *
     * @mbggenerated
     */
    int insert(DbPubTableExt record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbPubTableExt record);

    /**
     *
     * @mbggenerated
     */
    List<DbPubTableExt> selectByExample(DbPubTableExtExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbPubTableExt record, @Param("example") DbPubTableExtExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbPubTableExt record, @Param("example") DbPubTableExtExample example);
}