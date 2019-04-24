package com.rainyhon.task.service;

import com.microcore.center.model.Face;
import com.microcore.center.model.PsmMaterial;

import java.util.List;

public interface MaterialService {

	void addMaterial(String id, String imageName);

	void addMaterial(PsmMaterial material);

	void addFace(Face face);

	void addFaceList(List<Face> faceList);

	PsmMaterial getMaterial(String id);

}
