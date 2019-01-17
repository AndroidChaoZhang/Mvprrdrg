package democoolwidget.zc.com.mvprrdrg.ui.main.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import democoolwidget.zc.com.mvprrdrg.base.RxPresenter;
import democoolwidget.zc.com.mvprrdrg.model.bean.GirlItemBean;
import democoolwidget.zc.com.mvprrdrg.model.manager.DataManager;
import democoolwidget.zc.com.mvprrdrg.ui.adapter.GirlAdapter;
import democoolwidget.zc.com.mvprrdrg.ui.main.contract.RealmContract;

public class RealmPresenter extends RxPresenter<RealmContract.View> implements RealmContract.Presenter{

    private GirlAdapter mGirlAdapter;
    private DataManager mDataManager;
    private List<GirlItemBean> girlInfoList = new ArrayList<>();

    @Inject
    public RealmPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void loadRecycleView(Context context, RecyclerView mRecycleviewGirl) {
        mRecycleviewGirl.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mGirlAdapter = new GirlAdapter(context,girlInfoList);
        mRecycleviewGirl.setAdapter(mGirlAdapter);
    }

    @Override
    public void loadGirlData() {
        List<GirlItemBean> girlList = mDataManager.getGirlList();
        mGirlAdapter.replaceData(girlList);
        mView.reflushSwipeLayout();
    }

}
