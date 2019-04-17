package com.microcore.center.vo;

import com.microcore.center.model.PsmFace;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PsmFaceVo extends PsmFace {

	private String base64;

}
