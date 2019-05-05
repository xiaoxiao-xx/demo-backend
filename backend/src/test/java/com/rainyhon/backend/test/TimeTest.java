package com.rainyhon.backend.test;

import com.rainyhon.common.util.Object2Byte;
import com.rainyhon.common.vo.UserInfo;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

/**
 *
 */
public class TimeTest {

	@Test
	public void testSdk() {
		Calendar calendar = Calendar.getInstance();
		int i = calendar.get(Calendar.DAY_OF_WEEK);
		Assert.assertEquals(2, i);
	}

	@Test
	public void tomorrow() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		System.out.println(cal.getTime());
	}


	@Test
	public void SerializationTest() {
		UserInfo userInfo = new UserInfo();
		userInfo.setOrgId("org-1");
		userInfo.setId("id-2");
		byte[] bytes = Object2Byte.getBytesFromObject(userInfo);
		UserInfo info = Object2Byte.getObjectFromBytes(bytes);
		Assert.assertEquals(info.getOrgId(), "org-1");
		Assert.assertEquals(info.getId(), "id-2");
	}

}
