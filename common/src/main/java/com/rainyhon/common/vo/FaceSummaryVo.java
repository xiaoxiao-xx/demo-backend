package com.rainyhon.common.vo;

import com.microcore.center.model.Face;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class FaceSummaryVo extends Face {

	/**
	 * 素材抓取时间
	 */
	private Date captureTime;

	private String areaId;

}
