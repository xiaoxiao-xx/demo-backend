package com.rainyhon.auth.server.controller;

import com.rainyhon.auth.server.realm.MyUsernamePasswordToken;
import com.microcore.center.util.*;
import com.microcore.center.vo.LoginVo;
import com.microcore.center.vo.ResultVo;
import com.microcore.center.vo.UserInfo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("auth")
@Slf4j
public class LoginController {

	/**
	 * 默认超时时长，单位为秒
	 */
	private static final int DEFAULT_SESSION_EXPIRE_TIME = 20000;

	private final JedisPoolUtil jedisPoolUtil;

	@Autowired
	public LoginController(JedisPoolUtil jedisPoolUtil) {
		this.jedisPoolUtil = jedisPoolUtil;
	}

	@ApiOperation(value = "用户登录", notes = "通过用户名密码登录系统")
	@PostMapping("login")
	public ResultVo login(@RequestBody LoginVo loginVo, HttpServletResponse response) {
		if (StringUtil.isEmpty(loginVo.getUsername())) {
			log.info("用户名不能为空！");
			return ResultVo.fail("用户名不能为空！");
		}
		if (StringUtil.isEmpty(loginVo.getUsername())) {
			log.info("密码不能为空！");
			return ResultVo.fail("密码不能为空！");
		}
		String username = loginVo.getUsername().trim();
		String password = loginVo.getPassword().trim();
		log.info("UserName: " + username + ", Password: " + password);

		// 默认存在姓名-uuid键值对就算是登录
		// TODO 如果登录后再次调用本接口，下面几行代码使得即使密码错误也会返回Token。删除下面几行才好
		// 每次登录都要重新验证
		if (jedisPoolUtil.exists(username)) {
			// log.info("已经登录: {}-{}", username, jedisPoolUtil.get(username));
			// response.setHeader("access-token", userToken.get(username));
			return ResultVo.ok(jedisPoolUtil.get(username));
		}

		// 尚未登录，开始登录流程
		MyUsernamePasswordToken token = new MyUsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			// token和MyShiroRealm.doGetAuthenticationInfo()返回的对象对比，相同则通过
			subject.login(token);
		} catch (AuthenticationException e) {
			log.info("账号或者密码错误",e);
			return ResultVo.fail(e.getMessage());
		}
		UserInfo userInfo = (UserInfo) subject.getPrincipal();
		String uuidToken = null;
		try {
			uuidToken = JwtUtil.createJwtToken(userInfo.getId(), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		userInfo.setToken(uuidToken);
//		jedisPoolUtil.setex(username, DEFAULT_SESSION_EXPIRE_TIME, userInfo.getId());
		jedisPoolUtil.setBinary(userInfo.getId(), DEFAULT_SESSION_EXPIRE_TIME, userInfo);
		response.setHeader("access-token", uuidToken);
		return ResultVo.ok(uuidToken);
	}

	@ApiOperation(value = "当前用户的登录名", notes = "获取登录用户名")
	@GetMapping("userInfo")
	public ResultVo getCurrentUserName() {
		return ResultVo.ok(UserUtil.getCurrentLoginUser());
	}

	@ApiOperation(value = "用户注销登录", notes = "注销登录")
	@PostMapping("logout")
	public ResultVo logOut() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		String token = request.getHeader("access-token");
		Boolean exist = jedisPoolUtil.exists(token);
		String username = jedisPoolUtil.hmget(token, "username").get(0);

		if (exist) {
			jedisPoolUtil.del(token);
		}

		if (username != null) {
			jedisPoolUtil.del(username);
		}

		// log.info("已经注销");
		return ResultVo.ok("已经注销");
	}

	@ApiIgnore
	@PostMapping("isLogged")
	public UserInfo isLogged(@RequestBody String token) throws Exception {
		String userID = (String) JwtUtil.parseJwtToken(token).getBody().get("jti");
		// token-map存在并且没有超时为登录
		if (jedisPoolUtil.existsBinary(userID)) {
			UserInfo userInfo = refresh(userID);
			if (userInfo == null) {
				UserInfo dbUserDto = new UserInfo();
				dbUserDto.setIsLogged(false);
				return dbUserDto;
			}
			userInfo.setIsLogged(true);
			userInfo.setToken(token);
			userInfo.setLastAccessTime(System.currentTimeMillis());
			return userInfo;
		} else {
			// 没有登录 或者 token不正确 或者 token超时失效
			UserInfo dbUserDto = new UserInfo();
			dbUserDto.setIsLogged(false);
			return dbUserDto;
		}
	}

	private UserInfo refresh(String userId) {
		// log.info("更新时间 {}", System.currentTimeMillis());
		UserInfo userInfo = jedisPoolUtil.getBinary(userId);
		if (userInfo == null) {
			return null;
		}
		jedisPoolUtil.expireBinary(userId, DEFAULT_SESSION_EXPIRE_TIME);
		return userInfo;
	}

}
