package democoolwidget.zc.com.mvprrdrg.di.component;

import android.app.Activity;

import dagger.Component;
import democoolwidget.zc.com.mvprrdrg.di.module.FragmentModule;
import democoolwidget.zc.com.mvprrdrg.di.scope.FragmentScope;
import democoolwidget.zc.com.mvprrdrg.ui.main.fragment.PreferenceFragment;
import democoolwidget.zc.com.mvprrdrg.ui.main.fragment.RealmFragment;
import democoolwidget.zc.com.mvprrdrg.ui.main.fragment.RetrofitFragment;

/**
 * Created by codeest on 16/8/7.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(RetrofitFragment beautifulGirlFragment);
    void inject(RealmFragment androidFragment);
    void inject(PreferenceFragment preferenceFragment);

}
