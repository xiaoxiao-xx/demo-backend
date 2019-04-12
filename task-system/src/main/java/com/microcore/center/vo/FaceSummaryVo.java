package com.microcore.center.vo;

import com.microcore.center.model.PsmFace;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class FaceSummaryVo extends PsmFace {

	/**
	 * 素材抓取时间
	 */
	private Date captureTime;

	private String areaId;

}
