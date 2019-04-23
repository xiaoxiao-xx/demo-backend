package com.microcore.center.service;

import com.github.pagehelper.PageInfo;
import com.microcore.center.model.Org;
import com.microcore.center.vo.OrgVo;

import java.util.List;

public interface OrgService {

	void addOrg(Org org);

	void deleteOrgById(String id);

	void batchDelete(List<String> idList);

	void updateOrg(Org org);

	Org getOrgById(String id);

	PageInfo<OrgVo> getOrgList(Integer pageIndex, Integer pageSize);

}
