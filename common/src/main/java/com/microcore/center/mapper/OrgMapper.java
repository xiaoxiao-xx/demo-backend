package com.microcore.center.mapper;

import com.microcore.center.model.Org;
import com.microcore.center.model.OrgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(OrgExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(OrgExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(Org record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(Org record);

    /**
     *
     * @mbggenerated
     */
    List<Org> selectByExample(OrgExample example);

    /**
     *
     * @mbggenerated
     */
    Org selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Org record, @Param("example") OrgExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Org record, @Param("example") OrgExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Org record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Org record);
}