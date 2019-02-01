package com.microcore.center.dto;

import java.util.List;

import com.microcore.center.model.DbPubFile;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DbPubFileDto extends DbPubFile {

    private String orgName;
    private String pubUserName;
    private String crtName;
    /**
     * 自定义策略扩展参数
     */
    private List<DbExtTemplateDto> template;

    /**
     * 是否可以撤回
     */
    private String canBeWithdrawn;

}
