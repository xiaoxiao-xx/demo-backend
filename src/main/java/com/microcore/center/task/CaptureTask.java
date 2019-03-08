package com.microcore.center.task;

import com.microcore.center.hcnetsdk.HCNetSDK;
import com.microcore.center.service.SdkService;
import com.sun.jna.NativeLong;
import com.sun.jna.ptr.IntByReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时截图工具类
 */
@Component
public class CaptureTask {

    @Autowired
    private SdkService sdkService;

    /**
     * 200ms心跳一次
     */
    @Scheduled(fixedRate = 200)
    private void captureTask() {
        NativeLong channel = new NativeLong(2);
        HCNetSDK.NET_DVR_JPEGPARA lpJpegPara = new HCNetSDK.NET_DVR_JPEGPARA();
        // lpJpegPara.setAutoRead();
        String sJpegPicBuffer = "";
        int dwPicSize = 1024;
        IntByReference lpSizeReturned = new IntByReference(2);
        NativeLong userId = sdkService.getUserId();
        boolean result = sdkService.captureJpegPicture(userId, channel, lpJpegPara, sJpegPicBuffer, dwPicSize, lpSizeReturned);
        if (!result) {
            sdkService.errMsg();
        }
    }

}
