package com.microcore.api;

import com.microcore.center.vo.LoginVo;
import com.microcore.center.vo.ResultVo;
import com.microcore.center.vo.UserInfo;
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
