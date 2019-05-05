package com.rainyhon.common.service;

import com.rainyhon.common.exception.CommonException;
import com.rainyhon.common.mapper.PsmUserMapper;
import com.rainyhon.common.model.PsmUser;
import com.rainyhon.common.model.PsmUserExample;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service
//@Transactional
public class PsmUserService {

	@Autowired
	private PsmUserMapper psmUserMapper;

	private PsmUser getPsmUser(String userName) {
		if (StringUtil.isEmpty(userName)) {
			return null;
		}
		PsmUserExample example = new PsmUserExample();
		PsmUserExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(userName);
		List<PsmUser> list = psmUserMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public PsmUser getPsmUserById(String id) {
		return psmUserMapper.selectByPrimaryKey(id);
	}

	private void add(PsmUser psmUser) {
		if (getPsmUser(psmUser.getUsername()) != null) {
			throw new CommonException("用户名重复！");
		}
		psmUser.setId(CommonUtil.getUUID());
		psmUserMapper.insert(psmUser);
	}

	private void delete(String userName) {
		PsmUserExample example = new PsmUserExample();
		PsmUserExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(userName);
		psmUserMapper.deleteByExample(example);
	}

	private void deleteById(String id) {
		psmUserMapper.deleteByPrimaryKey(id);
	}

	private void update(PsmUser psmUser) {
		psmUserMapper.updateByPrimaryKey(psmUser);
	}

	private List<PsmUser> getUserListByOrgId(String orgId) {
		PsmUserExample example = new PsmUserExample();
		PsmUserExample.Criteria criteria = example.createCriteria();
		criteria.andOrgIdEqualTo(orgId);
		return psmUserMapper.selectByExample(example);
	}

	private String getUserRealName(String userName) {
		PsmUser psmUser = this.getPsmUser(userName);
		if (psmUser != null) {
			return psmUser.getRealname();
		}
		return null;
	}

}

