package com.microcore.center.service;

import com.microcore.center.vo.PersonInfoVo;
import com.microcore.center.vo.ResultVo;

public interface PersonService {
    ResultVo add(PersonInfoVo personInfoVo);

    ResultVo update(PersonInfoVo personInfoVo);

    ResultVo delete(String id);

    ResultVo getPersonList(String name);

    ResultVo importantCare(PersonInfoVo personInfoVo);
}
