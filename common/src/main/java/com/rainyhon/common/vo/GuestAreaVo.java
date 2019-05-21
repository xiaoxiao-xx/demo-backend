package com.rainyhon.common.vo;

import com.rainyhon.common.model.GuestArea;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class GuestAreaVo extends GuestArea {

	private String areaName;

}
