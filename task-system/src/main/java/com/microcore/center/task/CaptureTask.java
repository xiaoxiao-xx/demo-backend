package com.microcore.center.task;

import com.microcore.center.cllient.HttpTemplate;
import com.microcore.center.hcnetsdk.HCNetSDK;
import com.microcore.center.model.PsmFace;
import com.microcore.center.model.PsmMaterial;
import com.microcore.center.service.MaterialService;
import com.microcore.center.service.SdkService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.util.Encode;
import com.microcore.center.vo.FaceSdkGroupVo;
import com.microcore.center.vo.FaceSdkRecVo;
import com.microcore.center.vo.FaceSdkUserVo;
import com.sun.jna.NativeLong;
import com.sun.jna.ptr.IntByReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.imageio.stream.FileImageInputStream;
import java.io.*;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 定时截图工具类
 */
@Slf4j
@Component
public class CaptureTask {

	@Autowired
	private SdkService sdkService;

	@Autowired
	private HttpTemplate httpTemplate;

	@Value("${face.api.ip}")
	private String faceApiIp;

	@Value("${face.api.port}")
	private String faceApiPort;

	/**
	 * 200ms心跳一次
	 */
	@Scheduled(fixedRate = 500)
	private void captureTask() {
//		NativeLong channel = new NativeLong(2);

		//调用SDK图片大小和质量参数
		HCNetSDK.NET_DVR_JPEGPARA lpJpegPara = new HCNetSDK.NET_DVR_JPEGPARA();
		lpJpegPara.wPicSize = 5;
		lpJpegPara.wPicQuality = 2;

		//申请内存大小
		ByteBuffer jpegBuffer = ByteBuffer.allocate(1024 * 1024);
		IntByReference retLen = new IntByReference();

		NativeLong lUserId = sdkService.getUserId();

		//封装请求Json
		FaceSdkRecVo faceSdkRecVo = new FaceSdkRecVo();
		faceSdkRecVo.setGroup_id("g1");

		//需要设备ID 如摄像头
		faceSdkRecVo.setDevice_id("001");

		//获得seiralNo
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		long ctm = System.currentTimeMillis();
		String seiralNo = df.format(new Date(ctm)) + "-" + ctm % 1000;
		faceSdkRecVo.setSeiralNo(seiralNo);

		boolean result = sdkService.captureJpegPicture(lUserId, new NativeLong(1L), lpJpegPara,
				jpegBuffer, 1024 * 1024, retLen);

		log.info("---> retLen:  {}", retLen.getValue());

		try {
			OutputStream os = new FileOutputStream("D:/img/" + System.currentTimeMillis() + ".jpeg");

			log.info("-------- position = {}", jpegBuffer.position());
			os.write(jpegBuffer.array(), 0, retLen.getValue());
			log.info("-------- position = {}", jpegBuffer.position());

			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 存素材元信息

		if (result) {
//			faceSdkRecVo.setImage(Encode.byte2Base64Str(jpegBuffer.array()));

			byte[] temp = new byte[retLen.getValue()];
			log.info("-------- position  bw= {}", jpegBuffer.position());
			jpegBuffer.rewind();
			log.info("-------- position  aw= {}", jpegBuffer.position());
			jpegBuffer.get(temp, 0, retLen.getValue());
			log.info("-------- position  aw2= {}", jpegBuffer.position());
			String image = Encode.byte2Base64Str(temp);
			faceSdkRecVo.setImage(image);

			log.info("-------- size = {}", faceSdkRecVo.getImage().getBytes().length);

			// String ret = httpTemplate.post("192.168.254.22", "8080", "/face/api/v1/detect", faceSdkRecVo, String.class);
			String ret = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v1/detect", faceSdkRecVo, String.class);
			log.info("face.ip: {}, face.port: {}", faceApiIp, faceApiPort);

			// 存图像识别结果

			log.info(">>>ret=" + ret);
			log.info("cost time:" + (System.currentTimeMillis() - ctm));
		} else {
			sdkService.errMsg();
		}
	}

	@Autowired
	private MaterialService materialService;

	@Autowired
	private AsyncTask asyncTask;

	// OK
	@Scheduled(fixedRate = 200)
	private void captureTaskimg() {
		boolean captureTaskFlag = false;
		// boolean captureTaskFlag = true;
		if (captureTaskFlag) {
			return;
		}

		//封装请求Json
		FaceSdkRecVo faceSdkRecVo = new FaceSdkRecVo();
		faceSdkRecVo.setGroup_id("g1");
		//获得seiralNo
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		long ctm = System.currentTimeMillis();
		String seiralNo = df.format(new Date(ctm)) + "-" + ctm % 1000;
		faceSdkRecVo.setSeiralNo(seiralNo);

		// 保存素材信息
		String uuid = CommonUtil.getUUID();
		String imageName = "input.jpeg";

		PsmMaterial material = new PsmMaterial();
		material.setId(uuid);
		material.setCreateTime(CommonUtil.getCurrentTime());
		material.setImageName(imageName);
		material.setDeviceId(CommonUtil.random("dev1", "dev2", "dev3"));
		material.setAreaId(CommonUtil.random("1", "2", "3", "4", "5"));
		materialService.addMaterial(material);

		byte[] data = image2byte("D://imga/input.jpeg");
		log.info("data.len=" + data.length);

		faceSdkRecVo.setImage(Encode.byte2Base64Str(data));
		log.info("-------- size = {}", faceSdkRecVo.getImage().getBytes().length);

		asyncTask.detect(uuid, faceSdkRecVo);
	}

	// @Scheduled(fixedRate = 200)
	private void captureTaskimgRec() {
		//封装请求Json
		FaceSdkRecVo faceSdkRecVo = new FaceSdkRecVo();
		faceSdkRecVo.setGroup_id("g1");
		//获得seiralNo
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		Long ctm = System.currentTimeMillis();
		String seiralNo = df.format(new Date(ctm)) + "-" + ctm % 1000;
		faceSdkRecVo.setSeiralNo(seiralNo);
		faceSdkRecVo.setDevice_id("001");

		byte[] data = image2byte("D://img/input.jpeg");
		log.info("data.len=" + data.length);

		faceSdkRecVo.setImage(Encode.byte2Base64Str(data));
		String ret = httpTemplate.post("127.0.0.1", "3000", "/face/api/v1/rec", faceSdkRecVo, String.class);
		log.info(">>>rec cost" + (System.currentTimeMillis() - ctm) + " and ret=" + ret);
	}

	public static List<PsmFace> convertFaces(String materialId, List<FaceInfo> faceInfoList) {
		return faceInfoList.stream().map(faceInfo -> {
			PsmFace face = new PsmFace();

			face.setId(CommonUtil.getUUID());
			face.setMaterialId(materialId);
			face.setCreateTime(CommonUtil.getCurrentTime());

			face.setAngle(faceInfo.angle);
			face.setCenterX(faceInfo.getCenter_x());
			face.setCenterY(faceInfo.getCenter_y());
			face.setGroupId(faceInfo.getGroup_id());
			face.setUserId(faceInfo.getUser_id());
			face.setHeight(faceInfo.getHeight());
			face.setWidth(faceInfo.getWidth());
			face.setScore(faceInfo.getScore());

			return face;
		}).collect(Collectors.toList());
	}

	@Data
	@EqualsAndHashCode(callSuper = false)
	public static class DetectResult {

		private String seiralNo;

		private List<FaceInfo> faces;

	}

	@Data
	@EqualsAndHashCode(callSuper = false)
	public static class FaceInfo {
		private Integer angle;
		private Integer center_x;
		private Integer center_y;
		private String group_id;
		private Integer height;
		private String score;
		private String user_id;
		private Integer width;
	}

	// @Scheduled(fixedRate = 1000)
	private void addGroup() {
		FaceSdkGroupVo faceSdkGroupVo = new FaceSdkGroupVo();
		faceSdkGroupVo.setGroup_id("g1");
		String ret = httpTemplate.post("192.168.254.22", "3000", "/face/api/v1/add_group", faceSdkGroupVo, String.class);
		log.info(">>>addGroup ret=" + ret);
	}

	// @Scheduled(fixedRate = 1000)
	private void delGroup() {
		FaceSdkGroupVo faceSdkGroupVo = new FaceSdkGroupVo();
		faceSdkGroupVo.setGroup_id("g1");
		String ret = httpTemplate.post("192.168.254.22", "3000", "/face/api/v1/delete_group", faceSdkGroupVo, String.class);
		log.info(">>>delGroup ret=" + ret);
	}

	// @Scheduled(fixedRate = 10000)
	private void updateUser() {
		FaceSdkUserVo faceSdkUserVo = new FaceSdkUserVo();
		faceSdkUserVo.setGroup_id("test_group");
		faceSdkUserVo.setUser_id("u9");

		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		Long ctm = System.currentTimeMillis();
		String seiralNo = df.format(new Date(ctm)) + "-" + ctm % 1000;
		faceSdkUserVo.setSeiralNo("uUpd-" + seiralNo);

		byte[] data = image2byte("D://imgu/u9.jpg");
		faceSdkUserVo.setImage(Encode.byte2Base64Str(data));

		String ret = httpTemplate.post("192.168.254.22", "3000", "/face/api/v1/user_update", faceSdkUserVo, String.class);
		log.info(">>>updateUser ret=" + ret);
	}

	// @Scheduled(fixedRate = 1000)
	private void deleteUserFace() {
		FaceSdkUserVo faceSdkUserVo = new FaceSdkUserVo();
		faceSdkUserVo.setGroup_id("g1");
		faceSdkUserVo.setUser_id("u1");
		faceSdkUserVo.setFace_token("a2a35f443b232d4d3dcce9a306ffd086");

		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		Long ctm = System.currentTimeMillis();
		String seiralNo = df.format(new Date(ctm)) + "-" + ctm % 1000;
		faceSdkUserVo.setSeiralNo("fDel-" + seiralNo);

		String ret = httpTemplate.post("192.168.254.22", "3000", "/face/api/v1/user_face_delete", faceSdkUserVo, String.class);
		log.info(">>>deleteUserFace ret=" + ret);
	}

	// @Scheduled(fixedRate = 3000)
	private void deleteUser() {
		FaceSdkUserVo faceSdkUserVo = new FaceSdkUserVo();
		faceSdkUserVo.setGroup_id("test_group");
		for (int i = 0; i < 17; i++) {
			faceSdkUserVo.setUser_id("u" + i);
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			Long ctm = System.currentTimeMillis();
			String seiralNo = df.format(new Date(ctm)) + "-" + ctm % 1000;
			faceSdkUserVo.setSeiralNo("uDel-" + seiralNo);

			String ret = httpTemplate.post("192.168.254.22", "3000", "/face/api/v1/user_delete", faceSdkUserVo, String.class);
			log.info(">>>userDel ret=" + ret);
		}
	}

	//    @Scheduled(fixedRate = 5000)
	private void addUser() {
		FaceSdkUserVo faceSdkUserVo = new FaceSdkUserVo();
		faceSdkUserVo.setGroup_id("g1");

		for (int i = 17; i < 18; i++) {
			faceSdkUserVo.setUser_id("u" + i);
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			Long ctm = System.currentTimeMillis();
			String seiralNo = df.format(new Date(ctm)) + "-" + ctm % 1000;
			faceSdkUserVo.setSeiralNo("uAdd-" + seiralNo);
			log.info(">>>addUser u=" + "u" + i);
			byte[] data = image2byte("D://imgu/u" + i + ".bmp");
			faceSdkUserVo.setImage(Encode.byte2Base64Str(data));

			String ret = httpTemplate.post("192.168.254.22", "3000", "/face/api/v1/user_add", faceSdkUserVo, String.class);

			log.info(">>>addUser ret=" + ret);
		}
	}

	//图片转byte数组
	public static byte[] image2byte(String path) {
		byte[] data = null;
		FileImageInputStream input = null;
		try {
			input = new FileImageInputStream(new File(path));
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int numBytesRead = 0;
			while ((numBytesRead = input.read(buf)) != -1) {
				output.write(buf, 0, numBytesRead);
			}
			data = output.toByteArray();
			output.close();
			input.close();
		} catch (FileNotFoundException ex1) {
			ex1.printStackTrace();
		} catch (IOException ex1) {
			ex1.printStackTrace();
		}
		return data;
	}

}
