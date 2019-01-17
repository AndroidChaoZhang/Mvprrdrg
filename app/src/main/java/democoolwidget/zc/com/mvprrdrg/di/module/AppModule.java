package democoolwidget.zc.com.mvprrdrg.di.module;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import democoolwidget.zc.com.mvprrdrg.MyApplication;
import democoolwidget.zc.com.mvprrdrg.model.manager.DataManager;
import democoolwidget.zc.com.mvprrdrg.model.db.DBHelper;
import democoolwidget.zc.com.mvprrdrg.model.db.RealmHelper;
import democoolwidget.zc.com.mvprrdrg.model.network.RetrofitHelper;
import democoolwidget.zc.com.mvprrdrg.model.network.resp.HttpHelper;
import democoolwidget.zc.com.mvprrdrg.model.prefs.ImplPreferencesHelper;
import democoolwidget.zc.com.mvprrdrg.model.prefs.PreferencesHelper;

@Module
public class AppModule {
    private final MyApplication application;

    public AppModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    MyApplication provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton//直接返回的类RetrofitHelper，它们类的构造函数一定要加上@Inject的注解
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

    @Provides
    @Singleton//直接返回的类RetrofitHelper，它们类的构造函数一定要加上@Inject的注解
    DBHelper provideDBHelper(RealmHelper realmHelper) {
        return realmHelper;
    }

    @Provides
    @Singleton//直接返回的类RetrofitHelper，它们类的构造函数一定要加上@Inject的注解
    PreferencesHelper providePreferencesHelper(ImplPreferencesHelper implPreferencesHelper) {
        return implPreferencesHelper;
    }

    //返回参数和入参是继承关系才可以直接返回，不然new 否则会报一个循环依赖的错误
    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, DBHelper DBHelper, PreferencesHelper preferencesHelper) {
        return new DataManager(httpHelper, DBHelper, preferencesHelper);
    }
}
