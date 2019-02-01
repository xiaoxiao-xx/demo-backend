package com.microcore.center.vo;

import java.util.List;

import com.microcore.api.model.DbOrg;
import com.microcore.center.model.DbArea;
import com.microcore.common.util.CommonUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DbOrgVo extends DbOrg {

	private String porgName;
	private String areaNames;
	private String areaIds;
	private String addressName;
	private List<DbArea> listDbArea;

	public void setListDbArea(List<DbArea> listDbArea) {
		this.listDbArea = listDbArea;
		if (CommonUtil.isEmpty(listDbArea)) {
			return;
		}
		areaNames = "";
		areaIds = "";
		for (DbArea dbArea : listDbArea) {
			areaNames += "," + dbArea.getAreaName();
			areaIds += "," + dbArea.getId();
		}
		areaNames = areaNames.substring(1);
		areaIds = areaIds.substring(1);
	}

}

