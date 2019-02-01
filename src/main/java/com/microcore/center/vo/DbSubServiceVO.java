package com.microcore.center.vo;

import com.microcore.center.model.DbPubService;
import com.microcore.center.model.DbSubService;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DbSubServiceVO {

	private DbSubService dbSubService;
	private DbPubService dbPubService;

}

