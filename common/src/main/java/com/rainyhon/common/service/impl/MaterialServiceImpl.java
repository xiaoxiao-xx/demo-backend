package com.rainyhon.common.service.impl;

import com.microcore.center.mapper.FaceMapper;
import com.microcore.center.mapper.PsmMaterialMapper;
import com.microcore.center.model.Face;
import com.microcore.center.model.PsmMaterial;
import com.rainyhon.common.service.MaterialService;
import com.rainyhon.common.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	private PsmMaterialMapper materialMapper;

	@Autowired
	private FaceMapper faceMapper;

	@Override
	public void addMaterial(String id, String imageName) {
		PsmMaterial material = new PsmMaterial();
		material.setId(id);
		material.setCreateTime(CommonUtil.getCurrentTime());
		material.setImageName(imageName);
		materialMapper.insert(material);
	}

	@Override
	public void addMaterial(PsmMaterial material) {
		materialMapper.insert(material);
	}

	@Override
	public void addFace(Face face) {
		faceMapper.insert(face);
	}

	@Override
	public void addFaceList(List<Face> faceList) {
		faceList.forEach(faceMapper::insert);
	}

	@Override
	public PsmMaterial getMaterial(String id) {
		return materialMapper.selectByPrimaryKey(id);
	}

}
