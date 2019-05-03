package com.rainyhon.common.vo;

import com.microcore.center.model.Org;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class OrgVo extends Org {

	List<OrgVo> children;

}
