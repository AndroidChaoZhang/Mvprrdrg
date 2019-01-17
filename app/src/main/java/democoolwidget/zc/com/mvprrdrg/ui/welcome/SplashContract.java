package democoolwidget.zc.com.mvprrdrg.ui.welcome;

import democoolwidget.zc.com.mvprrdrg.base.IBasePresenter;
import democoolwidget.zc.com.mvprrdrg.base.IBaseView;

public interface SplashContract {

    interface View extends IBaseView {
        void jumpToMain();
    }

    interface  Presenter extends IBasePresenter<View> {
        void getWelcomeData();
    }
}
