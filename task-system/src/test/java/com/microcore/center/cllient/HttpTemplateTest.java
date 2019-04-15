package com.microcore.center.cllient;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HttpTemplateTest extends TestCase {

    @Autowired
    private HttpTemplate httpTemplate;

    @Test
    public void testGet() {
        String s = httpTemplate.get("163.com", "80", "/", String.class);
        System.out.println(s);
    }

    @Test
    public void testPost() {
        String s = httpTemplate.post("163.com", "80", "/", null, String.class);
        System.out.println(s);
    }


    @Test
    public void testDateFormat() throws InterruptedException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        for (int i = 0; i < 10; i++) {
            Date now = new Date();
            String s = format.format(now);
            System.out.println(s);
            Thread.sleep(500L);
        }
    }

}