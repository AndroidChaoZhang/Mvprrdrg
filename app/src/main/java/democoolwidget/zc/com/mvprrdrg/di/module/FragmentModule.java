package democoolwidget.zc.com.mvprrdrg.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import dagger.Module;
import dagger.Provides;
import democoolwidget.zc.com.mvprrdrg.di.scope.FragmentScope;

@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        return fragment.getActivity();
    }
}
