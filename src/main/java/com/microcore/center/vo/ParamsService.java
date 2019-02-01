package com.microcore.center.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ParamsService {

    private String rid;
    private String sid;
    private String appsecret;
    private String pid;
    private UseService useService;

}
