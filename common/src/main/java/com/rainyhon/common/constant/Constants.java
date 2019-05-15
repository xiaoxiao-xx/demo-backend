package com.rainyhon.common.constant;

/**
 * 常量
 */
public class Constants {

	/**
	 * YES & NO
	 */
	public static final String YES = "YES";

	public static final String NO = "NO";

//	public static final String TRUE = "TRUE";

//	public static final String FALSE = "FALSE";

//	public static final String INPUT = "INPUT";

//	public static final String OUTPUT = "OUTPUT";

	/**
	 * 删除状态: 已删除
	 * 用于各表中的del_status字段
	 */
	public static final String DELETE_STATUS_YES = "YES";

	/**
	 * 删除状态: 未删除
	 */
	public static final String DELETE_STATUS_NO = "NO";

	/**
	 * ENABLE & DISABLE
	 */
	public static final String DEVICE_STATE_ENABLE = "E";

	public static final String DEVICE_STATE_DISABLE = "D";


	public static final String DEVICE_TYPE = "DEVICE_TYPE";

	/**
	 * 操作类型
	 */
	public static final String OPER_HIS_ADD = "ADD";

	public static final String OPER_HIS_UPD = "UPD";

	public static final String OPER_HIS_DEL = "DEL";

	public static final String OPER_HIS_ENABLE = "ENABLE";

	public static final String OPER_HIS_DISABLE = "DISABLE";

	/**
	 * 日程重复类型
	 */
	public static final String REPEAT_TYPE_DAY = "D";

	public static final String REPEAT_TYPE_WEEK = "W";

	public static final String REPEAT_TYPE_MONTH = "M";

	public static final String REPEAT_TYPE_NO = "N";

	/**
	 * 日程对象配置类型
	 */
	public static final String SCHEDULE_CONFIG_OBJECT_TYPE_ORG = "ORG";

	public static final String SCHEDULE_CONFIG_OBJECT_TYPE_PERSON = "PERSON";

	/**
	 * 缺勤
	 */
	public static final String ATTENDANCE_RESULT_ABSENTEEISM = "0";

	/**
	 * 迟到
	 */
	public static final String ATTENDANCE_RESULT_LATE = "1";

	/**
	 * 早退
	 */
	public static final String ATTENDANCE_RESULT_LEAVE_EARLY = "2";

	/**
	 * 正常
	 */
	public static final String ATTENDANCE_RESULT_OK = "3";

	/**
	 * 日程类型-电子点名
	 */
	public static final String SCHEDULE_DETAIL_TYPE_ROLL_CALL = "ROLL_CALL";

//	/**
//	 * 日程类型-电子点名
//	 */
//	public static final String SCHEDULE_DETAIL_TYPE_ON_DUTY = "ON_DUTY";

//	/**
//	 * 日程类型-电子点名
//	 */
//	public static final String SCHEDULE_DETAIL_TYPE_PATROL = "PATROL";

	/**
	 * 重点关注
	 */
	public static final String IMPT_CARE_TURE = "1";

	public static final String IMPT_CARE_FALSE = "0";


	/**
	 * 异常类型
	 */
	public static final String NullPointerExceptionStr = "空指针异常";

	public static final String ArrayIndexOutOfBoundsStr = "数组越界异常";

	public static final String ClassCastExceptionStr = "类型转换异常";

	public static final String DATA_SCOPE_ALL_ORGS = "ALL_ORGS";

	public static final String DATA_SCOPE_CURRENT_ORG = "CURRENT_ORG";

	/**
	 * 资源类型
	 */
	public static final String RESOURCE_TYPE_MENU = "MENU";

	/**
	 * 错误码
	 */
	public static int ERROR_CODE = 500;

}

