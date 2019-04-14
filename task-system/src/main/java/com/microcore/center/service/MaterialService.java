package com.microcore.center.service;

import com.microcore.center.model.PsmFace;
import com.microcore.center.model.PsmMaterial;

import java.util.List;

public interface MaterialService {

	void addMaterial(String id, String imageName);

	void addMaterial(PsmMaterial material);

	void addFace(PsmFace face);

	void addFaceList(List<PsmFace> faceList);

	PsmMaterial getMaterial(String id);

}
