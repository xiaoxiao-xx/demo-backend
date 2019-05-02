package com.rainyhon.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.mapper.UserRoleRelationMapper;
import com.microcore.center.model.Role;
import com.microcore.center.model.UserRoleRelation;
import com.rainyhon.common.constant.Constants;
import com.rainyhon.common.exception.CommonException;
import com.rainyhon.common.mapper.UserMapper;
import com.rainyhon.common.model.User;
import com.rainyhon.common.model.UserExample;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.EntityUtils;
import com.rainyhon.common.vo.RoleVo;
import com.rainyhon.common.vo.UserInfo;
import com.rainyhon.common.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.rainyhon.common.exception.CommonExceptionType.USER_ALREADY_EXISTS;
import static com.rainyhon.common.util.CommonUtil.listPo2VO;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRoleRelationMapper userRoleRelationMapper;

	public void addUser(UserVo vo) {
		String username = vo.getUsername().trim();
		UserInfo userInfo = getUserByUsername(username);
		if (userInfo != null) {
			throw new CommonException(USER_ALREADY_EXISTS);
		}

		String userId = CommonUtil.getUUID();
		vo.setId(userId);
		String password = vo.getPassword();
		vo.setPassword(passwordEncoder.encode((password)));
		vo.setLocked(0);
		vo.setLoginErrorCount(0);
		EntityUtils.setCreateAndUpdateInfo(vo);
		userMapper.insert(vo);

		List<String> roleIdList = vo.getRoleIdList();
		if (roleIdList == null) {
			roleIdList = new ArrayList<>();
		}

		roleIdList.forEach(roleId -> {
			UserRoleRelation relation = new UserRoleRelation();
			relation.setId(CommonUtil.getUUID());
			relation.setUserId(userId);
			relation.setRoleId(roleId);
			userRoleRelationMapper.insert(relation);
		});
	}

	public void deleteUserById(String id) {
		User user = new User();
		user.setId(id);
		user.setDelStatus(Constants.DELETE_STATUS_YES);
		userMapper.updateByPrimaryKeySelective(user);
	}

	public void batchDelete(List<String> idList) {
		if (CommonUtil.isNotEmpty(idList)) {
			idList.forEach(id -> userMapper.deleteByPrimaryKey(id));
		}
	}

	public void updateUser(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}

	public List<User> getUserListByOrgId(String orgId) {
		return null;
	}

	public UserInfo getUserByUsername(String username) {
		List<User> userList = getUserInfoByUsername(username);
		if (CommonUtil.isNotEmpty(userList)) {
			User user = userList.get(0);
			UserInfo userInfo = CommonUtil.po2VO(user, UserInfo.class);
			return userInfo;
		}

		return null;
	}

	public List<User> getUserInfoByUsername(String username) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andDelStatusEqualTo(Constants.DELETE_STATUS_NO);
		return userMapper.selectByExample(example);
	}

	public PageInfo<UserVo> getUserList(String orgId, Integer pageIndex, Integer pageSize) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(Constants.DELETE_STATUS_NO);

		if (StringUtils.isNotBlank(orgId)) {
			// criteria.andOrgIdEqualTo(orgId.trim());
		}

		PageInfo<User> pageInfo = PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(()
				-> userMapper.selectByExample(example));

		List<UserVo> voList = listPo2VO(pageInfo.getList(), UserVo.class);
		voList.forEach(vo -> {
			List<Role> roleList = roleService.getRoleListByUserId(vo.getId());
			List<RoleVo> roleVoList = listPo2VO(roleList, RoleVo.class);
			vo.setRoleList(roleVoList);
		});
		PageInfo<UserVo> voPageInfo = CommonUtil.po2VO(pageInfo, PageInfo.class);
		voPageInfo.setList(voList);
		return voPageInfo;
	}

	@Autowired
	private RoleService roleService;

	public UserVo getUserDetailById(String userId) {
		User user = getUserById(userId);
		UserVo vo = CommonUtil.po2VO(user, UserVo.class);
		vo.setRoleList(listPo2VO(roleService.getRoleListByUserId(userId), RoleVo.class));
		return vo;
	}

	private User getUserById(String userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

}
