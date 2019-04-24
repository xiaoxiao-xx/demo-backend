package com.microcore.center.task.rec.v1;

import com.microcore.center.cllient.HttpTemplate;
import com.microcore.center.constant.Constants;
import com.microcore.center.hcnetsdk.HCNetSDK;
import com.microcore.center.model.PsmFace;
import com.microcore.center.model.PsmMaterial;
import com.microcore.center.service.MaterialService;
import com.microcore.center.service.SdkService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.vo.FaceSdkRecVo;
import com.sun.jna.NativeLong;
import com.sun.jna.ptr.IntByReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.microcore.center.util.CommonUtil.*;

/**
 * 定时截图工具类
 */
@Slf4j
@Component
public class CaptureTask {

	private final SdkService sdkService;

	private final HttpTemplate httpTemplate;

	private final MaterialService materialService;

	private final AsyncTask asyncTask;

	private final ThreadLocal<SimpleDateFormat> dateFormat = ThreadLocal.withInitial(()
			-> new SimpleDateFormat("yyyy-MM-dd HH-mm-ss SSS"));

	private final ThreadLocal<SimpleDateFormat> df = ThreadLocal.withInitial(()
			-> new SimpleDateFormat("yyyyMMddHHmmss"));

	@Value("${face.api.ip}")
	private String faceApiIp;

	@Value("${face.api.port}")
	private String faceApiPort;

	@Value("${capture.path}")
	private String captureImagePath;

	@Value("${device.number}")
	private String deviceNumber;

	@Value("${generate.image.file}")
	private String generateImageFile;

	@Autowired
	public CaptureTask(SdkService sdkService, HttpTemplate httpTemplate,
	                   MaterialService materialService, AsyncTask asyncTask) {
		this.sdkService = sdkService;
		this.httpTemplate = httpTemplate;
		this.materialService = materialService;
		this.asyncTask = asyncTask;
	}

	static List<PsmFace> convertFaces(String materialId, List<DataStructure.FaceInfo> faceInfoList) {
		return faceInfoList.stream().map(faceInfo -> {
			PsmFace face = new PsmFace();

			face.setId(CommonUtil.getUUID());
			face.setMaterialId(materialId);
			face.setCreateTime(CommonUtil.getCurrentTime());

			face.setAngle(faceInfo.getAngle());
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

	/**
	 * 200ms心跳一次
	 */
	// @Scheduled(fixedRate = 300)
	private void captureTask() {
		// 调用SDK图片大小和质量参数
		HCNetSDK.NET_DVR_JPEGPARA lpJpegPara = new HCNetSDK.NET_DVR_JPEGPARA();
		lpJpegPara.wPicSize = 5;
		lpJpegPara.wPicQuality = 2;

		// 申请内存大小
		ByteBuffer jpegBuffer = ByteBuffer.allocate(1024 * 1024);

		NativeLong lUserId = sdkService.getUserId();

		// 封装请求Json
		FaceSdkRecVo faceSdkRecVo = new FaceSdkRecVo();
		faceSdkRecVo.setGroup_id("g1");

		// 需要设备ID 如摄像头
		faceSdkRecVo.setDevice_id("001");

		// 获得seiralNo
		String seiralNo = getSerialNumber();
		faceSdkRecVo.setSeiralNo(seiralNo);

		IntByReference retLen = new IntByReference();

		boolean result = sdkService.captureJpegPicture(lUserId, new NativeLong(1L), lpJpegPara,
				jpegBuffer, 1024 * 1024, retLen);

		// log.info("---> retLen:  {}", retLen.getValue());

		// result = true;
		if (result) {
			String now = dateFormat.get().format(new Date());
			String imageName = "" + now + ".jpeg";
			if (Constants.YES.toLowerCase().equals(generateImageFile)) {
				saveImage(imageName, jpegBuffer, retLen);
			}

			byte[] temp = new byte[retLen.getValue()];
			// log.info("-------- position  bw= {}", jpegBuffer.position());
			// jpegBuffer.rewind();
			// log.info("-------- position  aw= {}", jpegBuffer.position());
			jpegBuffer.get(temp, 0, retLen.getValue());
			// log.info("-------- position  aw2= {}", jpegBuffer.position());

			// TODO
			// temp = CommonUtil.image2byte("D:/imga/input5.jpg");

			String image = byte2Base64Str(temp);
			faceSdkRecVo.setImage(image);

			// 保存素材信息
			PsmMaterial material = new PsmMaterial();
			String uuid = CommonUtil.getUUID();
			material.setId(uuid);
			material.setCreateTime(CommonUtil.getCurrentTime());
			material.setImageName(imageName);
			material.setDeviceId(deviceNumber);
			material.setAreaId(deviceNumber);
			materialService.addMaterial(material);

			// log.info("-------- size = {}", faceSdkRecVo.getImage().getBytes().length);
			asyncTask.detect(uuid, faceSdkRecVo);
		} else {
			sdkService.errMsg();
		}
	}

	private String getSerialNumber() {
		long ctm = System.currentTimeMillis();
		return df.get().format(new Date(ctm)) + "-" + ctm % 1000;
	}

	private void saveImage(String imageName, ByteBuffer jpegBuffer, IntByReference retLen) {
		saveFile(captureImagePath + "/" + deviceNumber + "/" + imageName, jpegBuffer.array(), retLen.getValue());
	}

	// TODO Clean code
	// @Scheduled(fixedRate = 200)
	private void captureTaskDetect() {
		// boolean captureTaskFlag = false;
		boolean captureTaskFlag = true;
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

		faceSdkRecVo.setImage(byte2Base64Str(data));
		log.info("-------- size = {}", faceSdkRecVo.getImage().getBytes().length);

		asyncTask.detect(uuid, faceSdkRecVo);
	}

	/**
	 * rec
	 */
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

		byte[] data = image2byte("D://imga/input.jpeg");
		log.info("data.len=" + data.length);

		faceSdkRecVo.setImage(byte2Base64Str(data));
		String ret = httpTemplate.post("127.0.0.1", "3000", "/face/api/v1/rec", faceSdkRecVo, String.class);
		log.info(">>>rec cost" + (System.currentTimeMillis() - ctm) + " and ret=" + ret);
	}

}
