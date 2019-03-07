package com.microcore.center.service;

import com.microcore.center.hcnetsdk.HCNetSDK;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

/**
 * 海康威视SDK服务封装
 */
public interface SdkService {

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
    NativeLong NET_DVR_Login_V30(String sDVRIP, short wDVRPort, String sUserName,
                                 String sPassword, HCNetSDK.NET_DVR_DEVICEINFO_V30 lpDeviceInfo);

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
    boolean captureJpegPicture(NativeLong lUserID, NativeLong lChannel,
                               HCNetSDK.NET_DVR_JPEGPARA lpJpegPara,
                               String sJpegPicBuffer, int dwPicSize,
                               IntByReference lpSizeReturned);

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
    NativeLong realPlay(NativeLong lUserID, HCNetSDK.NET_DVR_CLIENTINFO lpClientInfo,
                        HCNetSDK.FRealDataCallBack_V30 fRealDataCallBack_V30,
                        Pointer pUser, boolean bBlocked);
}
