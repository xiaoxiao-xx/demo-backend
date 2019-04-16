package com.microcore.center.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import com.microcore.center.cllient.HttpTemplate;
import com.microcore.center.service.*;
import com.microcore.center.vo.FaceSdkUserVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.constant.Constants;
import com.microcore.center.mapper.PsmPersonInfoMapper;
import com.microcore.center.model.PsmPersonInfo;
import com.microcore.center.model.PsmPersonInfoExample;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.util.StringUtil;
import com.microcore.center.vo.PersonInfoVo;
import com.microcore.center.vo.ResultVo;

@Service
@Transactional
@Slf4j
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PsmPersonInfoMapper psmPersonInfoMapper;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private OperHisService operHisService;

	@Autowired
	private CommonService commonService;

	@Autowired
	private HttpTemplate httpTemplate;

	@Autowired
	private FaceApiService faceApiService;

	@Value("${face.api.ip}")
	private String faceApiIp;

	@Value("${face.api.port}")
	private String faceApiPort;

	@Override
	public ResultVo add(PersonInfoVo personInfoVo) {
		String userId = CommonUtil.getUUID();

		personInfoVo.setPersonId(userId);
		psmPersonInfoMapper.insertSelective(personInfoVo);
		operHisService.add(personInfoVo.getPersonId(), Constants.OPER_HIS_ADD);

		// TODO
		// byte[] image = image2byte(personInfoVo.getPersonalPhoto1());
		// String imageString = CommonUtil.byte2Base64Str(image);

		// addUserFace(image);

		FaceSdkUserVo faceSdkUserVo = new FaceSdkUserVo();
		faceSdkUserVo.setGroup_id("g1");
		faceSdkUserVo.setUser_id(userId);
		faceSdkUserVo.setSeiralNo("uAdd-" + getSerialNumber());
		// TODO
		// faceSdkUserVo.setImage(imageString);
		// faceApiService.addUser(faceSdkUserVo);

		return ResultVo.ok();
	}

	private final ThreadLocal<SimpleDateFormat> df = ThreadLocal.withInitial(()
			-> new SimpleDateFormat("yyyyMMddHHmmss"));

	private String getSerialNumber() {
		long ctm = System.currentTimeMillis();
		return df.get().format(new Date(ctm)) + "-" + ctm % 1000;
	}

	private void addUserFace(byte[] image) {
		FaceSdkUserVo faceSdkUserVo = new FaceSdkUserVo();
		faceSdkUserVo.setGroup_id("g1");

		for (int i = 17; i < 18; i++) {
			faceSdkUserVo.setUser_id("u" + i);

			String serialNumber = getSerialNumber();
			faceSdkUserVo.setSeiralNo("uAdd-" + serialNumber);

			// i = (int) (Math.random() * 10);
			log.info(">>>addUser u=" + "u" + i);
			faceSdkUserVo.setImage(CommonUtil.byte2Base64Str(image));

			String ret = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v1/user_add", faceSdkUserVo, String.class);

			log.info(">>>addUser ret=" + ret);
		}
	}

	@Override
	public PsmPersonInfo getRandomPerson() {
		Map<String, Object> params = new HashMap<>();
		params.put("sql", "SELECT * FROM psm_person_info_t ORDER BY RAND() LIMIT 1");
		Map<String, Object> record = commonService.findOne(params);
		return CommonUtil.map2PO(record, PsmPersonInfo.class);
	}

	@Override
	public ResultVo update(PersonInfoVo personInfoVo) {
		psmPersonInfoMapper.updateByPrimaryKeySelective(personInfoVo);
		operHisService.add(personInfoVo.getPersonId(), Constants.OPER_HIS_UPD);
		return ResultVo.ok();
	}

	@Override
	public ResultVo delete(String id) {
		String[] ids = id.split(",");
		for (String i : ids) {
			psmPersonInfoMapper.deleteByPrimaryKey(i);
			deleteUserFace(i);

			operHisService.add(i, Constants.OPER_HIS_DEL);
		}

		return ResultVo.ok();
	}

	private void deleteUserFace(String id) {
		FaceSdkUserVo faceSdkUserVo = new FaceSdkUserVo();
		faceSdkUserVo.setGroup_id("test_group");
		faceSdkUserVo.setUser_id(id);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		Long ctm = System.currentTimeMillis();
		String seiralNo = df.format(new Date(ctm)) + "-" + ctm % 1000;
		faceSdkUserVo.setSeiralNo("uDel-" + seiralNo);

		String ret = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v1/user_delete", faceSdkUserVo, String.class);
		log.info(">>>userDel ret=" + ret);
	}

	@Override
	public ResultVo getPersonList(String name, String deptId, Integer pageIndex, Integer pageSize) {
		PsmPersonInfoExample example = new PsmPersonInfoExample();
		PsmPersonInfoExample.Criteria criteria = example.createCriteria();
		if (StringUtil.isNotEmpty(name)) {
			criteria.andNameLike("%" + name.trim() + "%");
		}
		if (StringUtils.isNotEmpty(deptId)) {
			criteria.andDeptIdEqualTo(deptId);
		}
		List<PersonInfoVo> listPersonInfoVo = new ArrayList<>();
		PageInfo<PsmPersonInfo> psmPersonInfoPage = PageHelper.startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> psmPersonInfoMapper.selectByExample(example));
		for (PsmPersonInfo psmPersonInfo : psmPersonInfoPage.getList()) {
			String deptName = departmentService.getDepartmentName(psmPersonInfo.getDeptId());
			PersonInfoVo personInfoVo = CommonUtil.po2VO(psmPersonInfo, PersonInfoVo.class);
			personInfoVo.setDeptName(deptName);
			listPersonInfoVo.add(personInfoVo);
		}
		PageInfo<PersonInfoVo> pageInfo = new PageInfo(listPersonInfoVo);
		pageInfo.setTotal(psmPersonInfoPage.getTotal());
		return ResultVo.ok(pageInfo);
	}

	@Override
	public ResultVo importantCare(PersonInfoVo personInfoVo) {
		personInfoVo.setCareStatus("YES");
		psmPersonInfoMapper.updateByPrimaryKeySelective(personInfoVo);
		return ResultVo.ok();
	}

	@Override
	public ResultVo imageAcquisition(PersonInfoVo personInfoVo) {
		psmPersonInfoMapper.updateByPrimaryKeySelective(personInfoVo);
		return ResultVo.ok();
	}

	@Override
	public ResultVo list() {
		PsmPersonInfoExample example = new PsmPersonInfoExample();
		PsmPersonInfoExample.Criteria criteria = example.createCriteria();
		return ResultVo.ok(psmPersonInfoMapper.selectByExample(example));
	}

	@Override
	public PsmPersonInfo getPsmPersonInfo(String id) {
		return psmPersonInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public String getPsmPersonInfoName(String id) {
		PsmPersonInfo psmPersonInfo = getPsmPersonInfo(id);
		if (psmPersonInfo != null) {
			return psmPersonInfo.getName();
		}

		return "";
	}

}
