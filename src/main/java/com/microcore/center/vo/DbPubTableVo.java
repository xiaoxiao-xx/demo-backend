package com.microcore.center.vo;

import com.microcore.center.dto.DbPubColumnDto;
import com.microcore.center.dto.DbPubTableExtDto;
import com.microcore.center.model.DbPubTable;
import com.microcore.center.model.DbPubTableRel;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class DbPubTableVo extends DbPubTable {

	/**
	 * 列信息
	 */
	private List<DbPubColumnDto> pubColumnDto = new ArrayList<>();

	/**
	 * 针对模型的扩展信息
	 */
	private List<DbPubTableExtDto> pubTableExtDtos = new ArrayList<>();

	/**
	 * 关联信息
	 */
	private List<DbPubTableRel> pubTableRels = new ArrayList<>();

	private String dbVersionId;
	
}
