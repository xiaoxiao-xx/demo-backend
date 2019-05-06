package com.rainyhon.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rainyhon.common.mapper.KeyPersonMapper;
import com.rainyhon.common.model.KeyPerson;
import com.rainyhon.common.model.KeyPersonExample;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.EntityUtils;
import com.rainyhon.common.vo.KeyPersonVo;
import com.rainyhon.common.vo.PersonDeleteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static com.rainyhon.common.constant.Constants.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class KeyPersonService {

	@Autowired
	private KeyPersonMapper keyPersonMapper;

	@Autowired
	private PersonInfoService personInfoService;

	public void addKeyPerson(KeyPerson keyPerson) {
		String id = CommonUtil.getUUID();
		keyPerson.setId(id);
		keyPerson.setAttentionTime(new Date());
		EntityUtils.setCreateAndUpdateInfo(keyPerson);
		keyPersonMapper.insert(keyPerson);

		personInfoService.setImptCareStatus(keyPerson.getPersonId(), IMPT_CARE_TURE);
	}

	public void batchDelete(PersonDeleteVo vo) {
		List<String> idList = vo.getIdList();
		idList.forEach(this::deleteById);
	}

	public void deleteById(String personId) {
		KeyPersonExample example = new KeyPersonExample();
		KeyPersonExample.Criteria criteria = example.createCriteria();
		criteria.andPersonIdEqualTo(personId);
		// criteria.andDelStatusEqualTo(DELETE_STATUS_NO);

		KeyPerson person = new KeyPerson();
		person.setDelStatus(DELETE_STATUS_YES);
		keyPersonMapper.updateByExampleSelective(person, example);

		personInfoService.setImptCareStatus(personId, IMPT_CARE_FALSE);
	}

	public void update(KeyPerson keyPerson) {
		keyPersonMapper.updateByPrimaryKeySelective(keyPerson);
	}

	public PageInfo<KeyPersonVo> getKeyPersonList(Integer pageIndex, Integer pageSize) {
		KeyPersonExample example = new KeyPersonExample();
		KeyPersonExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(DELETE_STATUS_NO);
		PageInfo<Object> pageInfo = PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(()
				-> keyPersonMapper.selectByExample(example));
		List<Object> list = pageInfo.getList();
		List<KeyPersonVo> personVoList = CommonUtil.listPo2VO(list, KeyPersonVo.class);
		personVoList.forEach(vo -> {
			vo.setPersonName(personInfoService.getPersonInfoName(vo.getPersonId()));

		});
		PageInfo<KeyPersonVo> voPageInfo = CommonUtil.po2VO(pageInfo, PageInfo.class);
		voPageInfo.setList(personVoList);
		return voPageInfo;
	}

}

