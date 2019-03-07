package com.microcore.center.service.impl;

import com.microcore.center.hcnetsdk.HCNetSDK;
import com.microcore.center.service.SdkService;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SdkServiceImpl implements SdkService {

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
     * 单帧数据捕获并保存成 JPEG 存放在指定的内存空间中
     *
     * @param lUserID
     * @param lChannel
     * @param lpJpegPara
     * @param sJpegPicBuffer
     * @param dwPicSize
     * @param lpSizeReturned
     * @return
     */
    @Override
    public boolean captureJpegPicture(NativeLong lUserID, NativeLong lChannel,
                                      HCNetSDK.NET_DVR_JPEGPARA lpJpegPara, String sJpegPicBuffer,
                                      int dwPicSize, IntByReference lpSizeReturned) {
        return sdk.NET_DVR_CaptureJPEGPicture_NEW(lUserID, lChannel, lpJpegPara,
                sJpegPicBuffer, dwPicSize, lpSizeReturned);
    }

    /**
     * 实时预览
     *
     * @param lUserID
     * @param lpClientInfo
     * @param fRealDataCallBack_V30
     * @param pUser
     * @param bBlocked
     * @return
     */
    @Override
    public NativeLong realPlay(NativeLong lUserID, HCNetSDK.NET_DVR_CLIENTINFO lpClientInfo,
                               HCNetSDK.FRealDataCallBack_V30 fRealDataCallBack_V30,
                               Pointer pUser, boolean bBlocked) {
        return sdk.NET_DVR_RealPlay_V30(lUserID, lpClientInfo, fRealDataCallBack_V30, pUser, bBlocked);
    }

    @Override
    public void realPlay(NativeLong lUserID, HCNetSDK.NET_DVR_CLIENTINFO lpClientInfo,
                         Pointer pUser, boolean bBlocked) {
        HCNetSDK.FRealDataCallBack_V30 fRealDataCallBack_V30 = (lRealHandle, dwDataType, pBuffer,
                                                                dwBufSize, pUser1) -> {
            // TODO 实时预览回调方法主体
        };

        NativeLong realPlay = realPlay(lUserID, lpClientInfo, fRealDataCallBack_V30, pUser, bBlocked);
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







            }
        };

        return sdk.NET_DVR_SetRealDataCallBack(lRealHandle, fRealDataCallBack, dwUser);
    }

}
