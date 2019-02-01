package com.microcore.center.vo;

import java.util.List;

import com.microcore.api.model.DbOrg;
import com.microcore.center.model.DbArea;
import com.microcore.common.util.CommonUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DbAreaVo extends DbArea {

	private String orgNames ;

	private String orgIds ;

	private List<DbOrg> listDbOrg ;

	public void setListDbOrg(List<DbOrg> listDbOrg) {
		this.listDbOrg = listDbOrg;
		if(CommonUtil.isEmpty(listDbOrg)) {
			return ;
		}
		orgNames = "" ;
		orgIds = "" ;
		for (DbOrg dbOrg : listDbOrg) {
			orgNames += "," +  dbOrg.getOrgName() ;
			orgIds += "," + dbOrg.getOrgId();
		}
		orgNames = orgNames.substring(1);
		orgIds = orgIds.substring(1);
	}

}

