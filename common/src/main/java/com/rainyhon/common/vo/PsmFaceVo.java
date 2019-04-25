package com.rainyhon.common.vo;

import com.microcore.center.model.Face;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PsmFaceVo extends Face {

	private String base64;

}
