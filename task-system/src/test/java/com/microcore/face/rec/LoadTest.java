package com.microcore.face.rec;

import com.google.gson.Gson;
import com.microcore.center.SlsTaskSystemApplication;
import com.microcore.center.cllient.HttpTemplate;
import com.microcore.center.task.CaptureTask2;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.vo.FaceSdkRecVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.microcore.center.util.CommonUtil.byte2Base64Str;

@Slf4j
@SpringBootTest(classes = SlsTaskSystemApplication.class)
@RunWith(SpringRunner.class)
public class LoadTest {

	private static final int poolSize = 10;

	@Autowired
	private HttpTemplate httpTemplate;

	@Value("${face.api.ip}")
	private String faceApiIp;

	@Value("${face.api.port}")
	private String faceApiPort;

	private List<CaptureTask2.FaceInfo> prepare() {
		FaceSdkRecVo faceSdkRecVo = new FaceSdkRecVo();
		faceSdkRecVo.setGroup_id("g1");
		faceSdkRecVo.setDevice_id("001");
		String seiralNo = "";
		faceSdkRecVo.setSeiralNo(seiralNo);

		byte[] tem = CommonUtil.image2byte("D:/imga/input4.jpg");
		String image = byte2Base64Str(tem);
		faceSdkRecVo.setImage(image);

		String ret = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v2/detect", faceSdkRecVo, String.class);
		Gson gson = new Gson();
		CaptureTask2.DetectResult result = gson.fromJson(ret, CaptureTask2.DetectResult.class);
		if (result == null) {
			return new ArrayList<>();
		}

		List<CaptureTask2.FaceInfo> faces = result.getFaces();
		if (faces == null) {
			faces = new ArrayList<>();
		}

		return faces;
	}

	/**
	 * 并发测试
	 */
	private void latchTest() throws InterruptedException {
		List<CaptureTask2.FaceInfo> list = prepare();

		final CountDownLatch start = new CountDownLatch(1);
		final CountDownLatch end = new CountDownLatch(poolSize);

		long t = System.currentTimeMillis();

		ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
		for (int i = 0; i < poolSize; i++) {
			Runnable run = () -> {
				try {
					start.await();
					testLoad(list);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					end.countDown();
				}
			};
			executorService.submit(run);
		}
		start.countDown();
		end.await();

		long t1 = System.currentTimeMillis() - t;
		log.info("total time: {}ms", t1);

		executorService.shutdown();
	}

	private void testLoad(List<CaptureTask2.FaceInfo> faces) {
		for (int i = 0; i < 1; i++) {
			faces.forEach(faceInfo -> {
				FaceSdkRecVo faceSdkRec = new FaceSdkRecVo();
				faceSdkRec.setGroup_id("g1");
				faceSdkRec.setDevice_id("001");
				String seiralNo = "";
				faceSdkRec.setSeiralNo(seiralNo);
				faceSdkRec.setImage(faceInfo.getBase64());

				long a = System.currentTimeMillis();
				String ret2 = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v2/rec", faceSdkRec, String.class);
				long b = System.currentTimeMillis() - a;
				log.info("rec: {}", b);

				// log.info("{}", ret2);
			});
		}
	}

	@Test
	public void testLoad() throws InterruptedException {
		latchTest();
	}

}
