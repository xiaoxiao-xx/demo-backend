package com.microcore.center.mapper;

import com.microcore.center.model.UserHistory;
import com.microcore.center.model.UserHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserHistoryMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(UserHistoryExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(UserHistoryExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(UserHistory record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(UserHistory record);

    /**
     *
     * @mbggenerated
     */
    List<UserHistory> selectByExample(UserHistoryExample example);

    /**
     *
     * @mbggenerated
     */
    UserHistory selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") UserHistory record, @Param("example") UserHistoryExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") UserHistory record, @Param("example") UserHistoryExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UserHistory record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserHistory record);
}