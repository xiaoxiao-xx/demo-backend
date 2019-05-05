package com.rainyhon.common.service;

import com.rainyhon.common.mapper.FaceMapper;
import com.rainyhon.common.mapper.MaterialMapper;
import com.rainyhon.common.model.Face;
import com.rainyhon.common.model.Material;
import com.rainyhon.common.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class MaterialService {

	@Autowired
	private MaterialMapper materialMapper;

	@Autowired
	private FaceMapper faceMapper;

	public void addMaterial(String id, String imageName) {
		Material material = new Material();
		material.setId(id);
		material.setCreateTime(CommonUtil.getCurrentTime());
		material.setImageName(imageName);
		materialMapper.insert(material);
	}

	public void addMaterial(Material material) {
		materialMapper.insert(material);
	}

	public void addFace(Face face) {
		faceMapper.insert(face);
	}

	public void addFaceList(List<Face> faceList) {
		faceList.forEach(faceMapper::insert);
	}

	public Material getMaterial(String id) {
		return materialMapper.selectByPrimaryKey(id);
	}

}

