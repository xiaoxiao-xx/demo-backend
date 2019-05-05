package com.rainyhon.common.vo;

import com.rainyhon.common.model.Org;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class OrgVo extends Org {

	List<OrgVo> children;

}
