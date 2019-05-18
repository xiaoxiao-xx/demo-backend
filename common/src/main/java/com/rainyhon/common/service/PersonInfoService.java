package com.rainyhon.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rainyhon.common.constant.AreaDef;
import com.rainyhon.common.constant.Constants;
import com.rainyhon.common.exception.CommonException;
import com.rainyhon.common.mapper.PersonInfoMapper;
import com.rainyhon.common.model.PersonInfo;
import com.rainyhon.common.model.PersonInfoExample;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.EntityUtils;
import com.rainyhon.common.util.JedisPoolUtil;
import com.rainyhon.common.util.StringUtil;
import com.rainyhon.common.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.rainyhon.common.util.CommonUtil.image2byte;
import static com.rainyhon.common.util.CommonUtil.listPo2VO;
import static java.util.stream.Collectors.toList;

@Service
@Transactional
@Slf4j
public class PersonInfoService {

	private final ThreadLocal<SimpleDateFormat> df = ThreadLocal.withInitial(()
			-> new SimpleDateFormat("yyyyMMddHHmmss"));

	private final ThreadLocal<SimpleDateFormat> dateFormat = ThreadLocal.withInitial(()
			-> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS"));

	@Autowired
	private PersonInfoMapper personInfoMapper;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private OperHisService operHisService;

	@Autowired
	private CommonService commonService;

	@Autowired
	private FaceApiService faceApiService;

	@Autowired
	private OrgService orgService;

	@Autowired
	private JedisPoolUtil redisUtil;

	@Autowired
	private KeyPersonService keyPersonService;

	@Value("${face.api.ip}")
	private String faceApiIp;

	@Value("${face.api.port}")
	private String faceApiPort;

	@Value("${sls.FILE_PATH}")
	private String faceImageDirPath;

	public ResultVo add(PersonInfoVo personInfoVo) {
		String userId = CommonUtil.getUUID();

		personInfoVo.setId(userId);
		EntityUtils.setCreateAndUpdateInfo(personInfoVo);
		personInfoMapper.insertSelective(personInfoVo);

		operHisService.add(personInfoVo.getId(), Constants.OPER_HIS_ADD);

		byte[] image = image2byte(faceImageDirPath + "/" + personInfoVo.getPhoto());
		String imageString = CommonUtil.byte2Base64Str(image);

		FaceSdkUserVo faceSdkUserVo = new FaceSdkUserVo();
		faceSdkUserVo.setGroup_id("g1");
		faceSdkUserVo.setUser_id(userId);
		faceSdkUserVo.setSeiralNo("uAdd-" + getSerialNumber());
		faceSdkUserVo.setImage(imageString);
		faceApiService.addUser(faceSdkUserVo);

		return ResultVo.ok();
	}

	private String getSerialNumber() {
		long ctm = System.currentTimeMillis();
		return df.get().format(new Date(ctm)) + "-" + ctm % 1000;
	}

	public PersonInfo getRandomPerson() {
		Map<String, Object> params = new HashMap<>();
		params.put("sql", "SELECT * FROM person_info ORDER BY RAND() LIMIT 1");
		Map<String, Object> record = commonService.findOne(params);
		return CommonUtil.map2PO(record, PersonInfo.class);
	}

	public ResultVo update(PersonInfoVo personInfoVo) {
		// 和重点关注人员服务有关联，刷新重点关注人员表的数据
		keyPersonService.refresh(personInfoVo.getId(), personInfoVo.getImptCareStatus());

		EntityUtils.setUpdateInfo(personInfoVo);
		personInfoMapper.updateByPrimaryKeySelective(personInfoVo);

		byte[] image = image2byte(faceImageDirPath + "/" + personInfoVo.getPhoto());
		String imageString = CommonUtil.byte2Base64Str(image);

		String personId = personInfoVo.getId();
		FaceSdkUserVo faceSdkUserVo = new FaceSdkUserVo();
		faceSdkUserVo.setGroup_id("g1");
		faceSdkUserVo.setUser_id(personId);
		faceSdkUserVo.setSeiralNo("uUpd-" + getSerialNumber());
		faceSdkUserVo.setImage(imageString);
		faceApiService.updateUser(faceSdkUserVo);

		operHisService.add(personId, Constants.OPER_HIS_UPD);

		return ResultVo.ok();
	}

	public ResultVo delete(PersonDeleteVo vo) {
		List<String> idList = vo.getIdList();
		if (CommonUtil.isEmpty(idList)) {
			return ResultVo.ok();
		}

		for (String id : idList) {
			if (id == null) {
				continue;
			}

			deletePersonInfo(id);

			FaceSdkUserVo faceSdkUserVo = new FaceSdkUserVo();
			faceSdkUserVo.setGroup_id("g1");
			faceSdkUserVo.setUser_id(id);
			faceSdkUserVo.setSeiralNo("uDel-" + getSerialNumber());
			faceApiService.deleteUser(faceSdkUserVo);

			operHisService.add(id, Constants.OPER_HIS_DEL);

			// 删除人员头像目录中保存的照片
			removeFaceImage(id);
		}

		return ResultVo.ok();
	}

	private void deletePersonInfo(String id) {
		PersonInfo personInfo = new PersonInfo();
		personInfo.setId(id);
		personInfo.setDelStatus(Constants.DELETE_STATUS_YES);
		personInfoMapper.updateByPrimaryKeySelective(personInfo);
	}

	private void removeFaceImage(String personId) {
		PersonInfo personInfo = getPersonInfo(personId);
		if (StringUtils.isEmpty(personInfo.getPhoto())) {
			return;
		}

		String path = faceImageDirPath + "/" + personInfo.getPhoto();
		boolean result = deleteFile(path);
		if (!result) {
			throw new CommonException("删除用户照片失败");
		}
	}

	private boolean deleteFile(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return true;
		}
		return file.delete();
	}

	public ResultVo getPersonList(String name, String deptId, Integer pageIndex, Integer pageSize) {
		PersonInfoExample example = new PersonInfoExample();
		PersonInfoExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(Constants.DELETE_STATUS_NO);
		if (StringUtil.isNotEmpty(name)) {
			criteria.andNameLike("%" + name.trim() + "%");
		}

		// 机构是或者不是最基层机构都可以查出所有人员
		if (StringUtils.isNotEmpty(deptId)) {
			List<String> childrenOrgList = orgService.getChildrenOrgList(deptId);
			criteria.andOrgIdIn(childrenOrgList);
		}

		PageInfo<PersonInfo> pageInfo = PageHelper.startPage(pageIndex, pageSize)
				.doSelectPageInfo(() -> personInfoMapper.selectByExample(example));

		List<PersonInfo> personInfoList = pageInfo.getList();
		List<PersonInfoVo> personInfoVoList = listPo2VO(personInfoList, PersonInfoVo.class);

		personInfoVoList.forEach(vo -> {
			String deptName = departmentService.getDepartmentName(vo.getOrgId());
			vo.setDeptName(deptName);

			// 机构的父机构列表
			List<String> parentList = orgService.findAllParents(vo.getOrgId());
			parentList.add(vo.getOrgId());
			vo.setDisplayOrgList(parentList);
		});

		PageInfo<PersonInfoVo> voPageInfo = CommonUtil.po2VO(pageInfo, PageInfo.class);
		voPageInfo.setList(personInfoVoList);
		return ResultVo.ok(voPageInfo);
	}

	public ResultVo importantCare(PersonInfoVo personInfoVo) {
		personInfoVo.setCareStatus("--");
		personInfoMapper.updateByPrimaryKeySelective(personInfoVo);
		return ResultVo.ok();
	}

	public ResultVo imageAcquisition(PersonInfoVo personInfoVo) {
		personInfoMapper.updateByPrimaryKeySelective(personInfoVo);
		return ResultVo.ok();
	}

	public ResultVo list() {
		PersonInfoExample example = new PersonInfoExample();
		PersonInfoExample.Criteria criteria = example.createCriteria();
		criteria.andDelStatusEqualTo(Constants.DELETE_STATUS_NO);
		return ResultVo.ok(personInfoMapper.selectByExample(example));
	}

	public List<PersonInfo> getPersonInfoListByOrgId(String orgId) {
		PersonInfoExample example = new PersonInfoExample();
		PersonInfoExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(orgId)) {
			criteria.andOrgIdEqualTo(orgId);
		}
		criteria.andDelStatusEqualTo(Constants.DELETE_STATUS_NO);
		return personInfoMapper.selectByExample(example);
	}

	public PersonInfo getPersonInfo(String id) {
		return personInfoMapper.selectByPrimaryKey(id);
	}

	public String getPersonInfoName(String id) {
		PersonInfo personInfo = getPersonInfo(id);
		if (personInfo != null) {
			return personInfo.getName();
		}

		return "";
	}

	public ResultVo getPersonInfoByName(SearchVo searchVo) {
		PersonInfoExample example = new PersonInfoExample();
		PersonInfoExample.Criteria criteria = example.createCriteria();
		String name = searchVo.getName();
		if (StringUtils.isNotBlank(name)) {
			criteria.andNameEqualTo(name.trim());
		} else {
			return ResultVo.fail("输入不可为空");
		}

		List<PersonInfo> personInfoList = personInfoMapper.selectByExample(example);
		if (CommonUtil.isNotEmpty(personInfoList)) {
			PersonInfo info = personInfoList.get(0);
			PersonInfoVo vo = CommonUtil.po2VO(info, PersonInfoVo.class);

			String key = "user:" + info.getId();
			List<String> map = redisUtil.hmget(key, "captureTime", "areaId");
			String captureTime = map.get(0);
			String areaId = map.get(1);
			if (captureTime == null || areaId == null) {
				vo.setAreaId("");
				vo.setArea("");
				vo.setOnDuty(false);
				return ResultVo.ok(vo);
			}

			Calendar nineClock = getNineClock();
			try {
				if (dateFormat.get().parse(captureTime).getTime() > nineClock.getTime().getTime()) {
					vo.setAreaId(areaId);
					vo.setArea(AreaDef.getAreaNameById(areaId));
					vo.setOnDuty(true);
				} else {
					vo.setAreaId("");
					vo.setArea("");
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

	public int getPersonCount() {
		Map<String, Object> params = new HashMap<>(3);
		String sql = "from person_info where del_status = 'NO'";
		params.put("sql", sql);
		Long count = commonService.executeGetCount(params);
		return count.intValue();
	}

	public int getPersonCountByOrgId(String orgId) {
		Map<String, Object> params = new HashMap<>(3);
		String sql = "from person_info where org_id = #{orgId} and del_status = 'NO'";
		params.put("sql", sql);
		params.put("orgId", orgId);
		Long count = commonService.executeGetCount(params);
		return count.intValue();
	}

	public int getImportantCarePersonCount() {
		Map<String, Object> params = new HashMap<>(3);
		String sql = "from person_info where impt_care_status = '1' and del_status = 'NO'";
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

	public ResultVo getPersonListByOrgId(String orgId) {
		PersonInfoExample example = new PersonInfoExample();
		PersonInfoExample.Criteria criteria = example.createCriteria();
		criteria.andOrgIdEqualTo(orgId);
		List<PersonInfo> personInfoList = personInfoMapper.selectByExample(example);
		return ResultVo.ok(personInfoList);
	}

	public ResultVo<?> getPersonInfoById(String id) {
		PersonInfo personInfo = getPersonInfo(id);
		if (personInfo == null) {
			throw new CommonException("查找不到该人的信息");
		}

		return ResultVo.ok(personInfo);
	}

	public void setImptCareStatus(String personId, String imptCareStatus) {
		PersonInfo personInfo = new PersonInfo();
		personInfo.setId(personId);
		personInfo.setImptCareStatus(imptCareStatus);
		personInfoMapper.updateByPrimaryKeySelective(personInfo);
	}

	public List<String> getPersonListByLike(String personName) {
		PersonInfoExample example = new PersonInfoExample();
		PersonInfoExample.Criteria criteria = example.createCriteria();
		criteria.andNameLike("%" + personName + "%");
		criteria.andDelStatusEqualTo(Constants.DELETE_STATUS_NO);
		List<PersonInfo> personInfoList = personInfoMapper.selectByExample(example);
		if (CommonUtil.isNotEmpty(personInfoList)) {
			return personInfoList.stream().map(PersonInfo::getId).collect(toList());
		}

		return Collections.singletonList("");
	}

	/**
	 * 根据机构ID查询出该机构所有人的ID的列表
	 */
	public List<String> getPersonListByOrgLike(String orgId) {
		List<String> personList = getPersonInfoListByOrgId(orgId).stream()
				.map(PersonInfo::getId).collect(toList());

		if (CommonUtil.isEmpty(personList)) {
			return Collections.singletonList("");
		}

		return personList;
	}

}

