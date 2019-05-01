package com.rainyhon.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.center.mapper.PsmPersonInfoMapper;
import com.microcore.center.model.PsmPersonInfo;
import com.microcore.center.model.PsmPersonInfoExample;
import com.rainyhon.common.cllient.HttpTemplate;
import com.rainyhon.common.constant.Constants;
import com.rainyhon.common.service.*;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.JedisPoolUtil;
import com.rainyhon.common.util.StringUtil;
import com.rainyhon.common.vo.FaceSdkUserVo;
import com.rainyhon.common.vo.PersonInfoVo;
import com.rainyhon.common.vo.ResultVo;
import com.rainyhon.common.vo.SearchVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.rainyhon.common.util.CommonUtil.image2byte;

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

	@Autowired
	private JedisPoolUtil redisUtil;

	@Value("${face.api.ip}")
	private String faceApiIp;

	@Value("${face.api.port}")
	private String faceApiPort;

	@Value("${sls.FILE_PATH}")
	private String filePath;

	@Override
	public ResultVo add(PersonInfoVo personInfoVo) {
		String userId = CommonUtil.getUUID();

		personInfoVo.setPersonId(userId);
		psmPersonInfoMapper.insertSelective(personInfoVo);

		operHisService.add(personInfoVo.getPersonId(), Constants.OPER_HIS_ADD);

		byte[] image = image2byte(filePath + "/" + personInfoVo.getPersonalPhoto1().replace("/static/", ""));
		String imageString = CommonUtil.byte2Base64Str(image);

		FaceSdkUserVo faceSdkUserVo = new FaceSdkUserVo();
		faceSdkUserVo.setGroup_id("g1");
		faceSdkUserVo.setUser_id(userId);
		faceSdkUserVo.setSeiralNo("uAdd-" + getSerialNumber());
		faceSdkUserVo.setImage(imageString);
		faceApiService.addUser(faceSdkUserVo);

		return ResultVo.ok();
	}

	private final ThreadLocal<SimpleDateFormat> df = ThreadLocal.withInitial(()
			-> new SimpleDateFormat("yyyyMMddHHmmss"));

	private String getSerialNumber() {
		long ctm = System.currentTimeMillis();
		return df.get().format(new Date(ctm)) + "-" + ctm % 1000;
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

		byte[] image = image2byte(filePath + "/" + personInfoVo.getPersonalPhoto1().replace("/static/", ""));
		String imageString = CommonUtil.byte2Base64Str(image);

		String userId = personInfoVo.getPersonId();
		FaceSdkUserVo faceSdkUserVo = new FaceSdkUserVo();
		faceSdkUserVo.setGroup_id("g1");
		faceSdkUserVo.setUser_id(userId);
		faceSdkUserVo.setSeiralNo("uUpd-" + getSerialNumber());
		faceSdkUserVo.setImage(imageString);
		faceApiService.updateUser(faceSdkUserVo);

		operHisService.add(personInfoVo.getPersonId(), Constants.OPER_HIS_UPD);

		return ResultVo.ok();
	}

	@Override
	public ResultVo delete(String id) {
		String[] ids = id.split(",");
		for (String i : ids) {
			psmPersonInfoMapper.deleteByPrimaryKey(i);

			FaceSdkUserVo faceSdkUserVo = new FaceSdkUserVo();
			faceSdkUserVo.setGroup_id("g1");
			faceSdkUserVo.setUser_id(i);
			faceSdkUserVo.setSeiralNo("uDel-" + getSerialNumber());
			faceApiService.deleteUser(faceSdkUserVo);

			operHisService.add(i, Constants.OPER_HIS_DEL);
		}

		return ResultVo.ok();
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
		// TODO 没有del_status字段
		return ResultVo.ok(psmPersonInfoMapper.selectByExample(example));
	}

	@Override
	public List<PsmPersonInfo> getPersonInfoList(String orgId) {
		PsmPersonInfoExample example = new PsmPersonInfoExample();
		PsmPersonInfoExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(orgId)) {
			criteria.andDeptIdEqualTo(orgId);
		}
		// TODO 没有del_status字段
		return psmPersonInfoMapper.selectByExample(example);
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

	private final ThreadLocal<SimpleDateFormat> dateFormat = ThreadLocal.withInitial(()
			-> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS"));

	@Override
	public ResultVo getPersonInfoByName(SearchVo searchVo) {
		PsmPersonInfoExample example = new PsmPersonInfoExample();
		PsmPersonInfoExample.Criteria criteria = example.createCriteria();
		String name = searchVo.getName();
		if (StringUtils.isNotBlank(name)) {
			criteria.andNameEqualTo(name.trim());
		} else {
			return ResultVo.fail("输入不可为空");
		}

		List<PsmPersonInfo> psmPersonInfoList = psmPersonInfoMapper.selectByExample(example);
		if (CommonUtil.isNotEmpty(psmPersonInfoList)) {
			PsmPersonInfo info = psmPersonInfoList.get(0);
			PersonInfoVo vo = CommonUtil.po2VO(info, PersonInfoVo.class);

			String key = "user:" + info.getPersonId();
			List<String> map = redisUtil.hmget(key, "captureTime", "areaId");
			String captureTime = map.get(0);
			String areaId = map.get(1);
			if (captureTime == null || areaId == null) {
				vo.setAreaId("");
				vo.setOnDuty(false);
				return ResultVo.ok(vo);
			}

			Calendar nineClock = getNineClock();
			try {
				if (dateFormat.get().parse(captureTime).getTime() > nineClock.getTime().getTime()) {
					vo.setAreaId(areaId);
					vo.setOnDuty(true);
				} else {
					vo.setAreaId("");
					vo.setOnDuty(false);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}

			return ResultVo.ok(vo);
		} else {
			return ResultVo.fail("没有搜索到此人");
		}
	}

	@Override
	public int getPersonCount() {
		Map<String, Object> params = new HashMap<>(3);
		String sql = "from psm_person_info_t";
		params.put("sql", sql);
		Long count = commonService.executeGetCount(params);
		return count.intValue();
	}

	@Override
	public int getImportantCarePersonCount() {
		Map<String, Object> params = new HashMap<>(3);
		String sql = "from psm_person_info_t where impt_care_status = 'Y'";
		params.put("sql", sql);
		Long count = commonService.executeGetCount(params);
		return count.intValue();
	}

	private Calendar getNineClock() {
		Calendar nineClock = Calendar.getInstance();
		nineClock.set(Calendar.HOUR_OF_DAY, 9);
		nineClock.set(Calendar.MINUTE, 0);
		nineClock.set(Calendar.SECOND, 0);
		nineClock.set(Calendar.MILLISECOND, 0);

		return nineClock;
	}

}
