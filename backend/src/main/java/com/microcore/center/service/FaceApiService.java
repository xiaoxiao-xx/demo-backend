package com.microcore.center.service;

import com.microcore.center.vo.FaceSdkUserVo;

public interface FaceApiService {

	void addGroup(String groupId);

	void delGroup(String groupId);

	void addUser(FaceSdkUserVo vo);

	void updateUser(FaceSdkUserVo faceSdkUserVo);

	void deleteUser(FaceSdkUserVo faceSdkUserVo);

	void deleteUserFace(FaceSdkUserVo faceSdkUserVo);

}
