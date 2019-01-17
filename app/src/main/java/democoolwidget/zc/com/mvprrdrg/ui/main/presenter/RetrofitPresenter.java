package democoolwidget.zc.com.mvprrdrg.ui.main.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import democoolwidget.zc.com.mvprrdrg.base.RxPresenter;
import democoolwidget.zc.com.mvprrdrg.model.bean.GirlItemBean;
import democoolwidget.zc.com.mvprrdrg.model.consts.PrefConstants;
import democoolwidget.zc.com.mvprrdrg.model.manager.DataManager;
import democoolwidget.zc.com.mvprrdrg.model.network.resp.HttpResponse;
import democoolwidget.zc.com.mvprrdrg.rx.CommonSubscriber;
import democoolwidget.zc.com.mvprrdrg.rx.RxUtil;
import democoolwidget.zc.com.mvprrdrg.ui.adapter.GirlAdapter;
import democoolwidget.zc.com.mvprrdrg.ui.main.contract.RetrofitContract;
import democoolwidget.zc.com.mvprrdrg.utils.JsonUtils;

public class RetrofitPresenter extends RxPresenter<RetrofitContract.View> implements RetrofitContract.Presenter {

    private DataManager mDataManager;
    private List<GirlItemBean> girlInfoList = new ArrayList<>();
    private GirlAdapter mGirlAdapter;
    private static final int NUMBER = 10;
    private int page = 0;

    @Inject
    public RetrofitPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }


    @Override
    public void loadRecycleView(Context mContext,RecyclerView mRecycleviewGirl) {
        mRecycleviewGirl.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mGirlAdapter = new GirlAdapter(mContext,girlInfoList);
        mRecycleviewGirl.setAdapter(mGirlAdapter);
    }

    @Override
    public void loadGirlData(boolean isReflush) {
        if (isReflush) {
            page = 0;
        } else {
            page++;
        }
        addSubscribe(mDataManager.getGirlListInfo(NUMBER,page)
        .compose(RxUtil.<HttpResponse<List<GirlItemBean>>>rxSchedulerHelper())
        .compose(RxUtil.<List<GirlItemBean>>handleResult())
        .subscribeWith(new CommonSubscriber<List<GirlItemBean>>(mView) {
            @Override
            public void onNext(List<GirlItemBean> girlItemBeans) {
                mGirlAdapter.replaceData(girlItemBeans);
                mView.reflushSwipeLayout();
                mDataManager.insertGirlList(girlItemBeans);
                mDataManager.setPrefString(PrefConstants.BEAUTIFUL_GIRL_DATA, JsonUtils.toJson(girlItemBeans));
            }
        }));
    }
}
