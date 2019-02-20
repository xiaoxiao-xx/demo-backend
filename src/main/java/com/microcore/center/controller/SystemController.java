package com.microcore.center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microcore.center.config.SessionManage;
import com.microcore.center.model.PsmUser;
import com.microcore.center.service.UserService;
import com.microcore.center.util.Encode;
import com.microcore.center.util.JwtUtil;
import com.microcore.center.vo.LoginUserVo;
import com.microcore.center.vo.ResultVo;

@RestController
@RequestMapping("system")
public class SystemController {
	@Autowired
	private UserService userService;

	@PostMapping("login")
	public ResultVo login(@RequestBody LoginUserVo loginUserVo) throws Exception {
		String userName = loginUserVo.getUserName();
		String password = loginUserVo.getPassword();
		PsmUser psmUser = userService.getPsmUser(userName);
		if (psmUser == null) {
			return ResultVo.fail("账号或密码错误！");
		}
		
		if(!Encode.SHAEncode(userName+password).equals(psmUser.getPassword())) {
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
