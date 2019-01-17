package democoolwidget.zc.com.mvprrdrg.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.WindowManager;

import democoolwidget.zc.com.mvprrdrg.MyApplication;

public class AppUtil {

    public static int WINDOW_WIDTH = 0;
    public static int WINDOW_HEIGHT = 0;
    
    public static int getVersionCode() {
        int versionCode = 0;
        try {
            PackageInfo info = MyApplication.getInstance().getPackageManager().getPackageInfo(
                    MyApplication.getInstance().getPackageName(), 0);
            versionCode = info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {}
        return versionCode;
    }

    /**获取屏幕宽度*/
    public static int getWindowWidth () {
        if (WINDOW_WIDTH >= 450) {
            return WINDOW_WIDTH;
        }
        WindowManager windowManager = (WindowManager)MyApplication.getInstance().getSystemService(Context.WINDOW_SERVICE);
        int width = windowManager.getDefaultDisplay().getWidth();
        WINDOW_WIDTH = width;
        return  width;
    }

    /**获取屏幕高度*/
    public static int getWindowHeight () {
        if (WINDOW_HEIGHT >= 800) {
            return WINDOW_HEIGHT;
        }
        WindowManager windowManager = (WindowManager)MyApplication.getInstance().getSystemService(Context.WINDOW_SERVICE);
        int height = windowManager.getDefaultDisplay().getHeight();
        WINDOW_HEIGHT = height ;
        return  height;
    }


}
