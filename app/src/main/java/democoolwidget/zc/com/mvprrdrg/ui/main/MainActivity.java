package democoolwidget.zc.com.mvprrdrg.ui.main;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import democoolwidget.zc.com.mvprrdrg.R;
import democoolwidget.zc.com.mvprrdrg.base.activity.BaseActivity;
import democoolwidget.zc.com.mvprrdrg.ui.adapter.FragmentPagerAdapter;
import democoolwidget.zc.com.mvprrdrg.ui.main.contract.MainContract;
import democoolwidget.zc.com.mvprrdrg.ui.main.presenter.MainPresenter;
import democoolwidget.zc.com.mvprrdrg.utils.AppUtil;
import democoolwidget.zc.com.mvprrdrg.utils.DialogUtil;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.tool_bar)
    Toolbar mToolbar;
    @BindView(R.id.vp_view)
    ViewPager mVpView;
    @BindView(R.id.tablayout)
    TabLayout mTableLayout;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        setToolBar(mToolbar, "MVP首页");
        mPresenter.checkVersion(AppUtil.getVersionCode());
        mPresenter.initFragment(this);
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void showUpdateDialog(String versionContent) {
        DialogUtil.alertVersionDialog(this,versionContent);
    }

    @Override
    public void loadFragment(FragmentPagerAdapter myViewPageAdapter) {
        mVpView.setAdapter(myViewPageAdapter);
        mTableLayout.setupWithViewPager(mVpView);
    }

    public static void startMainActivity (Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

}
