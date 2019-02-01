package com.microcore.center.dto;

import com.microcore.center.model.DbApproval;
import com.microcore.center.model.DbSubFile;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lmh
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DbSubFileDto extends DbSubFile {

	private String orgName;
	private String pubName;
	private String pubPath;
	private String pubUser;
	private String extractTypeName;

}
