package democoolwidget.zc.com.mvprrdrg.ui.main.contract;

import android.support.v7.app.AppCompatActivity;

import democoolwidget.zc.com.mvprrdrg.base.IBasePresenter;
import democoolwidget.zc.com.mvprrdrg.base.IBaseView;
import democoolwidget.zc.com.mvprrdrg.ui.adapter.FragmentPagerAdapter;

public interface MainContract {

    interface View extends IBaseView {
        void showUpdateDialog(String versionContent);
        void loadFragment(FragmentPagerAdapter myViewPageAdapter);
    }

    interface  Presenter extends IBasePresenter<View> {
        void checkVersion(int currentVersion);
        void initFragment(AppCompatActivity activity);
    }
}
