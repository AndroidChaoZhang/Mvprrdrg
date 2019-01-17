package democoolwidget.zc.com.mvprrdrg.di.component;

import android.app.Activity;

import dagger.Component;
import democoolwidget.zc.com.mvprrdrg.di.module.ActivityModule;
import democoolwidget.zc.com.mvprrdrg.di.scope.ActivityScope;
import democoolwidget.zc.com.mvprrdrg.ui.main.MainActivity;
import democoolwidget.zc.com.mvprrdrg.ui.welcome.SpalshActivity;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity activity();

    void inject(SpalshActivity welcomeActivity);
    void inject(MainActivity mainActivity);
}
