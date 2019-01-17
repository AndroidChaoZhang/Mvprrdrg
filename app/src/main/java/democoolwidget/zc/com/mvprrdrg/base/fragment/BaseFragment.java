package democoolwidget.zc.com.mvprrdrg.base.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import javax.inject.Inject;

import democoolwidget.zc.com.mvprrdrg.MyApplication;
import democoolwidget.zc.com.mvprrdrg.base.IBasePresenter;
import democoolwidget.zc.com.mvprrdrg.base.IBaseView;
import democoolwidget.zc.com.mvprrdrg.di.component.DaggerFragmentComponent;
import democoolwidget.zc.com.mvprrdrg.di.component.FragmentComponent;
import democoolwidget.zc.com.mvprrdrg.di.module.FragmentModule;

/**MVP Fragment基类*/
public abstract class BaseFragment<T extends IBasePresenter> extends SimpleFragment implements IBaseView {
    @Inject
    protected T mPresenter;

    protected FragmentComponent getFragmentComponent(){
        return DaggerFragmentComponent.builder()
                .appComponent(MyApplication.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initInject();
        mPresenter.attachView(this);
        super.onViewCreated(view, savedInstanceState);
    }

    protected FragmentModule getFragmentModule(){
        return new FragmentModule(this);
    }

    @Override
    public void showErrorMsg(String msg) {

    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroyView();
    }


    protected abstract void initInject();

}
