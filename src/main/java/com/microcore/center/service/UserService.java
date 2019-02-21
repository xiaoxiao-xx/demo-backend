package com.microcore.center.service;

import com.microcore.center.model.PsmUser;

public interface UserService {
	
	public PsmUser getPsmUser(String userName);

	public String getPsmUserRealName(String userName);
	
	public PsmUser getPsmUserById(String id);

	public void add(PsmUser psmUser);

	public void delete(String userName);

	public void deleteById(String id);

	public void update(PsmUser psmUser);

}
