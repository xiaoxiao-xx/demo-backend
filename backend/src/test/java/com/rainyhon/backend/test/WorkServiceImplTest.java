package com.rainyhon.backend.test;

import com.rainyhon.backend.BackendApplication;
import com.rainyhon.common.service.WorkService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest(classes = BackendApplication.class)
@RunWith(SpringRunner.class)
public class WorkServiceImplTest {

	@Autowired
	private WorkService workService;

	@Test
	public void testIsHoliday() {
		boolean holiday = workService.isHoliday(new Date());
		Assert.assertEquals(holiday, true);
	}

}
