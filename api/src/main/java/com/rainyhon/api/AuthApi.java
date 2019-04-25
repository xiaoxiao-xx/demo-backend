package com.rainyhon.api;

import com.rainyhon.common.vo.LoginVo;
import com.rainyhon.common.vo.ResultVo;
import com.rainyhon.common.vo.UserInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "SLS-AUTH-SERVER")
public interface AuthApi {

	@PostMapping("auth/isLogged")
	UserInfo isLogged(@RequestBody String name) throws Exception;

	@PostMapping("auth/login")
	ResultVo login(@RequestBody LoginVo loginVo);

}
