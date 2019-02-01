package com.microcore.center.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.microcore.center.dto.UserDTO;
import com.microcore.center.mapper.SysRoleMapper;
import com.microcore.center.mapper.SysUserMapper;
import com.microcore.center.mapper.SysUserRoleMapper;
import com.microcore.center.model.*;
import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.PasswordUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service class for managing users.
 */
@Service
@Transactional
@Slf4j
public class UserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Autowired
	private SysRoleMapper sysRoleMapper;

	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;

	/**
	 * 新建用户
	 *
	 * @param userDTO
	 * @return SysUser对象
	 */
	public SysUser createUser(UserDTO userDTO) {
		SysUser sysUser = new SysUser();
		sysUser.setId(CommonUtil.getUUID());
		sysUser.setUsername(userDTO.getUsername());
		sysUser.setCompany(userDTO.getCompany());
		sysUser.setTel(userDTO.getTel());
		sysUser.setAccount(userDTO.getAccount());
		sysUser.setPassword(PasswordUtil.encrypt(userDTO.getUsername() + userDTO.getPassword()));
		sysUser.setIsEnable(0);
		sysUser.setIsLock(0);
		sysUserMapper.insert(sysUser);
		//不返回密码
		sysUser.setPassword(null);
		return sysUser;
	}


	/**
	 * 用户修改
	 *
	 * @param userDTO
	 * @return
	 */
	public Optional<UserDTO> updateUser(UserDTO userDTO) {
		SysUser sysUser = sysUserMapper.selectByPrimaryKey(userDTO.getId());
		if (sysUser != null) {
			sysUser.setCompany(userDTO.getCompany());
			sysUser.setTel(userDTO.getTel());
			sysUser.setUsername(userDTO.getUsername());
			sysUserMapper.updateByPrimaryKey(sysUser);
			return Optional.of(userDTO);
		}
		return Optional.of(null);
	}


	public void getAllUsers() {
		PageHelper.startPage(1, 20);
		List<SysUser> countries = sysUserMapper.findAll();
		System.out.println("Total: " + ((Page) countries).getTotal());
	}

	/**
	 * 获取权限列表
	 *
	 * @return
	 */
	public List<SysRole> getAuthorities() {
		SysRoleExample example = new SysRoleExample();
		SysRoleExample.Criteria criteria = example.createCriteria();
		criteria.andIdIsNotNull();
		return sysRoleMapper.selectByExample(example);
	}

	/**
	 * 根据用户id获取权限列表
	 *
	 * @param userId
	 * @return
	 */
	public List<SysRole> getAuthByUserId(String userId) {
		SysUserRoleExample example = new SysUserRoleExample();
		SysUserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		return sysUserRoleMapper.selectByExample(example).stream().map(sysUserRole -> {
			SysRole sysRole = new SysRole();
			sysRole.setId(sysUserRole.getRoleId());
			return sysRole;
		}).collect(Collectors.toList());

	}

	/**
	 * 删除用户
	 *
	 * @param id 用户ID
	 */
	public void deleteUser(String id) {
		SysUser sysUser = sysUserMapper.selectByPrimaryKey(id);
		if (sysUser != null) {
			sysUser.setIsEnable(0);
		}
		sysUserMapper.updateByPrimaryKey(sysUser);
		//TODO 获取当前用户并记录
		log.info("Deleted User: {}", sysUser);
	}


	/**
	 * 通过登陆名获取用户
	 *
	 * @param username 用户名
	 * @return SysUser对象
	 * @throws UsernameNotFoundException
	 */
	public SysUser getUserBylogin(String username) throws UsernameNotFoundException {
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<SysUser> list = sysUserMapper.selectByExample(example);
		if (list.size() > 0) {
			return list.get(0);
		}
		return new SysUser();
	}

	/**
	 * 通过ID获取用户
	 *
	 * @param userId 用户ID
	 * @return SysUser对象
	 * @throws UsernameNotFoundException
	 */
	public SysUser getUserById(String userId) throws UsernameNotFoundException {
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(userId);
		// criteria.andIsEnableEqualTo(1);
		List<SysUser> list = sysUserMapper.selectByExample(example);
		if (list.size() > 0) {
			return list.get(0);
		}

		return new SysUser();
	}


	/**
	 * 通过ID获取用户名
	 *
	 * @param userId 用户ID
	 * @return SysUser对象
	 * @throws UsernameNotFoundException
	 */
	public String getUserNameById(String userId) {
		if (userId == null) {
			return "";
		}

		SysUser sysUser = getUserById(userId);
		return Optional.ofNullable(sysUser.getUsername()).orElse("");
	}

	public List<String> getUserListLikeName(String name) {
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameLike("%" + name.trim() + "%");
		List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
		List<String> list = new ArrayList<>();
		if (CommonUtil.isNotEmpty(sysUsers)) {
			for (SysUser user : sysUsers) {
				list.add(user.getId());
			}
		}else {
			list.add("NULL");
		}
		return list;
	}
}
