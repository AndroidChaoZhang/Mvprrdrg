package democoolwidget.zc.com.mvprrdrg.di.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import democoolwidget.zc.com.mvprrdrg.di.scope.ActivityScope;

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity () {
        return mActivity;
    }
}
