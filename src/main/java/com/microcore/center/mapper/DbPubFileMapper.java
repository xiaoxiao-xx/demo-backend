package com.microcore.center.mapper;

import com.microcore.center.model.DbPubFile;
import com.microcore.center.model.DbPubFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbPubFileMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbPubFileExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbPubFileExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String pubId);

    /**
     *
     * @mbggenerated
     */
    int insert(DbPubFile record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbPubFile record);

    /**
     *
     * @mbggenerated
     */
    List<DbPubFile> selectByExample(DbPubFileExample example);

    /**
     *
     * @mbggenerated
     */
    DbPubFile selectByPrimaryKey(String pubId);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbPubFile record, @Param("example") DbPubFileExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbPubFile record, @Param("example") DbPubFileExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbPubFile record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbPubFile record);
}