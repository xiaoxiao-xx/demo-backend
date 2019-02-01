package com.microcore.center.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * 新增或修改接口服务安全策略参数VO类
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AddAuthPolicyVo {

    /**
     * 授权类型(ORG,REGION)
     */
    private String authType;

    /**
     * 授权范围，使用部门范围
     */
    private String authScope;

    /**
     * 使用开始日期
     */
    private Date authStartTime;

    /**
     * 使用结束日期
     */
    private Date authEndDate;

    /**
     * 敏感等级
     */
    private String securityLevel;

    /**
     * 加密类型
     */
    private String encryptType;

    /**
     * 权限范围信息
     */
    private List<?> authScopeInfo;

}
