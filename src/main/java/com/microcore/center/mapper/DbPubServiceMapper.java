package com.microcore.center.mapper;

import com.microcore.center.model.DbPubService;
import com.microcore.center.model.DbPubServiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbPubServiceMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DbPubServiceExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DbPubServiceExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DbPubService record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DbPubService record);

    /**
     *
     * @mbggenerated
     */
    List<DbPubService> selectByExample(DbPubServiceExample example);

    /**
     *
     * @mbggenerated
     */
    DbPubService selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbPubService record, @Param("example") DbPubServiceExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbPubService record, @Param("example") DbPubServiceExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbPubService record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbPubService record);
}