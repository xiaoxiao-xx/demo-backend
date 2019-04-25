package com.rainyhon.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rainyhon.common.constant.Constants;
import com.rainyhon.common.constant.ExceptionType;
import com.rainyhon.common.exception.CommonException;
import com.microcore.center.mapper.UserMapper;
import com.microcore.center.model.User;
import com.microcore.center.model.UserExample;
import com.rainyhon.common.service.UserService;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.EntityUtils;
import com.rainyhon.common.vo.UserInfo;
import com.rainyhon.common.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void addUser(User user) {
		String username = user.getUsername().trim();
		UserInfo userInfo = getUserByUsername(username);
		if (userInfo != null) {
			throw new CommonException(ExceptionType.USER_ALREADY_EXISTS);
		}

		user.setId(CommonUtil.getUUID());
		String password = user.getPassword();
		user.setPassword(passwordEncoder.encode((password)));
		user.setLocked(0);
		user.setLoginErrorCount(0);
		EntityUtils.setCreateAndUpdateInfo(user);
		userMapper.insert(user);
	}

	@Override
	public void deleteUserById(String id) {
		User user = new User();
		user.setId(id);
		user.setDelStatus(Constants.DELETE_STATUS_YES);
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public void batchDelete(List<String> idList) {
		if (CommonUtil.isNotEmpty(idList)) {
			idList.forEach(id -> userMapper.deleteByPrimaryKey(id));
		}
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public List<User> getUserListByOrgId(String orgId) {
		return null;
	}

	@Override
	public UserInfo getUserByUsername(String username) {
		List<User> userList = getUserInfoByUsername(username);
		if (CommonUtil.isNotEmpty(userList)) {
			User user = userList.get(0);
			UserInfo userInfo = CommonUtil.po2VO(user, UserInfo.class);
			return userInfo;
		}

		return null;
	}

	@Override
	public List<User> getUserInfoByUsername(String username) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andDelStatusEqualTo(Constants.DELETE_STATUS_NO);
		return userMapper.selectByExample(example);
	}

	@Override
	public PageInfo<UserVo> getUserList(String orgId, Integer pageIndex, Integer pageSize) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(Constants.DELETE_STATUS_NO);

		if (StringUtils.isNotBlank(orgId)) {
			criteria.andOrgIdEqualTo(orgId.trim());
		}

		PageInfo<User> pageInfo = PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(()
				-> userMapper.selectByExample(example));

		List<UserVo> voList = CommonUtil.listPo2VO(pageInfo.getList(), UserVo.class);
		PageInfo<UserVo> voPageInfo = CommonUtil.po2VO(pageInfo, PageInfo.class);
		voPageInfo.setList(voList);
		return voPageInfo;
	}

}
