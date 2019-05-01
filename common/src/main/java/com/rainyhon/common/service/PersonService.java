package com.rainyhon.common.service;

import com.microcore.center.model.PsmPersonInfo;
import com.rainyhon.common.vo.PersonInfoVo;
import com.rainyhon.common.vo.ResultVo;

import java.util.List;

public interface PersonService {

	ResultVo add(PersonInfoVo personInfoVo);

	ResultVo update(PersonInfoVo personInfoVo);

	ResultVo delete(String id);

	ResultVo getPersonList(String name, String deptId, Integer pageIndex, Integer pageSize);

	ResultVo importantCare(PersonInfoVo personInfoVo);

	ResultVo imageAcquisition(PersonInfoVo personInfoVo);

	ResultVo list();

	/**
	 * 获取随机用户信息
	 *
	 * @return
	 */
	PsmPersonInfo getRandomPerson();

	List<PsmPersonInfo> getPersonInfoList(String orgId);

	PsmPersonInfo getPsmPersonInfo(String id);

	String getPsmPersonInfoName(String id);

	ResultVo getPersonInfoByName(String name);

}
