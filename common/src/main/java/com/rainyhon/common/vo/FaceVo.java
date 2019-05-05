package com.rainyhon.common.vo;

import com.rainyhon.common.model.Face;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class FaceVo extends Face {

	private String base64;

}
