package com.microcore.center.controller;

import com.microcore.api.vo.UserInfo;
import com.microcore.auth.security.SecurityUtils;
import com.microcore.center.dto.UserDTO;
import com.microcore.center.model.SysRole;
import com.microcore.center.model.SysUser;
import com.microcore.center.service.impl.UserService;
import com.microcore.common.constant.Constants;
import com.microcore.common.util.ResultVo;
import com.microcore.common.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Value("${jwt.header}")
	private String tokenHeader;

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 创建用户 用户注册
	 *
	 * @param userDTO
	 * @return
	 */
	@PostMapping("/users")
	public ResultVo<SysUser> createUser(@Valid @RequestBody UserDTO userDTO) throws Exception {
		log.debug("REST request to save User : {}", userDTO);
		SysUser newUser = userService.createUser(userDTO);
		return ResultVo.ok(newUser);
	}

	@PutMapping("/users")
	public ResultVo updateUser(@Valid @RequestBody UserDTO userDTO) {
		log.debug("REST request to update User : {}", userDTO);
		userService.updateUser(userDTO);
		return ResultVo.ok();

	}

	@GetMapping("/users")
	public ResultVo<List<UserDTO>> getAllUsers(Pageable pageable) {
		return ResultVo.ok();
	}

	@GetMapping("/users/authorities")
	public ResultVo<List<SysRole>> getAuthorities() {
		return ResultVo.ok(userService.getAuthorities());
	}

	@GetMapping("/users/{login:" + Constants.LOGIN_REGEX + "}")
	public ResultVo getUser(@PathVariable String login) {
		UserInfo currentUser = SecurityUtils.getCurrentUserLogin().orElse(new UserInfo());
		log.debug("REST request to get User : {} ,currentUser orgid:{} ", login, currentUser.getOrgId());
		return ResultVo.ok(userService.getUserBylogin(login));
	}

	@GetMapping("/getCurrentLoggedInUsersOrgId")
	public ResultVo<String> getCurrentLoggedInUsersOrgId() {
		return ResultVo.ok(UserUtil.getOrgId());
	}

	@GetMapping("/getCurrentLoginUser")
	public ResultVo<UserInfo> getCurrentLoginUser() {
		return ResultVo.ok(UserUtil.getCurrentLoginUser());
	}

	/**
	 * 逻辑删除用户
	 *
	 * @param id
	 * @return
	 */
	@DeleteMapping("/users/{login:" + Constants.LOGIN_REGEX + "}")
	public ResultVo deleteUser(@PathVariable String id) {
		log.debug("REST request to delete User: {}", id);
		userService.deleteUser(id);
		return ResultVo.ok();
	}

}
