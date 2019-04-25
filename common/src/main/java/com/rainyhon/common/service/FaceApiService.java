package com.rainyhon.common.service;

import com.rainyhon.common.vo.FaceSdkUserVo;

public interface FaceApiService {

	void addGroup(String groupId);

	void delGroup(String groupId);

	void addUser(FaceSdkUserVo vo);

	void updateUser(FaceSdkUserVo faceSdkUserVo);

	void deleteUser(FaceSdkUserVo faceSdkUserVo);

	void deleteUserFace(FaceSdkUserVo faceSdkUserVo);

}
