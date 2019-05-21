package com.rainyhon.common.service;

import com.rainyhon.common.cllient.HttpTemplate;
import com.rainyhon.common.exception.CommonException;
import com.rainyhon.common.vo.FaceSdkGroupVo;
import com.rainyhon.common.vo.FaceSdkUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
@Async
public class FaceApiService {

	@Autowired
	private HttpTemplate httpTemplate;

	@Value("${face.api.ip}")
	private String faceApiIp;

	@Value("${face.api.port}")
	private String faceApiPort;

	// @Value("${user.face.image.directory}")
	// private String userFaceImageDirectory;

	public void addGroup(String groupId) {
		FaceSdkGroupVo faceSdkGroupVo = new FaceSdkGroupVo();
		faceSdkGroupVo.setGroup_id(groupId);
		String ret = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v2/add_group", faceSdkGroupVo, String.class);
		log.info("addGroup ret={}", ret);
	}

	public void delGroup(String groupId) {
		FaceSdkGroupVo faceSdkGroupVo = new FaceSdkGroupVo();
		faceSdkGroupVo.setGroup_id(groupId);
		String ret = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v2/delete_group", faceSdkGroupVo, String.class);
		log.info("delGroup ret={}", ret);
	}

	public void addUser(FaceSdkUserVo faceSdkUserVo) {
		String userId = faceSdkUserVo.getUser_id();
		log.info("addUser userId={}", userId);

		String ret = "";
		try {
			ret = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v2/user_add", faceSdkUserVo, String.class);
		} catch (Exception e) {
			log.error("", e);
			throw new CommonException("增加人脸识别标准照失败");
		}

		log.info("addUser ret={}", ret);
	}

	public void updateUser(FaceSdkUserVo faceSdkUserVo) {
		String userId = faceSdkUserVo.getUser_id();
		log.info("updateUser userId={}", userId);

		String ret = "";
		try {
			ret = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v2/user_update", faceSdkUserVo, String.class);
		} catch (Exception e) {
			log.error("", e);
			throw new CommonException("更新人脸识别标准照失败");
		}
		log.info("updateUser ret={}", ret);
	}

	public void deleteUser(FaceSdkUserVo faceSdkUserVo) {
		String userId = faceSdkUserVo.getUser_id();
		log.info("deleteUser userId={}", userId);

		String ret = "";
		try {
			ret = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v2/user_delete", faceSdkUserVo, String.class);
		} catch (Exception e) {
			log.error("", e);
			throw new CommonException("删除人脸识别标准照失败");
		}

		log.info("faceApi userDel ret={}", ret);
	}

	public void deleteUserFace(FaceSdkUserVo faceSdkUserVo) {
		String ret = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v2/user_face_delete", faceSdkUserVo, String.class);
		log.info("deleteUserFace ret={}", ret);
	}

}


