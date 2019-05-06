package com.rainyhon.common.vo;

import com.rainyhon.common.model.Detail;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DetailVo extends Detail {

	private String imptCareStatus;

}
