package com.microcore.center.service;

import com.microcore.center.model.PsmPersonInfo;
import com.microcore.center.vo.PersonInfoVo;
import com.microcore.center.vo.ResultVo;

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
	PsmPersonInfo getRadomPerson();
	
	PsmPersonInfo getPsmPersonInfo(String id);
	
	String getPsmPersonInfoName(String id);

}
