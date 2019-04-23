package com.microcore.center.service;

import com.github.pagehelper.PageInfo;
import com.microcore.center.model.User;
import com.microcore.center.vo.UserInfo;
import com.microcore.center.vo.UserVo;

import java.util.List;

public interface UserService {

	void addUser(User user);

	void deleteUserById(String userName);

//	void changePassword(String password);

	void batchDelete(List<String> idList);

	void updateUser(User user);

	List<User> getUserListByOrgId(String orgId);

	UserInfo getUserByUsername(String username);

	List<User> getUserInfoByUsername(String username);

	PageInfo<UserVo> getUserList(String orgId, Integer pageIndex, Integer pageSize);

}
