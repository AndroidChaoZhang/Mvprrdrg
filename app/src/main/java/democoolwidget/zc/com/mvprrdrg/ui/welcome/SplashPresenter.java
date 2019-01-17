package democoolwidget.zc.com.mvprrdrg.ui.welcome;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import democoolwidget.zc.com.mvprrdrg.base.RxPresenter;
import democoolwidget.zc.com.mvprrdrg.rx.RxUtil;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

public class SplashPresenter extends RxPresenter<SplashContract.View>implements SplashContract.Presenter{

    private static final int COUNT_DOWN_TIME = 3 * 1000;

    @Inject
    public SplashPresenter() {
    }

    @Override
    public void getWelcomeData() {
        addSubscribe(Flowable.interval(COUNT_DOWN_TIME, TimeUnit.MILLISECONDS)
                .take(1)
                .compose(RxUtil.<Long>rxSchedulerHelper())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) {
                        mView.jumpToMain();
                    }
                }));

    }

}
