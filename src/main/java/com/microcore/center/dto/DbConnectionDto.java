package com.microcore.center.dto;

import java.util.ArrayList;
import java.util.List;

import com.microcore.center.model.DbConnection;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DbConnectionDto extends DbConnection {
	
	private List<DbTableCnfDto> tableDto = new ArrayList<>();

	private String databaseType;

	/**
	 * 套件ID
	 */
	private String kitId;

}
