package democoolwidget.zc.com.mvprrdrg.ui.main.contract;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import democoolwidget.zc.com.mvprrdrg.base.IBasePresenter;
import democoolwidget.zc.com.mvprrdrg.base.IBaseView;

public interface RetrofitContract {
    interface View extends IBaseView {
        void reflushSwipeLayout();
    }

    interface  Presenter extends IBasePresenter<RetrofitContract.View> {
        void loadRecycleView (Context context,RecyclerView mRecycleviewGirl);
        void loadGirlData (boolean isReflush);
    }
}
