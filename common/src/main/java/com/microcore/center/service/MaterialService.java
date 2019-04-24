package com.microcore.center.service;

import com.microcore.center.model.Face;

import java.util.List;

public interface MaterialService {

	void addMaterial(String id, String imageName);

	void addFace(Face face);

	void addFaceList(List<Face> faceList);

}
