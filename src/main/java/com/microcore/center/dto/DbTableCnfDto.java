package com.microcore.center.dto;

import java.util.ArrayList;
import java.util.List;

import com.microcore.center.model.DbTableCnf;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DbTableCnfDto extends DbTableCnf {

	private List<DbFieldCnfDto> fieldDto = new ArrayList<>();

}
