package com.microcore.center.vo;

import com.microcore.center.model.PsmFace;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class TrackInfo extends PsmFace {

	private String areaId;

	private Date captureTime;

}

