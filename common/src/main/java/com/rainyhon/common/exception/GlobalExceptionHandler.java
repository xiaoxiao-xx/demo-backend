package com.rainyhon.common.exception;

import javax.servlet.http.HttpServletRequest;

import com.rainyhon.common.vo.ResultVo;
// import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

// 不再使用
// @ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error");
		return mav;
	}

	@ExceptionHandler(value = CommonException.class)
	@ResponseBody
	public ResultVo jsonErrorHandler(HttpServletRequest req, CommonException e) throws Exception {
		return ResultVo.fail(e.getMessage());
	}

}

