package com.microcore.center.vo;

import com.microcore.api.model.DbServiceKit;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 服务接口套件vo类
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ServiceKitVo extends DbServiceKit {

	/**
	 * 验证码
	 */
	private String verificationCode;

}
