package com.rainyhon.backend.controller;

import com.github.pagehelper.PageInfo;
import com.rainyhon.backend.task.ScheduleTask;
import com.rainyhon.backend.task.WorkTask;
import com.rainyhon.common.model.User;
import com.rainyhon.common.service.UserService;
import com.rainyhon.common.vo.ResultVo;
import com.rainyhon.common.vo.UserInfo;
import com.rainyhon.common.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("addUser")
	public ResultVo<?> addUser(@RequestBody UserVo user) {
		userService.addUser(user);
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
	public ResultVo<PageInfo<UserVo>> getUserList(@RequestParam(required = false) String orgId,
	                                              @RequestParam Integer pageIndex,
	                                              @RequestParam Integer pageSize) {
		return ResultVo.ok(userService.getUserList(orgId, pageIndex, pageSize));
	}

	@GetMapping("getUserDetailByUserId")
	public ResultVo<UserVo> getUserDetailByUserId(@RequestParam String userId) {
		return ResultVo.ok(userService.getUserDetailById(userId));
	}

	@GetMapping("getUserByUsername")
	public UserInfo getUserByUserName(@RequestParam(name = "username") String username) {
		return userService.getUserByUsername(username);
	}

	@GetMapping("getResourcesByUserId")
	public ResultVo<?> getResourcesByUserId(@RequestParam String userId) {
		return ResultVo.ok(userService.getResourcesByUserId(userId));
	}

//	@GetMapping("getUserListByTeamId")
//	public ResultVo getUserListByTeamId(@RequestParam String id) {
//		return ResultVo.ok(userService.getUserListByOrgId(id));
//	}

	@Autowired
	ScheduleTask scheduleTask;

	@Autowired
	WorkTask workTask;
	@PostMapping("testgen")
	public ResultVo testGen() {
		scheduleTask.generateScheduleDetail();
		workTask.generateWorkAttendance();
		return ResultVo.ok();
	}

}
