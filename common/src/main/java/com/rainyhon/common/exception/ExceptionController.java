package com.rainyhon.common.exception;

import com.rainyhon.common.vo.ResultVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.rainyhon.common.constant.Constants.*;
import static com.rainyhon.common.exception.CommonExceptionMessage.getDisplayMessageByRealMessage;

/**
 * 统一异常处理
 **/
@ControllerAdvice
@ResponseBody
public class ExceptionController {

	/**
	 * 空指针异常
	 */
	@ExceptionHandler(NullPointerException.class)
	public ResultVo<?> nullPointerExceptionHandler(NullPointerException ex) {
		return ResultVo.fail(ERROR_CODE, new Exception(NullPointerExceptionStr));
	}

	/**
	 * 类型转换异常
	 */
	@ExceptionHandler(ClassCastException.class)
	public ResultVo<?> classCastExceptionHandler(ClassCastException ex) {
		return ResultVo.fail(ERROR_CODE, new Exception(ClassCastExceptionStr));
	}

	/**
	 * 数组越界异常
	 */
	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	public ResultVo<?> arrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException ex) {
		return ResultVo.fail(ERROR_CODE, new Exception(ArrayIndexOutOfBoundsStr));
	}

	@ExceptionHandler(CommonException.class)
	public ResultVo<?> runtimeException(CommonException e) {
		CommonException commonException = new CommonException(getDisplayMessageByRealMessage(e.getMessage()));
		return ResultVo.fail(ERROR_CODE, commonException);
	}

	/**
	 * 其他错误
	 */
	@ExceptionHandler(Exception.class)
	public ResultVo<?> exception(Exception e) {
		return ResultVo.fail(ERROR_CODE, e);
	}

}
