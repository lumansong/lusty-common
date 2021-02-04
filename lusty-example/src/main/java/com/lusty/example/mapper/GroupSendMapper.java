package com.lusty.example.mapper;


import com.lusty.datasource.config.anno.DataSource;
import com.lusty.example.entity.GroupSendBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@DataSource("app")
public interface GroupSendMapper {
    /**
     *
     * 删除群记录
     * @param
     * @param id
     * @return
     */
    int deleteByPrimaryKey(@Param("id") Long id);

    int insert(@Param("gs") GroupSendBean gs);


    int insertSelective(GroupSendBean record);

    GroupSendBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(@Param("gs") GroupSendBean record);

    int updateByPrimaryKey(GroupSendBean record);



    List<GroupSendBean> getSendingData();

    /**
     * 获取最近5分钟内将要发送的群发记录 注：不包括5分钟内刚配置的群记录
     * @return
     */
    List<GroupSendBean> selectLt5MinTiming();
}