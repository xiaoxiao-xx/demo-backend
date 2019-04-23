package com.microcore.center.vo;

import java.io.Serializable;
import java.util.Date;

import com.microcore.center.model.PsmUser;

import com.microcore.center.model.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserInfo extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 20分钟
	 */
	private static long SESSION_TIME = 1000 * 60 * 20;

	private PsmUser psmUser;

	private Date visitTime;

//	private DbOrg dbOrg;

//	private List<RoleInfo> roles;

//	private List<ResourceInfo> resources;

	private Long lastAccessTime;

	private Boolean isLogged;

	private String token;

	public boolean isSessionOut() {
		if (visitTime == null) {
			return true;
		}
		return new Date().getTime() - visitTime.getTime() >= SESSION_TIME;
	}

	public void refresh() {
		this.visitTime = new Date();
	}

}
