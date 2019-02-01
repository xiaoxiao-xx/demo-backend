package com.microcore.center.vo;

import com.microcore.api.model.DbLabelKit;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DbLabelKitVo extends DbLabelKit {
	/**
	 * 验证码
	 */
	private String vcode ;

}

