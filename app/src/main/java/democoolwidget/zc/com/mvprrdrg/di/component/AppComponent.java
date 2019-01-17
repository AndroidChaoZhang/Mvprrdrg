package democoolwidget.zc.com.mvprrdrg.di.component;

import javax.inject.Singleton;

import dagger.Component;
import democoolwidget.zc.com.mvprrdrg.MyApplication;
import democoolwidget.zc.com.mvprrdrg.di.module.AppModule;
import democoolwidget.zc.com.mvprrdrg.di.module.HttpModule;
import democoolwidget.zc.com.mvprrdrg.model.manager.DataManager;
import democoolwidget.zc.com.mvprrdrg.model.db.RealmHelper;
import democoolwidget.zc.com.mvprrdrg.model.network.RetrofitHelper;
import democoolwidget.zc.com.mvprrdrg.model.prefs.ImplPreferencesHelper;

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    MyApplication getContext();  // 提供App的Context

    DataManager getDataManager(); //数据中心

    RetrofitHelper retrofitHelper();  //提供http的帮助类

    RealmHelper realmHelper();    //提供数据库帮助类

    ImplPreferencesHelper preferencesHelper(); //提供sp帮助类

}
