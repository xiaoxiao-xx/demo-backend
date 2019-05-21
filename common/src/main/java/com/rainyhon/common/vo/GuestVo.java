package com.rainyhon.common.vo;

import com.rainyhon.common.model.Guest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class GuestVo extends Guest {

	private List<String> areaList;

	private List<GuestAreaVo> areaVoList;

	private String targetOrgName;

	private String cardTypeName;

}
