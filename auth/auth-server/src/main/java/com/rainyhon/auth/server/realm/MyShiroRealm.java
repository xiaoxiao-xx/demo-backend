package com.rainyhon.auth.server.realm;

import com.rainyhon.api.SysApi;
import com.rainyhon.common.util.JedisPoolUtil;
import com.rainyhon.common.vo.UserInfo;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

public class MyShiroRealm extends AuthorizingRealm {

	@Autowired
	private SysApi sysApi;

//	@Autowired
//	private SendUtil sendUtil;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JedisPoolUtil jedisPoolUtil;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		Set<String> stringPermissions = new HashSet<>();
//		List<ResourceInfo> list = sysApi.queryUserByUsername(username).getResources();
//		for (ResourceInfo resourceInfo : list) {
//			stringPermissions.add(resourceInfo.getUrl());
//		}
		authorizationInfo.setStringPermissions(stringPermissions);
		return authorizationInfo;
	}

	/**
	 * 验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken)
			throws AuthenticationException {
		MyUsernamePasswordToken token = (MyUsernamePasswordToken) authToken;
		String username = token.getUsername();
		UserInfo dbUser = sysApi.getUserByUsername(username);

		if (dbUser == null) {
			throw new AuthenticationException("用户不存在");
		}
//		else if (jedisPoolUtil.exists(dbUser.getId()) && dbUser.getIsLock() == 1) {
//			Jedis jedis = jedisPoolUtil.getJedis();
//			Long ttl;
//			try {
//				ttl = jedis.ttl(dbUser.getId());
//			} finally {
//				jedis.close();
//			}
//			String ttls = TimeUtil.ttl(ttl);
//			throw new AuthenticationException("账号锁定中，解锁请联系管理员。" + ttls + "自动解锁");
//		}
		else if (!passwordEncoder.matches(String.valueOf(token.getPassword()), dbUser.getPassword())) {
			// 密码错误次数 最多输错6次
//			Integer count;
//			String userCount = jedisPoolUtil.get("count" + dbUser.getId());
//			count = (userCount == null) ? 0 : Integer.parseInt(userCount);
//			jedisPoolUtil.setex("count" + dbUser.getId(), 60 * 30, String.valueOf(count + 1));
//			sendUtil.send("sys", "/sysUser/updateErrorCounts", dbUser);
//			if (count >= 5) {
//				setAutoUnlock(dbUser);
//				throw new AuthenticationException("账号锁定！密码输入错误" + (count + 1) + "次，解锁请联系管理员。30分钟后自动解锁");
//			}

			throw new AuthenticationException("密码不正确");
		}
//		else {
//			sendUtil.send("sys", "/sysUser/unLock", dbUser.getId());
//		}

		return new SimpleAuthenticationInfo(dbUser, token.getPassword(), "myShiroRealm");
	}

	private void setAutoUnlock(UserInfo dbUser) {
		if (!jedisPoolUtil.exists(dbUser.getId())) {
//			jedisPoolUtil.setex(dbUser.getId(), 60 * 30, Constants.USER_LOCK);
		}
	}

}

