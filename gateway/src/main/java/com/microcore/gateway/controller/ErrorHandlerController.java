package com.microcore.gateway.controller;

import com.microcore.center.util.StringUtil;
import com.microcore.center.vo.ResultVo;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.client.ClientException;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 *
 */
@RestController
public class ErrorHandlerController implements ErrorController {

	/**
	 * 出异常后进入该方法，交由下面的方法处理
	 */
	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping("/error")
	public Object error() {
		RequestContext ctx = RequestContext.getCurrentContext();
		ZuulException exception = (ZuulException) ctx.getThrowable();
		if (exception == null) {
			return ResultVo.fail("访问地址不存在！");
		}
		Throwable throwable = exception.getCause().getCause().getCause();
		if (throwable instanceof ClientException) {
			return ResultVo.fail(throwable.getMessage());
		}
		if (StringUtil.isEmpty(exception.getMessage())) {
			return ResultVo.fail("系统异常请联系管理员！");
		}
		return ResultVo.fail(exception.getMessage());
	}

}