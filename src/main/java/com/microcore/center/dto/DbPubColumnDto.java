package com.microcore.center.dto;

import com.microcore.center.model.DbPubColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class DbPubColumnDto extends DbPubColumn {

	/**
	 * 针对字段的扩展信息
	 */
	private List<DbPubTableExtDto> pubTableExtDtos = new ArrayList<>();

}
