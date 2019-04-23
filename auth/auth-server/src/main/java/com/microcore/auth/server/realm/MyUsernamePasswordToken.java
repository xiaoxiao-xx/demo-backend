package com.microcore.auth.server.realm;

import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author
 */
@Getter
@Setter
public class MyUsernamePasswordToken extends UsernamePasswordToken {

//	private String orgId;

	public MyUsernamePasswordToken(final String username, final String password
//			, final String orgId
	) {
		super(username, password);
//		this.orgId = orgId;
	}

}
