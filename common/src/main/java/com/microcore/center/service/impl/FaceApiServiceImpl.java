package com.microcore.center.service.impl;

import com.microcore.center.cllient.HttpTemplate;
import com.microcore.center.service.FaceApiService;
import com.microcore.center.vo.FaceSdkGroupVo;
import com.microcore.center.vo.FaceSdkUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class FaceApiServiceImpl implements FaceApiService {

	private final HttpTemplate httpTemplate;

	@Value("${face.api.ip}")
	private String faceApiIp;

	@Value("${face.api.port}")
	private String faceApiPort;

	@Autowired
	public FaceApiServiceImpl(HttpTemplate httpTemplate) {
		this.httpTemplate = httpTemplate;
	}

	// @Value("${user.face.image.directory}")
	// private String userFaceImageDirectory;

	@Override
	public void addGroup(String groupId) {
		FaceSdkGroupVo faceSdkGroupVo = new FaceSdkGroupVo();
		faceSdkGroupVo.setGroup_id(groupId);
		String ret = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v1/add_group", faceSdkGroupVo, String.class);
		log.info("addGroup ret={}", ret);
	}

	@Override
	public void delGroup(String groupId) {
		FaceSdkGroupVo faceSdkGroupVo = new FaceSdkGroupVo();
		faceSdkGroupVo.setGroup_id(groupId);
		String ret = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v1/delete_group", faceSdkGroupVo, String.class);
		log.info("delGroup ret={}", ret);
	}

	@Override
	public void addUser(FaceSdkUserVo faceSdkUserVo) {
		String userId = faceSdkUserVo.getUser_id();
		log.info("addUser userId={}", userId);

		String ret = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v1/user_add", faceSdkUserVo, String.class);
		log.info("addUser ret={}", ret);
	}

	@Override
	public void updateUser(FaceSdkUserVo faceSdkUserVo) {
		String userId = faceSdkUserVo.getUser_id();
		log.info("updateUser userId={}", userId);

		String ret = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v1/user_update", faceSdkUserVo, String.class);
		log.info("updateUser ret={}", ret);
	}

	@Override
	public void deleteUser(FaceSdkUserVo faceSdkUserVo) {
		String userId = faceSdkUserVo.getUser_id();
		log.info("deleteUser userId={}", userId);

		String ret = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v1/user_delete", faceSdkUserVo, String.class);
		log.info("userDel ret={}", ret);
	}

	@Override
	public void deleteUserFace(FaceSdkUserVo faceSdkUserVo) {
		String ret = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v1/user_face_delete", faceSdkUserVo, String.class);
		log.info("deleteUserFace ret={}", ret);
	}

}
