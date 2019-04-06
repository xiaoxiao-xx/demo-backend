import com.microcore.center.cllient.HttpTemplate;
import com.microcore.center.hcnetsdk.HCNetSDK;
import com.microcore.center.service.impl.SdkServiceImpl;
import com.microcore.center.util.Encode;
import com.microcore.center.vo.FaceSdkRequestVo;
import com.sun.jna.Memory;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//  import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 主类 ：
 * 用途 ：
 * 容器：
 */
public class HcNetSdkTest {

    @Test
    public void testSdk() {
        System.out.println("----");
        HCNetSDK instance = HCNetSDK.INSTANCE;
        System.out.println("----");
        // 初始化SDK
        boolean initSuc = instance.NET_DVR_Init();
        if (!initSuc) {
            System.out.println("初始化失败");
        } else {
            System.out.println("初始化成功");
        }

        // 设置超时时间
        instance.NET_DVR_SetConnectTime(12,
                2);

        // 向海康威视的服务起注册设备
        NativeLong lUserID;
        HCNetSDK.NET_DVR_DEVICEINFO_V30 netDvrDeviceinfoV30 = new HCNetSDK.NET_DVR_DEVICEINFO_V30();
        lUserID = instance.NET_DVR_Login_V30("192.168.254.5",
                (short) 8000,
                "admin",
                "rain@1234",
                netDvrDeviceinfoV30);

        if (lUserID.intValue() < 0) {
            System.out.println("Login error");
            errMsg(instance);
            return;
        }
        System.out.println("netDvrDeviceinfoV30="+netDvrDeviceinfoV30.byIPChanNum +"|"+netDvrDeviceinfoV30.byStartChan);

        HCNetSDK.NET_DVR_JPEGPARA jpegpara = new HCNetSDK.NET_DVR_JPEGPARA();
        jpegpara.wPicSize = 3;
        jpegpara.wPicQuality = 0;

       /* String jpegBuffer = "";
        Pointer p = new Memory(200*1024);
        boolean b = instance.NET_DVR_CaptureJPEGPicture_NEW(lUserID, new NativeLong(36L), jpegpara,
                p, 2048, new IntByReference(2048));
        errMsg(instance);

        System.out.println(jpegBuffer);*/
       //抓图到文件begin
        /*
       Long beginTime = System.currentTimeMillis();
       for (int i=0;i<500;i++) {
           boolean b = instance.NET_DVR_CaptureJPEGPicture(lUserID, new NativeLong(1L), jpegpara,
                   "D:/img/" + System.currentTimeMillis() / 1000 + "-" + i + ".jpeg");
           errMsg(instance);
       }
        Long endTime = System.currentTimeMillis();
       System.out.println("cost time="+(endTime-beginTime));
       */
       //抓图到文件end

        long startl = System.currentTimeMillis();
        ByteBuffer jpegBuffer = ByteBuffer.allocate(8*1024 * 1024);
        IntByReference a = new IntByReference();
        FaceSdkRequestVo requestVo = new FaceSdkRequestVo();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        for (int i = 0; i < 1; i++) {
            boolean is = instance.NET_DVR_CaptureJPEGPicture_NEW(lUserID, new NativeLong(1L) , jpegpara,
                    jpegBuffer, 8*1024 * 1024, a);
            if (is){
                Long ctm = System.currentTimeMillis();
                System.out.println(df.format(new Date(ctm))+ctm%1000);

                System.out.println("byteLength:"+a.getValue()+";"+jpegBuffer.array().length);
//                System.out.println(Encode.byte2Base64Str(jpegBuffer.array()));


              }

        BufferedOutputStream outputStream = null;
        try {
            outputStream = new BufferedOutputStream(new FileOutputStream(new File("D:/img/" + System.currentTimeMillis() / 1000 + "-" +i+ ".jpeg")));
            outputStream.write(jpegBuffer.array(), 0, a.getValue());
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        }
        System.out.println("cost:"+(System.currentTimeMillis()-startl));
//        System.out.println(jpegBuffer);

        /*try {
            OutputStream os = new FileOutputStream("D:/img/"+System.currentTimeMillis()+".jpeg");
            os.write(ba, 0, ba.length);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
/*
        if (b) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
*/



        //调用视频预览
    /*
        HCNetSDK.NET_DVR_PREVIEWINFO ndPviewInfo= new HCNetSDK.NET_DVR_PREVIEWINFO();
        ndPviewInfo.lChannel=new NativeLong(36);
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
        HCNetSDK.FRealDataCallBack_V30 fRealDataCallBack_V30 = (lRealHandle, dwDataType, pBuffer,
                                                                dwBufSize, pUser1) -> {
//            System.out.println("realplay2sdk callback in......dwBufSize="+dwBufSize);
            // 实时预览回调函数实现
            switch (dwDataType) {
                                case HCNetSDK.NET_DVR_SYSHEAD:
                    //TODO 码流中系统头处理
//                    System.out.println("realplay2sdk callback SYSHEAD......dwBufSize="+dwBufSize);
                case HCNetSDK.NET_DVR_STREAMDATA:
                    //TODO 码流中视频流处理
//                    System.out.println("realplay2sdk callback BODY......dwBufSize="+dwBufSize);
                    byte[] ba = pBuffer.getPointer().getByteArray(0,dwBufSize);
//                    System.out.println(ba.length);



//                        try {
//                            OutputStream os = new FileOutputStream("D:/img/"+System.currentTimeMillis()+".jpg");
//                            os.write(ba, 0, ba.length);
//                            os.flush();
//                            os.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }


            }
        };

        NativeLong realPlay = new SdkServiceImpl().realplay2sdk(lUserID, ndPviewInfo, fRealDataCallBack_V30, null);
       System.out.println("realPlay="+realPlay);
        */
       errMsg(instance);
        instance.NET_DVR_Logout(lUserID);
        instance.NET_DVR_Cleanup();
    }

    private static void errMsg(HCNetSDK instance) {
        int error = instance.NET_DVR_GetLastError();
        System.out.println(error);
    }

}
