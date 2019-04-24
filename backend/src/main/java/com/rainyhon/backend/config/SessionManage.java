package com.rainyhon.backend.config;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.microcore.center.model.PsmUser;
import com.microcore.center.util.JwtUtil;
import com.microcore.center.vo.UserInfo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class SessionManage {

	private static Map<String, UserInfo> session = new HashMap<>();

	public static void login(PsmUser psmUser) {
		UserInfo userInfo = new UserInfo();
		userInfo.setPsmUser(psmUser);
		userInfo.setVisitTime(new Date());
		session.put(userInfo.getPsmUser().getUsername(), userInfo);
	}

	public static void logout(UserInfo userInfo) {
		session.remove(userInfo.getPsmUser().getUsername());
	}

	public static void logout(String userName) {
		session.remove(userName);
	}

	public static boolean isLogin(String jwtToken) {
		try {
			String userName = (String) JwtUtil.parseJwtToken(jwtToken).getBody().get("jti");
			UserInfo userInfo = session.get(userName);
			if (userInfo != null && !userInfo.isSessionOut()) {
				userInfo.refresh();
				return true;
			}
		} catch (Exception e) {
			log.error("用户token非法！");
		}
		return false;
	}

	public static void checkAllUser() {
		List<String> keys = new ArrayList<>();
		session.forEach((k, v) -> {
			if (v.isSessionOut()) {
				keys.add(k);
			}
		});
		keys.forEach(SessionManage::logout);
	}

}
