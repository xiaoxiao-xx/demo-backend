package com.rainyhon.common.util;

import com.rainyhon.common.vo.UserInfo;

import static com.rainyhon.common.context.AuthContextHandler.getDbUserDto;
import static java.util.Optional.ofNullable;

/**
 * 当前登录用户信息获取工具类
 *
 * @author lmh
 */
public class UserUtil {

	/**
	 * 获取当前登录用户
	 *
	 * @return SysUser对象
	 */
	public static UserInfo getCurrentLoginUser() {
		return ofNullable((UserInfo) getDbUserDto()).orElse(new UserInfo());
	}

	/**
	 * 获取当前登录用户的ID
	 *
	 * @return 用户ID字符串
	 */
	public static String getUserId() {
		return ofNullable(getCurrentLoginUser().getId()).orElse("");
	}

	/**
	 * 获取当前登录用户的组织机构ID
	 *
	 * @return 机构ID字符串
	 */
	public static String getOrgId() {
		return ofNullable(getCurrentLoginUser().getOrgId()).orElse("");
	}

}

