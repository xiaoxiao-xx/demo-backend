package com.microcore.center.service;

import com.microcore.center.model.PsmUser;
import com.microcore.center.model.User;
import com.microcore.center.vo.UserInfo;

import java.util.List;

public interface UserService {

	PsmUser getPsmUser(String userName);

	String getPsmUserRealName(String userName);

	PsmUser getPsmUserById(String id);

	void add(PsmUser psmUser);

	void delete(String userName);

	void deleteById(String id);

	void update(PsmUser psmUser);

	List<PsmUser> getUserListByOrgId(String orgId);

	UserInfo getUserByUsername(String username);

}
