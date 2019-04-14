package com.microcore.center.service;

import java.util.List;

import com.microcore.center.model.PsmParaDefine;

public interface ParaDefineService {

    List<PsmParaDefine> getPsmParaDefineByType(String type);

    PsmParaDefine getPsmParaDefineByTypeAnd(String type, String code);

    String getValueByTypeAnd(String type, String code);

}
