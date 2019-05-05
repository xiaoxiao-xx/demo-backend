package com.rainyhon.common.vo;

import com.rainyhon.common.model.InOutRecord;
import lombok.Data;

@Data
public class InOutRecordVo extends InOutRecord {

	private String areaName;

	private String personName;

	private String orgName;

}
