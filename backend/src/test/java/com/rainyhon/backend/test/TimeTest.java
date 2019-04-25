package com.rainyhon.backend.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

/**
 */
public class TimeTest {

    @Test
    public void testSdk() {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(Calendar.DAY_OF_WEEK);
        Assert.assertEquals(2, i);
    }

}
