package com.rainyhon.common.constant;

import com.rainyhon.common.vo.ResultVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 **/
@ControllerAdvice
@ResponseBody
public class ExceptionController {

	private String NullPointerExceptionStr = "空指针异常";
	private String ArrayIndexOutOfBoundsStr = "数组越界异常";
	private String ClassCastExceptionStr = "类型转换异常";
	private int ERROR_CODE = 500;

	// 空指针异常
	@ExceptionHandler(NullPointerException.class)
	public ResultVo<?> nullPointerExceptionHandler(NullPointerException ex) {
		return ResultVo.fail(ERROR_CODE, new Exception(NullPointerExceptionStr));
	}

	// 类型转换异常
	@ExceptionHandler(ClassCastException.class)
	public ResultVo<?> classCastExceptionHandler(ClassCastException ex) {
		return ResultVo.fail(ERROR_CODE, new Exception(ClassCastExceptionStr));
	}

	// 数组越界异常
	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	public ResultVo<?> ArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException ex) {
		return ResultVo.fail(ERROR_CODE, new Exception(ArrayIndexOutOfBoundsStr));
	}

	// 其他错误
	@ExceptionHandler({Exception.class})
	public ResultVo<?> exception(Exception ex) {
		return ResultVo.fail(ERROR_CODE, ex);
	}

}
