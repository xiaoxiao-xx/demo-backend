package com.rainyhon.common.mapper;

import com.rainyhon.common.model.DynamicQueryDictionary;
import com.rainyhon.common.model.DynamicQueryDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DynamicQueryDictionaryMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DynamicQueryDictionaryExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DynamicQueryDictionaryExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(DynamicQueryDictionary record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DynamicQueryDictionary record);

    /**
     *
     * @mbggenerated
     */
    List<DynamicQueryDictionary> selectByExample(DynamicQueryDictionaryExample example);

    /**
     *
     * @mbggenerated
     */
    DynamicQueryDictionary selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DynamicQueryDictionary record, @Param("example") DynamicQueryDictionaryExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DynamicQueryDictionary record, @Param("example") DynamicQueryDictionaryExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DynamicQueryDictionary record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DynamicQueryDictionary record);
}