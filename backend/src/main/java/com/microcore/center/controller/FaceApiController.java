package com.microcore.center.controller;

import com.microcore.center.service.FaceApiService;
import com.microcore.center.vo.FaceSdkUserVo;
import com.microcore.center.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("faceApi")
public class FaceApiController {

	private final FaceApiService faceApiService;

	@Autowired
	public FaceApiController(FaceApiService personService) {
		this.faceApiService = personService;
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

}
