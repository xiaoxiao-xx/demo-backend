package com.rainyhon.task.service;

import com.rainyhon.common.hcnetsdk.HCNetSDK;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

import java.nio.ByteBuffer;

/**
 * 海康威视SDK服务封装
 */
public interface SdkService {

    NativeLong getUserId();

    void setSdk(HCNetSDK sdk);

    void startLogin(String deviceIp, Short devicePort, String username, String password);

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
    NativeLong loginDevice(String sDVRIP, short wDVRPort, String sUserName,
                           String sPassword, HCNetSDK.NET_DVR_DEVICEINFO_V30 lpDeviceInfo);

    /**
     * 单帧数据捕获并保存成 JPEG 存放在指定的内存空间中
     *
     * @param lUserID
     * @param lChannel
     * @param lpJpegPara
     * @param jpegBuffer
     * @param dwPicSize
     * @param lpSizeReturned
     * @return
     */
    boolean captureJpegPicture(NativeLong lUserID, NativeLong lChannel,
                               HCNetSDK.NET_DVR_JPEGPARA lpJpegPara,
                               ByteBuffer jpegBuffer, int dwPicSize,
                               IntByReference lpSizeReturned);

    /**
     * 实时预览
     *
     * @param lUserID
     * @param lpClientInfo
     * @param fRealDataCallBack_V30
     * @param pUser
     * @return
     */
    NativeLong realplay2sdk(NativeLong lUserID, HCNetSDK.NET_DVR_PREVIEWINFO lpClientInfo,
                            HCNetSDK.FRealDataCallBack_V30 fRealDataCallBack_V30,
                            Pointer pUser);

    void realplay(NativeLong lUserID, HCNetSDK.NET_DVR_PREVIEWINFO lpClientInfo,
                      Pointer pUser);

    boolean setRealDataFlow(NativeLong lRealHandle, HCNetSDK.FRowDataCallBack fRealDataCallBack, int dwUser);

    boolean setRealDataFlow(NativeLong lRealHandle, int dwUser);

    void errMsg();

}
