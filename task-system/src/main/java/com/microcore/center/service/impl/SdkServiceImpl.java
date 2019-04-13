package com.microcore.center.service.impl;

import com.microcore.center.hcnetsdk.HCNetSDK;
import com.microcore.center.service.SdkService;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.nio.ByteBuffer;

@Service
@Slf4j
public class SdkServiceImpl implements SdkService {

    /**
     * 设备IP
     */
    @Value("${nvr.device.ip}")
    private String deviceIp;

    /**
     * 设备Port
     */
    @Value("${nvr.device.port}")
    private Short devicePort;

    /**
     * 用户登录名
     */
    @Value("${login.username}")
    private String username;

    /**
     * 用户登录密码
     */
    @Value("${login.password}")
    private String password;

    private NativeLong lUserID;

    private void setUserId(NativeLong userId) {
        this.lUserID = userId;
    }

    @Override
    public NativeLong getUserId() {
        return this.lUserID;
    }

    private HCNetSDK sdk = HCNetSDK.INSTANCE;

    {
        // 初始化SDK
        boolean initSuc = sdk.NET_DVR_Init();
        if (!initSuc) {
            log.error("SDK初始化失败");
        } else {
            log.info("SDK初始化成功");
        }

        // 设置超时时间
        sdk.NET_DVR_SetConnectTime(12, 2);

    }

    @PostConstruct
    private void startlogin() {
        HCNetSDK.NET_DVR_DEVICEINFO_V30 netDvrDeviceinfoV30 = new HCNetSDK.NET_DVR_DEVICEINFO_V30();
        // TODO NET_DVR_DEVICEINFO_V30的具体参数待设置
        lUserID = loginDevice(deviceIp,
                devicePort,
                username,
                password,
                netDvrDeviceinfoV30);
        log.info("lUserID:"+lUserID.intValue());
        if (lUserID.intValue() < 0) {
            log.error("Login error");
            errMsg();
        }
        //调用视频预览
        HCNetSDK.NET_DVR_PREVIEWINFO ndPviewInfo= new HCNetSDK.NET_DVR_PREVIEWINFO();
        ndPviewInfo.lChannel=new NativeLong(2);
        ndPviewInfo.dwStreamType=0;
        ndPviewInfo.dwLinkMode=0;
        ndPviewInfo.hPlayWnd=null;
        ndPviewInfo.bBlocked=false;
        ndPviewInfo.bPassbackRecord=false;
        ndPviewInfo.byPreviewMode=0;
        ndPviewInfo.byStreamID=0;
        ndPviewInfo.byProtoType=0;
        ndPviewInfo.byVideoCodingType=0;
        ndPviewInfo.dwDisplayBufNum=0;
        ndPviewInfo.byRes=new byte[216];

        realplay(lUserID,ndPviewInfo,null);

    }

    /**
     * 向海康威视的服务器注册设备
     *
     * @param sDVRIP
     * @param wDVRPort
     * @param sUserName
     * @param sPassword
     * @param lpDeviceInfo
     * @return
     */
    @Override
    public NativeLong loginDevice(String sDVRIP, short wDVRPort, String sUserName,
                                  String sPassword, HCNetSDK.NET_DVR_DEVICEINFO_V30 lpDeviceInfo) {

        return sdk.NET_DVR_Login_V30(sDVRIP,
                wDVRPort,
                sUserName,
                sPassword,
                lpDeviceInfo);
    }

    /**
     * 实时预览
     *
     * @param lUserID
     * @param lpClientInfo
     * @param fRealDataCallBack_V30
     * @param pUser
     * @return
     */
    @Override
    public NativeLong realplay2sdk(NativeLong lUserID, HCNetSDK.NET_DVR_PREVIEWINFO lpClientInfo,
                                   HCNetSDK.FRealDataCallBack_V30 fRealDataCallBack_V30,
                                   Pointer pUser) {
        return sdk.NET_DVR_RealPlay_V40(lUserID, lpClientInfo, fRealDataCallBack_V30, pUser);
    }

    /**
     * 单帧数据捕获并保存成 JPEG 存放在指定的内存空间中
     *
     * @param lUserID
     * @param lChannel
     * @param lpJpegPara
     * @param dwPicSize
     * @param lpSizeReturned
     * @return
     */
    @Override
    public boolean captureJpegPicture(NativeLong lUserID, NativeLong lChannel,
                                      HCNetSDK.NET_DVR_JPEGPARA lpJpegPara, ByteBuffer jpegBuffer,
                                      int dwPicSize, IntByReference lpSizeReturned) {
        return sdk.NET_DVR_CaptureJPEGPicture_NEW(lUserID, lChannel, lpJpegPara,
                jpegBuffer, dwPicSize, lpSizeReturned);
    }

    @Override
    public void realplay(NativeLong lUserID, HCNetSDK.NET_DVR_PREVIEWINFO lpClientInfo,
                             Pointer pUser) {

        HCNetSDK.FRealDataCallBack_V30 fRealDataCallBack_V30 = (lRealHandle, dwDataType, pBuffer,
                                                                dwBufSize, pUser1) -> {
            // 实时预览回调函数实现
            switch (dwDataType) {
                case HCNetSDK.NET_DVR_SYSHEAD:
                    //TODO 码流中系统头处理
                    log.info("realplay2sdk callback SYSHEAD......dwBufSize="+dwBufSize);
                case HCNetSDK.NET_DVR_STREAMDATA:
                    //TODO 码流中视频流处理
                    log.info("realplay2sdk callback BODY......dwBufSize="+dwBufSize);
            }
        };

        NativeLong realPlay = realplay2sdk(lUserID, lpClientInfo, fRealDataCallBack_V30, pUser);
    }

    @Override
    public boolean setRealDataFlow(NativeLong lRealHandle, HCNetSDK.FRowDataCallBack fRealDataCallBack, int dwUser) {
        return sdk.NET_DVR_SetRealDataCallBack(lRealHandle, fRealDataCallBack, dwUser);
    }

    @Override
    public boolean setRealDataFlow(NativeLong lRealHandle, int dwUser) {
        HCNetSDK.FRowDataCallBack fRealDataCallBack = (lUserID, sIPAddr, lRowAmout,
                                                       pRecvDataBuffer, dwBufSize, dwUser1) -> {
            // 实时码流数据回调方法主体
            if (dwBufSize > 0) {
                // TODO Capture the data stream from NVR device
            }
        };

        return sdk.NET_DVR_SetRealDataCallBack(lRealHandle, fRealDataCallBack, dwUser);
    }

    /**
     * 输出错误信息
     */
    @Override
    public void errMsg() {
        // 获取最后的错误码
        int error = sdk.NET_DVR_GetLastError();
        log.error("Error: {}", error);
    }

    public static String byte2Base64Str(byte[] b){
        return Base64.encodeBase64String(b);
    }
}
