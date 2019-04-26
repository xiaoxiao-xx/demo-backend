package com.rainyhon.common.service;

import com.github.pagehelper.PageInfo;
import com.rainyhon.common.model.User;
import com.rainyhon.common.vo.UserInfo;
import com.rainyhon.common.vo.UserVo;

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
