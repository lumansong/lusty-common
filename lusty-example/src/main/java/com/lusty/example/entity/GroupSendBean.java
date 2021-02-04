package com.lusty.example.entity;


import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * t_group_send
 * @author 
 */
@Data
public class GroupSendBean implements Serializable {
    private Long id;

    /**
     * 企业微信名
     */
    private String corpWxName;

    /**
     * 企业微信ID
     */
    private String corpId;

    /**
     * 账号
     */
    private String account;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 群发标题
     */
    private String groupSendTitile;

    /**
     * 发送素材数
     */
    private Integer sendContentCount;

    /**
     * 发送类型 0 即时发送  1定时发送
     */
    private Integer sendType;


    /**
     *  实际app发送数据时间
     */
    private Date actualSendTime;

    /**
     * 发送时间
     */
    private Date sendTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private String updater;

    /**
     *0 待发送 1.正在发送 2 发送失败 4发送成功
     */
    private Integer status;

    /**
     * 0 未删除 1已删除
     */
    private Boolean isDelete;

    /**
     * 平台
     */
    private String platform;

    private static final long serialVersionUID = 1L;

}