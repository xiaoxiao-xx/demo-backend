package com.rainyhon.common.vo;

import com.rainyhon.common.model.Resource;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ResourceVo extends Resource {

	List<ResourceVo> children = new ArrayList<>();

}
