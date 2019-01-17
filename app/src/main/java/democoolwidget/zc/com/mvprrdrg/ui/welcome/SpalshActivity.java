package democoolwidget.zc.com.mvprrdrg.ui.welcome;

import democoolwidget.zc.com.mvprrdrg.R;
import democoolwidget.zc.com.mvprrdrg.base.activity.BaseActivity;
import democoolwidget.zc.com.mvprrdrg.ui.main.MainActivity;

public class SpalshActivity extends BaseActivity<SplashPresenter> implements SplashContract.View {

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initEventAndData() {
        mPresenter.getWelcomeData();
    }

    @Override
    public void jumpToMain() {
        MainActivity.startMainActivity(this);
        finish();
    }

}
