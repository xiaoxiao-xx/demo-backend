package com.microcore.center.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TestSubService {

    private String rid;
    private String sid;
    private String appsecret;
    private String pid;
    
    private TestSubServiceParams useService;

}
