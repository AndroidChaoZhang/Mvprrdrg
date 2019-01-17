package democoolwidget.zc.com.mvprrdrg;

import android.support.multidex.MultiDexApplication;

import democoolwidget.zc.com.mvprrdrg.di.component.AppComponent;
import democoolwidget.zc.com.mvprrdrg.di.component.DaggerAppComponent;
import democoolwidget.zc.com.mvprrdrg.di.module.AppModule;
import democoolwidget.zc.com.mvprrdrg.di.module.HttpModule;
import io.realm.Realm;

public class MyApplication extends MultiDexApplication {
    private static MyApplication instance;
    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //初始化数据库
        Realm.init(getApplicationContext());
    }

    public static MyApplication getInstance() {
        return instance;
    }

    public static AppComponent getAppComponent(){
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .httpModule(new HttpModule())
                    .build();
        }
        return appComponent;
    }


}
