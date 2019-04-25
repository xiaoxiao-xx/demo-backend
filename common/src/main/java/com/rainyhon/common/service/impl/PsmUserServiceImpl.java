package com.rainyhon.common.service.impl;

import com.rainyhon.common.exception.CommonException;
import com.microcore.center.mapper.PsmUserMapper;
import com.microcore.center.model.PsmUser;
import com.microcore.center.model.PsmUserExample;
import com.rainyhon.common.service.PsmUserService;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PsmUserServiceImpl implements PsmUserService {

	@Autowired
	private PsmUserMapper psmUserMapper;

	@Override
	public PsmUser getPsmUser(String userName) {
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

	@Override
	public PsmUser getPsmUserById(String id) {
		return psmUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public void add(PsmUser psmUser) {
		if (getPsmUser(psmUser.getUsername()) != null) {
			throw new CommonException("用户名重复！");
		}
		psmUser.setId(CommonUtil.getUUID());
		psmUserMapper.insert(psmUser);
	}

	@Override
	public void delete(String userName) {
		PsmUserExample example = new PsmUserExample();
		PsmUserExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(userName);
		psmUserMapper.deleteByExample(example);
	}

	@Override
	public void deleteById(String id) {
		psmUserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(PsmUser psmUser) {
		psmUserMapper.updateByPrimaryKey(psmUser);
	}

    @Override
    public List<PsmUser> getUserListByOrgId(String orgId) {
		PsmUserExample example = new PsmUserExample();
		PsmUserExample.Criteria criteria = example.createCriteria();
		criteria.andOrgIdEqualTo(orgId);
		return psmUserMapper.selectByExample(example);
    }

    @Override
	public String getPsmUserRealName(String userName) {
		PsmUser psmUser = this.getPsmUser(userName);
		if (psmUser != null) {
			return psmUser.getRealname();
		}
		return null;
	}

}
