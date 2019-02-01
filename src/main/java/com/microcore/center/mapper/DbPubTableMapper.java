package com.microcore.center.mapper;

import com.microcore.center.model.DbPubTable;
import com.microcore.center.model.DbPubTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbPubTableMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbPubTableExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbPubTableExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbPubTable record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbPubTable record);

    /**
     *
     * @mbggenerated
     */
    List<DbPubTable> selectByExample(DbPubTableExample example);

    /**
     *
     * @mbggenerated
     */
    DbPubTable selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbPubTable record, @Param("example") DbPubTableExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbPubTable record, @Param("example") DbPubTableExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbPubTable record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbPubTable record);
}