package democoolwidget.zc.com.mvprrdrg.model.consts;

import java.io.File;

import democoolwidget.zc.com.mvprrdrg.MyApplication;

public class Constants {

    public static final String PATH_DATA = MyApplication.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = PATH_DATA + "/netCache";
}
