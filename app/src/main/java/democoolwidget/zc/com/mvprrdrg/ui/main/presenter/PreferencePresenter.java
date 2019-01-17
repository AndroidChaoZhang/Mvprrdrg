package democoolwidget.zc.com.mvprrdrg.ui.main.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import democoolwidget.zc.com.mvprrdrg.base.RxPresenter;
import democoolwidget.zc.com.mvprrdrg.model.bean.GirlItemBean;
import democoolwidget.zc.com.mvprrdrg.model.consts.PrefConstants;
import democoolwidget.zc.com.mvprrdrg.model.manager.DataManager;
import democoolwidget.zc.com.mvprrdrg.ui.adapter.GirlAdapter;
import democoolwidget.zc.com.mvprrdrg.ui.main.contract.PreferenceContract;
import democoolwidget.zc.com.mvprrdrg.utils.JsonUtils;

public class PreferencePresenter extends RxPresenter<PreferenceContract.View> implements PreferenceContract.Presenter{

    private GirlAdapter mGirlAdapter;
    private DataManager mDataManager;
    private List<GirlItemBean> girlInfoList = new ArrayList<>();

    @Inject
    public PreferencePresenter(DataManager dataManager) {
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
        String beautiful_girl_data = mDataManager.getPrefString(PrefConstants.BEAUTIFUL_GIRL_DATA,"");
        if (!TextUtils.isEmpty(beautiful_girl_data)) {
            mGirlAdapter.replaceData(JsonUtils.getStringTList(beautiful_girl_data,GirlItemBean.class));
            mView.reflushSwipeLayout();
        }
    }

}
