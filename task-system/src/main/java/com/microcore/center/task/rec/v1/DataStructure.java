package com.microcore.center.task.rec.v1;

import lombok.Data;

import java.util.List;

/**
 *
 */
@Data
class DataStructure {

	@Data
	static class DetectResult {

		private String seiralNo;

		private String errno;

		private List<FaceInfo> faces;

	}

	@Data
	static class FaceInfo {
		private Integer angle;
		private Integer center_x;
		private Integer center_y;
		private String group_id;
		private Integer height;
		private String score;
		private String user_id;
		private Integer width;
	}

}
