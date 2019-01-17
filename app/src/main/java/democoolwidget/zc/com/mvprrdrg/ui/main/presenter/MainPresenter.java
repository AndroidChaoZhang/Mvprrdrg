package democoolwidget.zc.com.mvprrdrg.ui.main.presenter;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import democoolwidget.zc.com.mvprrdrg.base.RxPresenter;
import democoolwidget.zc.com.mvprrdrg.model.bean.NetworkBean;
import democoolwidget.zc.com.mvprrdrg.model.manager.DataManager;
import democoolwidget.zc.com.mvprrdrg.rx.CommonSubscriber;
import democoolwidget.zc.com.mvprrdrg.rx.RxUtil;
import democoolwidget.zc.com.mvprrdrg.ui.adapter.FragmentPagerAdapter;
import democoolwidget.zc.com.mvprrdrg.ui.main.contract.MainContract;
import democoolwidget.zc.com.mvprrdrg.ui.main.fragment.PreferenceFragment;
import democoolwidget.zc.com.mvprrdrg.ui.main.fragment.RealmFragment;
import democoolwidget.zc.com.mvprrdrg.ui.main.fragment.RetrofitFragment;
import io.reactivex.functions.Function;

public class MainPresenter extends RxPresenter<MainContract.View> implements  MainContract.Presenter{

    private DataManager mDataManager;

    @Inject
    public MainPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void checkVersion(final int currentVersion) {
        addSubscribe(mDataManager.fetchVersion()
                        .compose(RxUtil.<NetworkBean>rxSchedulerHelper())
                        .map(new Function<NetworkBean, Boolean>() {
                            @Override
                            public Boolean apply(NetworkBean versionBean) {
                                return versionBean.error;
                            }

                        })
                        .subscribeWith(new CommonSubscriber<Boolean>(mView) {
                                @Override
                                public void onNext(Boolean result) {
                                    if (!result) {
                                        mView.showUpdateDialog("美女图片已连接");
                                    }
                                }
                            })
                        );
    }

    @Override
    public void initFragment(AppCompatActivity activity) {
        List<String> listTitle = new ArrayList<>();
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        listTitle.add("RETROFIT");
        listTitle.add("REALM");
        listTitle.add("PREFERENCES");
        fragmentList.add(new RetrofitFragment());
        fragmentList.add(new RealmFragment());
        fragmentList.add(new PreferenceFragment());
        FragmentPagerAdapter myViewPageAdapter = new FragmentPagerAdapter(activity.getSupportFragmentManager(),fragmentList, listTitle);
        mView.loadFragment(myViewPageAdapter);
    }
}
