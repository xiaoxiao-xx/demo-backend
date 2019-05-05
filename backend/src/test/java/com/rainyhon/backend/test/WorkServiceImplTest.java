package com.rainyhon.backend.test;

import com.rainyhon.backend.BackendApplication;
import com.rainyhon.common.cllient.HttpTemplate;
import com.rainyhon.common.service.WorkService;
import com.rainyhon.common.vo.FaceSdkUserVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest(classes = BackendApplication.class)
@RunWith(SpringRunner.class)
@Slf4j
public class WorkServiceImplTest {

	@Autowired
	private WorkService workService;

	@Test
	public void testIsHoliday() {
		boolean holiday = workService.isHoliday(new Date());
		Assert.assertEquals(holiday, true);
	}

	@Autowired
	private HttpTemplate httpTemplate;

	@Test
	public void deleteUser() {
		FaceSdkUserVo faceSdkUserVo = new FaceSdkUserVo();
		faceSdkUserVo.setGroup_id("g1");
		faceSdkUserVo.setUser_id("b9c79c7257ce47628711188498c24078");
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		Long ctm = System.currentTimeMillis();
		String seiralNo = df.format(new Date(ctm)) + "-" + ctm % 1000;
		faceSdkUserVo.setSeiralNo("uDel-" + seiralNo);

		String ret = httpTemplate.post("192.168.254.136", "80", "/face/api/v2/user_delete", faceSdkUserVo, String.class);
		log.info(">>>userDel ret=" + ret);
	}

}
