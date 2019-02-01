package com.microcore.center.dto;

import com.microcore.center.model.DbModelDetail;
import lombok.Data;

@Data
public class DbModelDetailDto extends DbModelDetail {
	private String cond;
}
