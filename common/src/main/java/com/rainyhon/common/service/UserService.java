package com.rainyhon.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rainyhon.common.constant.Constants;
import com.rainyhon.common.exception.CommonException;
import com.rainyhon.common.mapper.UserMapper;
import com.rainyhon.common.mapper.UserRoleRelationMapper;
import com.rainyhon.common.model.*;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.EntityUtils;
import com.rainyhon.common.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.Action;
import java.util.*;
import java.util.stream.Collectors;

import static com.rainyhon.common.constant.Constants.DELETE_STATUS_NO;
import static com.rainyhon.common.exception.CommonExceptionType.USER_ALREADY_EXISTS;
import static com.rainyhon.common.util.CommonUtil.*;
import static java.util.stream.Collectors.toSet;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRoleRelationMapper userRoleRelationMapper;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PersonInfoService personInfoService;

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

	public String getUserNameById(String id) {
		User user = getUserById(id);
		if (user == null) {
			return "";

		}
		return Optional.of(user.getUsername()).orElse("");
	}

	public List<User> getUserListByOrgId(String orgId) {

		return null;
	}

	public UserInfo getUserByUsername(String username) {
		List<User> userList = getUserInfoByUsername(username);
		if (isEmpty(userList)) {
			return null;
		}

		User user = userList.get(0);
		UserInfo userInfo = po2VO(user, UserInfo.class);
		userInfo.setOrgId(getOrgIdByUserId(userInfo.getId()));
		return userInfo;
	}

	public List<User> getUserInfoByUsername(String username) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andDelStatusEqualTo(DELETE_STATUS_NO);
		return userMapper.selectByExample(example);
	}

	public PageInfo<UserVo> getUserList(String orgId, Integer pageIndex, Integer pageSize) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(DELETE_STATUS_NO);

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
		PageInfo<UserVo> voPageInfo = po2VO(pageInfo, PageInfo.class);
		voPageInfo.setList(voList);
		return voPageInfo;
	}

	public UserVo getUserDetailById(String userId) {
		User user = getUserById(userId);
		UserVo vo = po2VO(user, UserVo.class);
		vo.setRoleList(listPo2VO(roleService.getRoleListByUserId(userId), RoleVo.class));
		return vo;
	}

	public User getUserById(String userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	public String getRealPersonIdByUserId(String userId) {
		User user = getUserById(userId);
		if (user == null) {
			return "";
		}

		return Optional.ofNullable(user.getRealPersonId()).orElse("");
	}

	public String getOrgIdByUserId(String userId) {
		String realPersonId = getRealPersonIdByUserId(userId);
		PersonInfo personInfo = personInfoService.getPersonInfo(realPersonId);
		if (personInfo == null) {
			return "";
		}

		return Optional.ofNullable(personInfo.getOrgId()).orElse("");
	}

	@Autowired
	private PermissionService permissionService;

	@Autowired
	private ResourceService resourceService;

	public List<ResourceVo> getResourcesByUserId(String userId) {
		Map<String, ResourceVo> resourceVoMap = new HashMap<>();

		List<Role> roleList = roleService.getRoleListByUserId(userId);

		for (Role role : roleList) {
			List<PermissionVo> permissionVoList = permissionService.getPermissionsByRoleId(role.getId());

			for (PermissionVo permissionVo : permissionVoList) {
				// 权限只和二级菜单相关联
				List<ResourceVo> resourceList = resourceService.getResourcesByPermissionId(permissionVo.getId());
				resourceList.forEach(resourceVo -> {
					resourceVoMap.put(resourceVo.getId(), resourceVo);
				});
			}
		}

		// TODO 合并并排序
		List<ResourceVo> list = mergeResourceTree(resourceVoMap);

//		Resource resource = new Resource();
		// getLevel 1 resources and get theis child
//		return Resource Tree
//		Constants.RESOURCE_TYPE_MENU;

		return list;
	}

	private List<ResourceVo> mergeResourceTree(Map<String, ResourceVo> resourceVoMap) {
		Set<String> parents = resourceVoMap.values().stream()
				.map(Resource::getParentId).filter(Objects::nonNull).collect(toSet());

		Map<String, ResourceVo> parentMap = new HashMap<>();
		parents.forEach(parent -> parentMap.put(parent, resourceService.getResourceVoById(parent)));

		Set<ResourceVo> voSet = new HashSet<>(resourceVoMap.values());
		voSet.forEach(vo -> {
			ResourceVo resourceVo = parentMap.get(vo.getParentId());
			if (resourceVo == null) {
				return;
			}
			List<ResourceVo> children = resourceVo.getChildren();
			children.add(vo);
		});

		return new ArrayList<>(parentMap.values());
	}

}
