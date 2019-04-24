package com.microcore.center.task.rec.v2;

import com.microcore.center.constant.Constants;
import com.microcore.center.hcnetsdk.HCNetSDK;
import com.microcore.center.model.PsmMaterial;
import com.microcore.center.service.MaterialService;
import com.microcore.center.service.SdkService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.vo.FaceSdkRecVo;
import com.sun.jna.NativeLong;
import com.sun.jna.ptr.IntByReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.microcore.center.util.CommonUtil.byte2Base64Str;
import static com.microcore.center.util.CommonUtil.saveFile;

/**
 * 定时截图工具类
 */
@Slf4j
@Component
public class CaptureTask {

	private final SdkService sdkService;

	private final MaterialService materialService;

	private final AsyncTaskDetect asyncTaskDetect;

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
	public CaptureTask(SdkService sdkService, MaterialService materialService, AsyncTaskDetect asyncTask) {
		this.sdkService = sdkService;
		this.materialService = materialService;
		this.asyncTaskDetect = asyncTask;
	}

	/**
	 * 200ms心跳一次
	 */
	@Scheduled(fixedRate = 10000)
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
			// Save image
			String now = dateFormat.get().format(new Date());
			String imageName = "" + now + ".jpeg";
			if (Constants.YES.toLowerCase().equals(generateImageFile)) {
				saveImage(imageName, jpegBuffer, retLen);
			}

			byte[] temp = new byte[retLen.getValue()];
			jpegBuffer.get(temp, 0, retLen.getValue());

			// TODO for testing
//			temp = CommonUtil.image2byte("D:/imga/input4.jpg");

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
			asyncTaskDetect.detect(uuid, faceSdkRecVo);
		} else {
			sdkService.errMsg();
		}
	}

	// @Scheduled(fixedRate = 15000)
	private void captureTaskss() {
		// 封装请求Json
		FaceSdkRecVo faceSdkRecVo = new FaceSdkRecVo();
		faceSdkRecVo.setGroup_id("g1");

		// 需要设备ID 如摄像头
		faceSdkRecVo.setDevice_id("001");

		// 获得seiralNo
		String seiralNo = getSerialNumber();
		faceSdkRecVo.setSeiralNo(seiralNo);

		boolean result = true;
		if (result) {
			// TODO for testing
			log.info("-1--------------------------------");
			byte[] tem = CommonUtil.image2byte("D:/imga/input4.jpg");
			String image = byte2Base64Str(tem);

			String now = dateFormat.get().format(new Date());
			String imageName = "" + now + ".jpeg";

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
			asyncTaskDetect.detect(uuid, faceSdkRecVo);


			log.info("----------------------------------");
			tem = CommonUtil.image2byte("D:/imga/input5.jpg");
			image = byte2Base64Str(tem);
			now = dateFormat.get().format(new Date());
			imageName = "" + now + ".jpeg";
			faceSdkRecVo.setImage(image);
			seiralNo = getSerialNumber();
			faceSdkRecVo.setSeiralNo(seiralNo);

			// log.info("-------- size = {}", faceSdkRecVo.getImage().getBytes().length);
			asyncTaskDetect.detect(uuid, faceSdkRecVo);
			log.info("-2--------------------------------");
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

}

