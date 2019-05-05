package com.rainyhon.common.vo;

import java.io.Serializable;

import com.rainyhon.common.model.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserInfo extends User implements Serializable {

	// 注意: User 也要 implements Serializable
	private static final long serialVersionUID = 1L;

	private String orgId;

	private Long lastAccessTime;

	private Boolean isLogged;

	private String token;

//	/**
//	 * 20分钟
//	 */
//	private static long SESSION_TIME = 1000 * 60 * 20;

//	private Date visitTime;

//	private Org dbOrg;

//	private List<RoleInfo> roles;

//	private List<ResourceInfo> resources;

//	public boolean isSessionOut() {
//		if (visitTime == null) {
//			return true;
//		}
//		return new Date().getTime() - visitTime.getTime() >= SESSION_TIME;
//	}

//	public void refresh() {
//		this.visitTime = new Date();
//	}

}

