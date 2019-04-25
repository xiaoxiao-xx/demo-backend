package com.rainyhon.common.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoginVo {

	private String username;
	private String password;
//	private String orgId;

}
