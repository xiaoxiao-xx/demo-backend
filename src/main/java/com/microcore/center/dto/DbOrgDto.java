package com.microcore.center.dto;

import java.util.Set;

import com.microcore.api.model.DbOrg;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DbOrgDto extends DbOrg {

	private Set<String> kitInfo;
	
}
