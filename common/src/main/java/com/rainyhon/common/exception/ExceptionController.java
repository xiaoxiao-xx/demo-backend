package com.rainyhon.common.exception;

import com.rainyhon.common.vo.ResultVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.rainyhon.common.constant.Constants.*;
import static com.rainyhon.common.exception.RuntimeExceptionMessage.getDisplayMessageByRealMessage;
import static com.rainyhon.common.exception.RuntimeExceptionMessage.getDisplayMessageByRuntimeExceptionName;

/**
 * 统一异常处理
 **/
@ControllerAdvice
@ResponseBody
public class ExceptionController {

	/**
	 * CommonException是RuntimeException的子类，单独处理
	 * 其余RuntimeException分为一类处理
	 */
	@ExceptionHandler(RuntimeException.class)
	public ResultVo<?> runtimeException(RuntimeException e) {
		CommonException commonException = null;
		if (e instanceof CommonException) {
			commonException = new CommonException(getDisplayMessageByRealMessage(e.getMessage()));
			return ResultVo.fail(ERROR_CODE, commonException);
		} else {
			String runtimeExceptionName = e.getClass().getName();
			commonException = new CommonException(getDisplayMessageByRuntimeExceptionName(runtimeExceptionName));
			return ResultVo.fail(ERROR_CODE, commonException);
		}
	}

	/**
	 * 其他错误
	 */
	@ExceptionHandler(Exception.class)
	public ResultVo<?> exception(Exception e) {
		return ResultVo.fail(ERROR_CODE, e);
	}

}
