package com.rainyhon.backend.controller;

import com.rainyhon.common.model.PsmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rainyhon.backend.config.SessionManage;
import com.rainyhon.common.service.PsmUserService;
import com.rainyhon.common.util.Encode;
import com.rainyhon.common.util.JwtUtil;
import com.rainyhon.common.vo.LoginUserVo;
import com.rainyhon.common.vo.ResultVo;

@RestController
@RequestMapping("system")
public class SystemController {

	@Autowired
	private PsmUserService psmUserService;

	@PostMapping("login")
	public ResultVo login(@RequestBody LoginUserVo loginUserVo) throws Exception {
		String userName = loginUserVo.getUserName();
		String password = loginUserVo.getPassword();
		PsmUser psmUser = psmUserService.getPsmUser(userName);
		if (psmUser == null) {
			return ResultVo.fail("账号或密码错误！");
		}

		if (!Encode.SHAEncode(userName + password).equals(psmUser.getPassword())) {
			return ResultVo.fail("账号或密码错误！");
		}
		SessionManage.login(psmUser);
		return ResultVo.ok(JwtUtil.createJwtToken(userName, null));
	}

	@PostMapping("logout")
	public ResultVo logout(@RequestBody String userName) {
		SessionManage.logout(userName);
		return ResultVo.ok();
	}

}
