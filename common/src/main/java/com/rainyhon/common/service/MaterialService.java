package com.rainyhon.common.service;

import com.microcore.center.model.Face;
import com.microcore.center.model.PsmMaterial;

import java.util.List;

public interface MaterialService {

	void addMaterial(String id, String imageName);

	void addFace(Face face);

	void addFaceList(List<Face> faceList);

	void addMaterial(PsmMaterial material);

	PsmMaterial getMaterial(String id);

}
