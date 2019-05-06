package com.rainyhon.common.vo;

import com.rainyhon.common.model.KeyPerson;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class KeyPersonVo extends KeyPerson {

	private String personName;

	private String startPersonName;

}
