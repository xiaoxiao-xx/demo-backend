package com.microcore.center.service;

import com.microcore.center.vo.PersonInfoVo;
import com.microcore.center.vo.ResultVo;

public interface PersonService {
    ResultVo add(PersonInfoVo personInfoVo);

    ResultVo update(PersonInfoVo personInfoVo);

    ResultVo delete(String id);

    ResultVo getPersonList(String name,Integer pageIndex, Integer pageSize);

    ResultVo importantCare(PersonInfoVo personInfoVo);

    ResultVo imageAcquisition(PersonInfoVo personInfoVo);
}
