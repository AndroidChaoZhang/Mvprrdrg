package democoolwidget.zc.com.mvprrdrg.base.activity;

import android.content.DialogInterface;

import javax.inject.Inject;

import democoolwidget.zc.com.mvprrdrg.MyApplication;
import democoolwidget.zc.com.mvprrdrg.base.IBasePresenter;
import democoolwidget.zc.com.mvprrdrg.base.IBaseView;
import democoolwidget.zc.com.mvprrdrg.di.component.ActivityComponent;
import democoolwidget.zc.com.mvprrdrg.di.component.DaggerActivityComponent;
import democoolwidget.zc.com.mvprrdrg.di.module.ActivityModule;

/**MVP activity基类*/
public abstract class BaseActivity<T extends IBasePresenter> extends ToolbarActivity implements IBaseView {

    @Inject
    protected T mPresenter;

    protected ActivityComponent getActivityComponent () {
        return DaggerActivityComponent.builder().
                appComponent(MyApplication.getAppComponent()).
                activityModule(getActivityModule()).
                build();
    }
    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }

    @Override
    protected void initView() {
        super.initView();
        initInject();
        if (null!=mPresenter) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        if (null!=mPresenter) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    @Override
    public void showErrorMsg(String msg) {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
        builder.setMessage(msg);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.show();
    }

    protected abstract void initInject();

}
