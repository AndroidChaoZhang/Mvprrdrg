package democoolwidget.zc.com.mvprrdrg.ui.main.fragment;


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import democoolwidget.zc.com.mvprrdrg.R;
import democoolwidget.zc.com.mvprrdrg.base.fragment.BaseFragment;
import democoolwidget.zc.com.mvprrdrg.ui.main.contract.RetrofitContract;
import democoolwidget.zc.com.mvprrdrg.ui.main.presenter.RetrofitPresenter;

public class RetrofitFragment extends BaseFragment<RetrofitPresenter> implements RetrofitContract.View, SwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.recycleview_girl)
    RecyclerView mRecycleviewGirl;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefresh;


    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_beautiful_girl;
    }

    @Override
    protected void initEventAndData() {
        mSwipeRefresh.setOnRefreshListener(this);
        mPresenter.loadRecycleView(mContext,mRecycleviewGirl);
        mPresenter.loadGirlData(true);
    }

    @Override
    public void onRefresh() {
        mPresenter.loadGirlData(false);
    }

    @Override
    public void reflushSwipeLayout() {
        if(mSwipeRefresh.isRefreshing()) {
            mSwipeRefresh.setRefreshing(false);
        }
    }
}
