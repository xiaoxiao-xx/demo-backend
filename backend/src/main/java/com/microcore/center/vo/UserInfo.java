package com.microcore.center.vo;

import java.io.Serializable;
import java.util.Date;

import com.microcore.center.model.PsmUser;

import lombok.Data;

@Data
public class UserInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 390931695727428049L;

	/**
	 * 20分钟
	 */
	private static long SESSION_TIME = 1000 * 60 * 20;
	
	private PsmUser psmUser;

	private Date visitTime;

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
