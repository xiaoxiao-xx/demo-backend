package com.rainyhon.common.vo;

import lombok.Data;

/**
 * 动态查询视图传输对象
 */
@Data
public class ViewAddVo extends ViewBaseVo {

    /**
     * 视图显示名
     */
    private String viewDisplayName;

    /**
     * 描述
     */
    private String description;

    /**
     * 前端的数据，用于还原界面
     */
    private String data;

}
