package com.rainyhon.backend.controller;

import com.github.pagehelper.PageInfo;
import com.rainyhon.common.constant.ExceptionType;
import com.rainyhon.common.exception.CommonException;
import com.microcore.center.model.User;
import com.rainyhon.common.service.PsmUserService;
import com.rainyhon.common.service.UserService;
import com.rainyhon.common.vo.ResultVo;
import com.rainyhon.common.vo.UserInfo;
import com.rainyhon.common.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rainyhon.common.util.CommonUtil.exceptionMessageIs;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private PsmUserService psmUserService;

	@Autowired
	private UserService userService;

	@PostMapping("addUser")
	public ResultVo<?> addUser(@RequestBody User user) {
		try {
			userService.addUser(user);
		} catch (CommonException e) {
			if (exceptionMessageIs(e, ExceptionType.USER_ALREADY_EXISTS)) {
				return ResultVo.fail("User already exist");
			}

			throw e;
		}

		return ResultVo.ok();
	}

	@PostMapping("deleteUser")
	public ResultVo<?> deleteUserById(@RequestParam String id) {
		userService.deleteUserById(id);
		return ResultVo.ok();
	}

	@PostMapping("batchDeleteUser")
	public ResultVo<?> batchDeleteUserById(@RequestBody List<String> idList) {
		userService.batchDelete(idList);
		return ResultVo.ok();
	}

	@PostMapping("updateUser")
	public ResultVo<?> updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return ResultVo.ok();
	}

	@GetMapping("getUserList")
	public ResultVo<PageInfo<UserVo>> getUserList(@RequestParam String orgId,
	                                              @RequestParam Integer pageIndex,
	                                              @RequestParam Integer pageSize) {
		return ResultVo.ok(userService.getUserList(orgId, pageIndex, pageSize));
	}

	@GetMapping("getUserByUsername")
	public UserInfo getUserByUserName(@RequestParam(name = "username") String username) {
		return userService.getUserByUsername(username);
	}

	@GetMapping("getUserListByTeamId")
	public ResultVo getUserListByTeamId(@RequestParam String id) {
		return ResultVo.ok(psmUserService.getUserListByOrgId(id));
	}

}
