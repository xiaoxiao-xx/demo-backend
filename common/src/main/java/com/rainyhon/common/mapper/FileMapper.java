package com.rainyhon.common.mapper;

import com.rainyhon.common.model.File;
import com.rainyhon.common.model.FileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(FileExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(FileExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(File record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(File record);

    /**
     *
     * @mbggenerated
     */
    List<File> selectByExample(FileExample example);

    /**
     *
     * @mbggenerated
     */
    File selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") File record, @Param("example") FileExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") File record, @Param("example") FileExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(File record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(File record);
}