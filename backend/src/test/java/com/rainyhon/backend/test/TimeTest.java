package com.rainyhon.backend.test;

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

}
