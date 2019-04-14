package com.microcore.center.service;

import com.microcore.center.model.PsmFace;

import java.util.List;

public interface MaterialService {

	void addMaterial(String id, String imageName);

	void addFace(PsmFace face);

	void addFaceList(List<PsmFace> faceList);

}
