package com.microcore.center.vo;

import java.io.Serializable;
import java.util.Date;

import com.microcore.center.model.PsmUser;

import lombok.Data;

@Data
public class UserInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 390931695727428049L;
	
	private PsmUser psmUser ;
	
	private Date visitTime ;
}
