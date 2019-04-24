package com.rainyhon.backend.controller;

import com.microcore.center.cllient.HttpTemplate;
import com.microcore.center.service.FaceApiService;
import com.microcore.center.vo.FaceSdkGroupVo;
import com.microcore.center.vo.FaceSdkUserVo;
import com.microcore.center.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.microcore.center.util.CommonUtil.byte2Base64Str;
import static com.microcore.center.util.CommonUtil.image2byte;

@RestController
@RequestMapping("faceApi")
@Slf4j
public class FaceApiController {

	private final FaceApiService faceApiService;

	private final HttpTemplate httpTemplate;

	@Value("${face.api.ip}")
	private String faceApiIp;

	@Value("${face.api.port}")
	private String faceApiPort;

	@Autowired
	public FaceApiController(FaceApiService personService, HttpTemplate httpTemplate) {
		this.faceApiService = personService;
		this.httpTemplate = httpTemplate;
	}

	public ResultVo addGroup(String groupId) {
		faceApiService.addGroup(groupId);
		return ResultVo.ok();
	}

	public ResultVo delGroup(String groupId) {
		faceApiService.delGroup(groupId);
		return ResultVo.ok();
	}

	public ResultVo addUser(FaceSdkUserVo vo) {
		faceApiService.addUser(vo);
		return ResultVo.ok();
	}

	public ResultVo updateUser(FaceSdkUserVo faceSdkUserVo) {
		faceApiService.updateUser(faceSdkUserVo);
		return ResultVo.ok();
	}

	public ResultVo deleteUser(FaceSdkUserVo faceSdkUserVo) {
		faceApiService.deleteUser(faceSdkUserVo);
		return ResultVo.ok();
	}

	public ResultVo deleteUsrFace(FaceSdkUserVo faceSdkUserVo) {
		faceApiService.deleteUserFace(faceSdkUserVo);
		return ResultVo.ok();
	}

	// @Scheduled(fixedRate = 1000)
	// @PostConstruct
	private void addGroup() {
		FaceSdkGroupVo faceSdkGroupVo = new FaceSdkGroupVo();
		faceSdkGroupVo.setGroup_id("g1");
		String ret = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v1/add_group", faceSdkGroupVo, String.class);
		log.info(">>>addGroup ret=" + ret);
	}

	// @Scheduled(fixedRate = 1000)
	// @PostConstruct
	private void delGroup() {
		FaceSdkGroupVo faceSdkGroupVo = new FaceSdkGroupVo();
		faceSdkGroupVo.setGroup_id("g1");
		String ret = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v1/delete_group", faceSdkGroupVo, String.class);
		log.info(">>>delGroup ret=" + ret);

		addGroup();
	}

	// @Scheduled(fixedRate = 10000)
	// @PostConstruct
	private void updateUser() {
		FaceSdkUserVo faceSdkUserVo = new FaceSdkUserVo();
		faceSdkUserVo.setGroup_id("test_group");
		faceSdkUserVo.setUser_id("u9");

		for (int i = 18; i < 23; i++) {
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			Long ctm = System.currentTimeMillis();
			String seiralNo = df.format(new Date(ctm)) + "-" + ctm % 1000;
			faceSdkUserVo.setSeiralNo("uUpd-" + seiralNo);

			// byte[] data = image2byte(userFaceImageDirectory + userId + ".bmp");
			// faceSdkUserVo.setImage(byte2Base64Str(data));

			byte[] data = image2byte("D://imgu/u" + i + ".bmp");
			faceSdkUserVo.setImage(byte2Base64Str(data));

			String ret = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v1/user_update", faceSdkUserVo, String.class);
			log.info(">>> updateUser ret=" + ret);
		}
	}

	// @Scheduled(fixedRate = 1000)
	private void deleteUserFace() {
		FaceSdkUserVo faceSdkUserVo = new FaceSdkUserVo();
		faceSdkUserVo.setGroup_id("g1");
		faceSdkUserVo.setUser_id("u1");
		faceSdkUserVo.setFace_token("a2a35f443b232d4d3dcce9a306ffd086");

		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		Long ctm = System.currentTimeMillis();
		String seiralNo = df.format(new Date(ctm)) + "-" + ctm % 1000;
		faceSdkUserVo.setSeiralNo("fDel-" + seiralNo);

		String ret = httpTemplate.post("192.168.254.22", "3000", "/face/api/v1/user_face_delete", faceSdkUserVo, String.class);
		log.info(">>>deleteUserFace ret=" + ret);
	}

	// @Scheduled(fixedRate = 3000)
	private void deleteUser() {
		FaceSdkUserVo faceSdkUserVo = new FaceSdkUserVo();
		faceSdkUserVo.setGroup_id("test_group");
		for (int i = 0; i < 17; i++) {
			faceSdkUserVo.setUser_id("u" + i);
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			Long ctm = System.currentTimeMillis();
			String seiralNo = df.format(new Date(ctm)) + "-" + ctm % 1000;
			faceSdkUserVo.setSeiralNo("uDel-" + seiralNo);

			String ret = httpTemplate.post("192.168.254.22", "3000", "/face/api/v1/user_delete", faceSdkUserVo, String.class);
			log.info(">>>userDel ret=" + ret);
		}
	}

	// @Scheduled(fixedRate = 5000)
	// @PostConstruct
	private void addUser() {
		FaceSdkUserVo faceSdkUserVo = new FaceSdkUserVo();
		faceSdkUserVo.setGroup_id("g1");

		for (int i = 23; i < 24; i++) {
			faceSdkUserVo.setUser_id("u" + i);
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			Long ctm = System.currentTimeMillis();
			String seiralNo = df.format(new Date(ctm)) + "-" + ctm % 1000;
			faceSdkUserVo.setSeiralNo("uAdd-" + seiralNo);
			log.info(">>>addUser u=" + "u" + i);
			byte[] data = image2byte("D://imgu/u" + i + ".bmp");
			faceSdkUserVo.setImage(byte2Base64Str(data));

			String ret = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v1/user_add", faceSdkUserVo, String.class);

			log.info(">>>addUser ret=" + ret);
		}
	}

}
