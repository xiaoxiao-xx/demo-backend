package com.microcore.center.vo;

import com.microcore.api.model.DbFileKit;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DbFileKitVo extends DbFileKit {

    /**
     * 验证码
     */
    private String VerificationCode;

    private String orgName;
    
    private String runStatus;
}
