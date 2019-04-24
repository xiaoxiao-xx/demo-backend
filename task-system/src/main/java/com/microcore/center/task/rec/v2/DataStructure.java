package com.microcore.center.task.rec.v2;

import lombok.Data;

import java.util.List;

/**
 *
 */
@Data
public class DataStructure {

	@Data
	static class DetectResult2 {

		private String errno;

		private String msg;

		private ResData data;

	}

	@Data
	static class ResData {

		private String face_token;

		private String log_id;

		private Integer result_num;

		private List<FaceInfo> result;

	}

	@Data
	public static class DetectResult {

		private String seiralNo;

		private String errno;

		private List<FaceInfo> faces;

	}

	@Data
	public static class FaceInfo {
		private Integer angle;
		private Integer center_x;
		private Integer center_y;
		private String group_id;
		private Integer height;
		private String score;
		private String user_id;
		private Integer width;
		private String base64;
	}

}

