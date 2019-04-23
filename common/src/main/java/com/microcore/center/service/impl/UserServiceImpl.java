package com.microcore.center.service.impl;

import com.microcore.center.constant.Constants;
import com.microcore.center.mapper.UserMapper;
import com.microcore.center.model.PsmUser;
import com.microcore.center.model.User;
import com.microcore.center.model.UserExample;
import com.microcore.center.service.UserService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.ExceptionListener;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public PsmUser getPsmUser(String userName) {
		return null;
	}

	@Override
	public String getPsmUserRealName(String userName) {
		return null;
	}

	@Override
	public PsmUser getPsmUserById(String id) {
		return null;
	}

	@Override
	public void add(PsmUser psmUser) {

	}

	@Override
	public void delete(String userName) {

	}

	@Override
	public void deleteById(String id) {

	}

	@Override
	public void update(PsmUser psmUser) {

	}

	@Override
	public List<PsmUser> getUserListByOrgId(String orgId) {
		return null;
	}

	@Override
	public UserInfo getUserByUsername(String username) {
		List<User> userList = getUserInfoByUsername(username);
		if (CommonUtil.isNotEmpty(userList)) {
			User user =  userList.get(0);
			UserInfo userInfo = CommonUtil.po2VO(user, UserInfo.class);
			return userInfo;
		}

		return null;
	}

	private List<User> getUserInfoByUsername(String username) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andDelStatusEqualTo(Constants.DEL_STATUS_NOR);
		return userMapper.selectByExample(example);
	}

}
