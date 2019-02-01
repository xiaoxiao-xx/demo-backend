package com.microcore.center.dto;

import com.microcore.center.model.DbModel;
import com.microcore.center.model.DbModelDetail;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@ApiModel
@Data
@EqualsAndHashCode(callSuper = false)
public class DbModelDto extends DbModel {

	/**
	 * 模型所属组织名
	 */
	private String orgName;

	/**
	 * 创建人名
	 */
	private String createUserName;

	/**
	 * 创建机构名
	 */
	private String createOrgName;

	private List<DbModelDetail> modelDetailDto = new ArrayList<>();

}