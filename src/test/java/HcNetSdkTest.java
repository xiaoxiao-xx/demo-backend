import com.microcore.center.hcnetsdk.HCNetSDK;
import com.sun.jna.NativeLong;
import com.sun.jna.ptr.IntByReference;
import org.junit.Test;

/**
 * 主类 ：
 * 用途 ：
 * 容器：
 */
public class HcNetSdkTest {

    @Test
    public void testSdk() {
        HCNetSDK instance = HCNetSDK.INSTANCE;

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
        lUserID = instance.NET_DVR_Login_V30("127.0.0.1",
                (short) 8000,
                "admin",
                "12345",
                netDvrDeviceinfoV30);

        if (lUserID.intValue() < 0) {
            System.out.println("Login error");
            errMsg(instance);
            return;
        }

        HCNetSDK.NET_DVR_JPEGPARA jpegpara = new HCNetSDK.NET_DVR_JPEGPARA();
        jpegpara.wPicSize = 3;
        jpegpara.wPicQuality = 0;

        String jpegBuffer = "";
        boolean b = instance.NET_DVR_CaptureJPEGPicture_NEW(new NativeLong(23L), new NativeLong(1L), jpegpara,
                jpegBuffer, 2048, new IntByReference(2048));

        if (b) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        errMsg(instance);
    }

    private static void errMsg(HCNetSDK instance) {
        int error = instance.NET_DVR_GetLastError();
        System.out.println(error);
    }

}
