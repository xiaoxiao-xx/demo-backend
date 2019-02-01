package com.microcore.center.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @描述: 运行状态vo类
 * @author 何语非
 * @Date: 2018/9/7 11:00:00
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RunStatusVo {

    /**
     * 发布ID
     */
    private String id;

    /**
     * 运行状态
     */
    private String runStatus;

    public RunStatusVo(String id, String runStatus){
        this.id = id;
        this.runStatus = runStatus;
    }

}
